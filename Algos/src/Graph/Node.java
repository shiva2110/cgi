package Graph;

import java.util.ArrayList;

public class Node<T> {
	int key;
	T data;
	ArrayList<Node<T>> connects = new ArrayList<Node<T>>();
	protected boolean mark;
	
	public Node(int key, T data) {
		this.key = key;
		this.data = data;
	}
	
	@Override
	public boolean equals(Object obj){
		
		if(!(obj instanceof Node<?>)){
			return false;
		}
		
		Node<?> node = (Node<?>) obj;
		
		if(node.key == this.key) {
			return true;
		} else {
			return false;
		}
			
	}
	
	@Override
	public String toString(){
		return data.toString();
	}
}
