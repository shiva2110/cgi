package Tree;

public class Tree<T> {
	Node<T> root;

	public void insert(T data) {
		if(root==null) {
			root = new Node(data, null, null);
			return;
		}
		Node<T> node = root;
		insert(node, data);
	}

	public void insert(Node<T> node, T data) {
		if((Integer)data<=(Integer)node.data) {
			if(node.left==null) {
				node.left = new Node(data, null, null);
				return;
			}
			insert(node.left, data);
		} else {
			if(node.right==null) {
				node.right = new Node(data, null, null);
				return;
			}
			insert(node.right, data);
		}
	}


	public void inOrder(Node<T> node){
		if(node==null) {
			return;
		}
		inOrder(node.left);
		System.out.print(node.data + "->");
		inOrder(node.right);
	}

	public void preOrder(Node<T> node){
		if(node == null) {
			return;
		}
		System.out.print(node.data + "->");
		preOrder(node.left);
		preOrder(node.right);		
	}


	public void postOrder(Node<T> node){
		if(node == null) {
			return;
		}
		
		postOrder(node.left);
		postOrder(node.right);		
		System.out.print(node.data + "->");
	}
	
	
	

}

