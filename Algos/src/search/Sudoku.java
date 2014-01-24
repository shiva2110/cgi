package search;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import heap.Heap;



public class Sudoku {

	public class cell {
		int i;
		int j;
		
		
		public cell(int i, int j) {
			this.i = i;
			this.j = j;
		}
		
		@Override
		public boolean equals(Object anotherCell) {
			if(!(anotherCell instanceof cell)) {
				return false;
			}
			
			if(this == anotherCell) {
				return true;
			}
			
			cell another = (cell)anotherCell;
			
			if(this.i==another.i && this.j==another.j) {
				return true;
			}
			return false;
		}
		
		@Override
		public int hashCode() {
			int m = 1031;
			return (i%m + 7*(j%m));
		}
	}
	
	int[][] matrix;
	Heap<SudokuSlot> heap;
	Map<cell, Integer> cellHeapIndexMap = new HashMap<cell, Integer>();
	
	public Sudoku(int[][] matrix) {
		this.matrix = matrix;
		this.heap = new Heap<SudokuSlot>(81, new SudokuSlotComparator());
		
		for(int i=0; i<9; i++) {
			for(int j=0; j<9; j++) {
				Set<Integer> solns = getPossibleSolns(i, j);
				SudokuSlot slot = new SudokuSlot(solns.size());
				int index = this.heap.add(slot);
				this.cellHeapIndexMap.put(new cell(i, j), index);
			}
		}
	}
	
	
	public void print(int[][] matrix) {
		for(int i=0; i<9; i++) {
			for(int j=0; j<9; j++) {
				System.out.print(matrix[i][j] + '\t');
			}
		}
		
		System.out.println();
	}
	
	public void play(cell c) {
		
		// if the heap is empty, print and return the results.
		if(this.heap.heapSize==0) {
			print(matrix);
			return;
		}
		
		//get possible solutions of c
		Set<Integer> possibleSolns = getPossibleSolns(c.i, c.j);
	
		//for each possible solution, update c
		for(Integer soln: possibleSolns) {
			
			// -- reduce the possible solution count for elements in the same row, col and slot in heap
			
			// -- -- update the map 	
			// -- get the next constrained c, recurse on it
			// -- revert back the changes done to heap
			// -- revert back the changes done to map
			
		}
		
		
		
	}
	
	private void decreaseSameRowValues(int i, int j) {
		
		for(int col=0; col<9; col++) {
			if(j!=col) {
				cell c = new cell(i, j);
				int index = cellHeapIndexMap.get(c);
				int curVal = heap.arr[index].val.possibleSolCount;
				SudokuSlot updatedSlot = new SudokuSlot(curVal+1);
				int newIndex = heap.update(index, updatedSlot);
			}			
		}
	}
	
	private Set<Integer> getPossibleSolns(int i, int j) {
		
		Set<Integer> notSolns = new HashSet<Integer>();
		Set<Integer> solns = new HashSet<Integer>();
		
		for(int col=0; col<9; col++) {
			if(j!=col && matrix[i][col]!=0) {
				notSolns.add(matrix[i][col]);
			}			
		}
		
		for(int row=0; row<9; row++) {
			if(i!=row && matrix[row][j]!=0) {
				notSolns.add(matrix[row][j]);
			}
		}
		
		
		int row = (i/3)*3;
		int col = (j/3)*3;
		
		int rowEnd = row + 3;
		int colEnd = col + 3;
		
		while(row < rowEnd) {
			while(col < colEnd) {
				if(row!=i && col!=j) {
					if(matrix[row][col]!=0) {
						notSolns.add(matrix[row][col]);
					}
				}
			}
		}
		
		
		for(int val=1; val<=9; val++) {
			if(!notSolns.contains(val)) {
				solns.add(val);
			}
		}
		
		return solns;
		
	}
}
