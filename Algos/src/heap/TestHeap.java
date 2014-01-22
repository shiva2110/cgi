package heap;

public class TestHeap {

	public static void main(String[] args) {
		Heap<Float> heap = new Heap<Float>(10, new FloatComparator());
		heap.add(new Float(1000.02));
		heap.add(new Float(1.00003));
		heap.add(new Float(3.21456));
		heap.add(new Float(234.124));
		heap.add(new Float(1000.05));
		heap.add(new Float(2.12348));
		
		heap.add(new Float(6.54378));
		heap.add(new Float(11.3245));
		heap.add(new Float(24567.2));
		heap.add(new Float(1.75436));
		
		heap.print();
		
	}
}
