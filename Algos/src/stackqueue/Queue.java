package stackqueue;

public class Queue<T> {
	Node<T> head;
	Node<T> tail;

	public void queue(T data){
		if(head==null) {
			head = new Node<T>(data, null);			
			tail = head;
		} else {
			tail.next = new Node<T>(data, null);
			tail = tail.next;
		}
	}

	public T dequeue(){
		if(head==null){
			return null;
		}

		T data = head.data;
		head = head.next;
		return data;
	}
	
	public Node<T> dequeueN(){
		if(head==null){
			return null;
		}

		Node<T> node = head;
		head = head.next;
		return node;
	}
	
	public boolean isEmpty() {
		if(head==null) {
			return true;
		}
		return false;
	}
	
	public void print(){
		Node<T> node = head;
		while(node!=null){
			System.out.print(node.toString() + "->");
			node = node.next;
		}
		System.out.println();
		
	}
}
