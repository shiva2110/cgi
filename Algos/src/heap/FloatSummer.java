package heap;

import java.util.ArrayList;
import java.util.List;

public class FloatSummer {
	
	public static void main(String[] args) throws Exception {

		FloatSummer summer = new FloatSummer();
		List<Float> list = new ArrayList<Float>();
		list.add(new Float(1000.02));
		list.add(new Float(1.00003));
		list.add(new Float(3.21456));
		list.add(new Float(234.124));
		list.add(new Float(1000.05));
		list.add(new Float(2.12348));
		
		list.add(new Float(6.54378));
		list.add(new Float(11.3245));
		list.add(new Float(24567.2));
		list.add(new Float(1.75436));
		
		
		summer.sum(list, 6);
		float sum = 0;
		for(Float f: list) {
			sum = sum + f;
		}
		sum = summer.round(sum, 6);
		System.out.println("sum by regular method: " + sum);
		
		
	}
	
	public void sum(List<Float> floatList, int fixedSize) throws Exception {
		Heap<Float> heap = new Heap<Float>(floatList.size(), new FloatComparator());
		for(Float f : floatList) {
			heap.add(f);
		}
		
		while(heap.heapSize>1) {
			Float min1 = heap.extractMin();
			Float min2 = heap.extractMin();
			
			float sum = min1 + min2;
			sum = round(sum, fixedSize);
			heap.add(sum);		
		}
		
		System.out.println(heap.min());
	}
	
	public float round(Float f, int maxDigits) throws Exception {
		int i = f.intValue();
		int digits = 0;
		
		int dec = 1;
		while(true) {
			if(i >= dec){
				digits++;
			} else {
				break;
			}
			
			dec = dec*10;
		}
		
		if(digits > maxDigits) {
			throw new Exception("could not round off as the mantissa exceeds maxDigits allowed!");
		}
		
		int maxExpDigits = maxDigits - digits;
		
		if(maxExpDigits==0){
			return i;
		}
		
		float exponent = f - i;		
		float exponentM = (float) (exponent*(Math.pow(10, maxExpDigits)));
		int exponentI = (int)exponentM;
		if(exponentM >  (exponentI + 0.5))  {
			exponentI = exponentI + 1;
		}
		exponent = (float) (exponentI / Math.pow(10, maxExpDigits));
		
		return i + exponent;
		
		
	}
}
