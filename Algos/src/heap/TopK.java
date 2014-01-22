package heap;

import heap.Heap.Data;

public class TopK {
	
	public static void main(String[] args) {
		TopK topK = new TopK();
		Float[] arr = new Float[]{F(109), F(108), F(234), F(12), F(145), F(1080), F(786), F(43), F(5467), F(543), F(678), F(2), F(56), F(674), F(90), F(67), F(55), F(1), F(45), F(879)};
		topK.findTopK(arr, 10);
	
	}
	
	public static Float F(int i) {
		return (float)i;
	}
	

	public void findTopK(Float[] bigArr, int k) {
		
		Heap<Float> heap = new Heap<Float>(k, new FloatComparator());
		
		for(int i=0; i<k; i++) {
			heap.arr[i] = heap.new Data(bigArr[i]);
			heap.heapSize ++;
		}
		
		heap.heapify();
		
		for(int i=k; i<bigArr.length; i++){
			Float min = (Float) heap.min();
			if(bigArr[i] > min) {
				heap.arr[0] = heap.new Data(bigArr[i]);
				heap.heapifyDown(0);			
			}			
		}
		
		for(int i=0; i<heap.arr.length; i++){
			System.out.print(heap.arr[i].val + ",");
		}
	}
}
