package Tree;

public class Node<T> {
	T data;
	Node<T> left;
	Node<T> right;
	Node<T> parent;

	public Node(T data, Node<T> left, Node<T> right) {
		this.data = data;
		this.left = left;
		this.right =right;		
	}
	
	public Node(T data, Node<T> left, Node<T> right, Node<T> parent) {
		this.data = data;
		this.left = left;
		this.right =right;	
		this.parent = parent;
	}
}

