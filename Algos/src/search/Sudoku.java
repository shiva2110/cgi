package search;

import java.util.HashSet;
import java.util.Set;

import heap.Heap;



public class Sudoku {

	
	int[][] matrix;
	Heap<SudokuSlot> heap;
	
	public Sudoku(int[][] matrix) {
		this.matrix = matrix;
		this.heap = new Heap<SudokuSlot>(81, new SudokuSlotComparator());
		

	}
	

	
	
	private void getPossibleSolns(int i, int j) {
		
		Set<Integer> notSolns = new HashSet<Integer>();
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
		
		for(int row=i; row%3!=0; row++) {
			for(int col=j; col<(j+3); col++) {
				if(row!=i && col!=j) {
					if(matrix[row][col]!=0) {
						
					}
				}
			}
		}
		
		
	}
}
