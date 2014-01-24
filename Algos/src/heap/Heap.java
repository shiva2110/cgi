package heap;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Heap<T> {
	
	public int heapSize = 0;
	Comparator<T> comparer;
	
	public class Data<T> {
		public T val;
		public Data(T val) {
			this.val = val;
		}
	}
	
	
	public Data<T>[] arr;
	
	public Heap(int size, Comparator<T> comparer) {
		this.arr = new Data[size];
		this.comparer = comparer;
	}
	
	List<String> levels = new ArrayList<String> ();
	
	
	
	public void heapify() {
		int i = parent(arr.length-1);
		while(i>=0) {
			heapifyDown(i);
			i--;
		}
	}
	
	public void print() {
		levels = new ArrayList<String>();
		print(0, 0);
		for(String s : levels) {
			System.out.println(s);
		}
	}
	private void print(int level, int index) {
		if(index >= heapSize) {
			return;
		}
		
		if(levels.size()<=level || levels.get(level) == null) {
			levels.add(arr[index].val.toString());
		} else {
			String s = levels.get(level);
			s = s + "," + arr[index].val.toString();
			levels.set(level, s);
		}
		
		print(level+1, left(index));
		print(level+1, right(index));
	}
	
	public int add(T val) {
		if(heapSize==arr.length) {
			System.out.println("max limit for adding has reached!");
			return -1;
		}
		
		arr[heapSize] = new Data(val);
		heapSize ++ ;
		
		return heapifyUp(heapSize-1);
	}
	
	public T min() {
		if(heapSize>0) {
			return arr[0].val;
		}
		return null;
	}
	
	public T extractMin() {
		if(heapSize == 0) {
			return null;
		}
		
		T min = arr[0].val;
		
		arr[0] = arr[heapSize-1];
		arr[heapSize-1] = null;
		heapSize--;
		
		heapifyDown(0);
		
		return min;
	}
	
	
	public int  update(int index, T newVal) {
		if(index >= heapSize) {
			return -1;
		}
		
		if(this.comparer.compare(newVal, arr[index].val) < 0) {
			arr[index] = new Data(newVal);
			return heapifyUp(index);
		} else if(this.comparer.compare(newVal, arr[index].val) > 0) {
			arr[index] = new Data(newVal);
			heapifyDown(index);
		}
	}
	
	public void heapifyDown(int index) {
		
		if(index > heapSize) {
			return;
		}
		
		int minIndex = index;
		int leftIndex = left(index);
		if(leftIndex < heapSize && comparer.compare(arr[leftIndex].val, arr[minIndex].val) < 0) {
			minIndex = leftIndex;
		}
		
		int rightIndex = right(index);
		if(rightIndex < heapSize && comparer.compare(arr[rightIndex].val, arr[minIndex].val) < 0) {
			minIndex = rightIndex;
		}
		
		Data temp = arr[index];
		arr[index] = arr[minIndex];
		arr[minIndex] = temp;
		
		if(minIndex!=index) {
			heapifyDown(minIndex);
		}
		
	}
	
	private int heapifyUp(int index) {
		if(index > heapSize) {
			System.out.println("heapifyUp - index is more than heapSize!");
			return index;
		}
		
		int parent = parent(index);
		if(parent>=0 && comparer.compare(arr[index].val, arr[parent].val) <= 0) {
			Data<T> temp = arr[parent];
			arr[parent] = arr[index];
			arr[index] = temp;
			
			return heapifyUp(parent);
		}
		
		return parent;
		
	
	}
	
	public int left(int i) {
		return (2*i)+1;
	}
	
	public int right(int i) {
		return (2*i) + 2;
	}
	
	public int parent(int i) {
		double d = i;
		double j = Math.ceil((d/2)-1);
		return (int)j;
	}

}
