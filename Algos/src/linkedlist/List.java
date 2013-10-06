package linkedlist;

public class List<T> {

		Node<T> head;
		
		public List<T> add(T data) {
			this.head = new Node<T>(data, head);
			return this;
		}
		
		public String print() {
			Node<T> node = head;
			StringBuilder sb = new StringBuilder("");
			while(node!=null){
				System.out.print(node.data.toString() + "->");
				sb.append(node.data.toString() + "->");
				node = node.next;
			}
			System.out.println();
			return sb.toString();
		}
		
		public void delete(T data){
			
			while(head!=null && head.data.equals(data)){
				head = head.next;
			}
			
			Node<T> node = head;
			while(node!=null && node.next!=null){
				if(node.next.data.equals(data)){
					node.next = node.next.next;
				} else {
					node = node.next;
				}
				
			}			
		}
		
		public void removeDuplicates(){
	
			if(head == null) {
				return;
			}
			
			Node<T> node = head;
			while(node.next!=null){
				Node<T> slider = head;
				boolean dup = false;
				while(slider!=node.next){
					if(slider.data.equals(node.next.data)){
						dup = true;
						break;
					}
					slider = slider.next;
				}
				
				if(dup){
					node.next = node.next.next;
				} else {
					node = node.next;
				}
			}
		}
		
		public T getLast(int N){
			Node<T> slow = head;
			Node<T> fast = head;
			
			while(N!=0 && fast!=null){
				fast = fast.next;
				N--;
			}
			
			while(fast!=null && fast.next!=null){
				slow = slow.next;
				fast = fast.next;
			}
			
			return slow.data;
		}
		


		public static List<Integer> sum(List<Integer> list1, List<Integer> list2){
			Node<Integer> node1 = list1.head;
			Node<Integer> node2 = list2.head;
			List<Integer> list3 = new List<Integer>();
			int carry = 0;

			while(node1!=null && node2!=null){
				int sum = node1.data + node2.data + carry;
				carry = getQ(sum);
				list3.add(getR(sum));
				node1 = node1.next;
				node2 = node2.next;
			}

			Node<Integer> node = (node1!=null)?node1:node2;
			while(node!=null) {
				int sum = node.data + carry;
				carry = getQ(sum);
				list3.add(getR(sum));
				node = node.next;
			}

			if(carry>0){
				list3.add(carry);
			}

			return list3;
		}

		public static int getR(int sum){
			return sum%10;
		}

		public static int getQ(int sum){
			return sum/10;
		}
}
