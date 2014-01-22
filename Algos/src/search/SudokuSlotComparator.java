package search;

import java.util.Comparator;

public class SudokuSlotComparator implements Comparator{

	@Override
	public int compare(Object o1, Object o2) {
		SudokuSlot s1 = (SudokuSlot)o1;
		SudokuSlot s2 = (SudokuSlot)o2;
		
		if(s1.possibleSolCount < s2.possibleSolCount) {
			return -1;
		} else if(s1.possibleSolCount > s2.possibleSolCount) {
			return 1;
		} else {
			return 0;
		}
	}

}
