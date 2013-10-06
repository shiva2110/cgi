package stackqueue;

import java.util.ArrayList;
import java.util.List;

public class Stack<T> {
	Node<T> head;
	
	public Stack(){
	}

	public void push(T data){
		this.head = new Node<T>(data, head);
	}

	public T pop(){
		if(head==null){
			return null;
		}

		T data = head.data;
		head = head.next;
		return data;
	}
	
	public T peek(){
		if(head==null){
			return null;
		}

		T data = head.data;
		return data;
	}
	
	public void print(){
		Node<T> node = head;
		while(node!=null){
			System.out.print(node.data + "->");
			node = node.next;
		}
		System.out.println();
	}
	
	public void sort(){
		Stack<T> sorted = new Stack<T>();
		T data;

		while((data=this.pop())!=null) {
				T data2;
				while((data2=sorted.peek())!=null  &&  (Integer)data2<(Integer)data) {
					this.push(sorted.pop());
				}
				sorted.push(data);	
		}
		
		this.head = sorted.head;

	}
	
	
	Node<T>[] nodeArr;
	List<Integer> freeIndexes;
	int[] headIndex = new int[3];
	public Stack(Node<T>[] nodeArr){
		this.nodeArr = nodeArr;
		freeIndexes = new ArrayList<Integer>();
		for(int i=0; i<nodeArr.length; i++) {
			freeIndexes.add(i);
		}
		for(int i=0; i<headIndex.length; i++) {
			headIndex[i] = -1;
		}	
	}

	
	public void push(int stackNum, T data) throws Exception {
		
		if(stackNum >= headIndex.length){
			System.out.println("StackNum " + stackNum + " does not exist");
			throw new Exception("StackNum " + stackNum + " does not exist");
		}
		if(freeIndexes.size()==0) {
			System.out.println("Stack full");
			throw new Exception("Stack full");
		}

		int freeIndex = freeIndexes.get(0);
		if(headIndex[stackNum] == -1) {
			nodeArr[freeIndex] = new Node<T>(data, null, freeIndex);
		} else {
			nodeArr[freeIndex] = new Node<T>(data, nodeArr[headIndex[stackNum]], freeIndex);
		}
		headIndex[stackNum] = freeIndex;
		int ptr= freeIndexes.indexOf(headIndex[stackNum]);
		freeIndexes.remove(ptr);
	}


	public T pop(int stackNum) {
		if(headIndex[stackNum]==-1){
			return null;
		}

		T data = nodeArr[headIndex[stackNum]].data;
		int newIndex;
		if(nodeArr[headIndex[stackNum]].next!=null) {
			newIndex = nodeArr[headIndex[stackNum]].next.index;
		} else {
			newIndex = -1;
		}

		nodeArr[headIndex[stackNum]] = null;
		freeIndexes.add(headIndex[stackNum]);
		headIndex[stackNum] = newIndex;
		
		return data;
	}
	
	public String print(int stackNum){
		if(headIndex[stackNum]==-1){
			return null;
		}
		
		int nextIndex = headIndex[stackNum];
		StringBuilder sb = new StringBuilder();
		while(nextIndex!=-1){
			sb.append(nodeArr[nextIndex].data + "->");
			if(nodeArr[nextIndex].next!=null){
				nextIndex = nodeArr[nextIndex].next.index;
			} else {
				nextIndex = -1;
			}			
		}
		
		return sb.toString();
	}

}
