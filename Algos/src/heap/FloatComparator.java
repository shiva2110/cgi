package heap;

import java.util.Comparator;

public class FloatComparator implements Comparator{

	@Override
	public int compare(Object o1, Object o2) {
		
		if(o1==null || o2==null) {
			return 0;
		}
		
		Float f1 = (Float)o1;
		Float f2 = (Float)o2;
		
		return f1.compareTo(f2);
	}

}
