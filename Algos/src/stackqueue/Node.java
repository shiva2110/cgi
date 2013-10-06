package stackqueue;

public class Node<T> {
	T data;
	Node<T> next;
	int index;
	Integer min;

	public Node(T data, Node<T> next) {
		this.data = data;
		this.next = next;
	}
	
	public Node(T data, Node<T> next, int index){
		this.data = data;
		this.next = next;	
		this.index = index;
	}
	
	@Override
	public String toString(){
		return this.data.toString();
	}

}
