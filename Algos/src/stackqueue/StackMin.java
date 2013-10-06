package stackqueue;

public class StackMin {
	Node<Integer> head;

	public void push(Integer data){
		int min;
		if(head == null) {
			min = data;
		} else {
			min = (this.head.min < data)?head.min:data;
		}
		this.head = new Node<Integer>(data, head);
		this.head.min = min;	
	}

	public Integer pop(){
		if(head==null){
			return null;
		}

		Integer data = head.data;
		head = head.next;
		return data;
	}

	public Integer min() {
		return this.head.min;
	}

}