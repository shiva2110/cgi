package Tree;

import java.util.ArrayList;
import java.util.List;

public class Tree<T> {
	Node<T> root;

	public void insert(T data) {
		if(root==null) {
			root = new Node(data, null, null, null);
			return;
		}
		Node<T> node = root;
		insert(node, data);
	}

	public void insert(Node<T> node, T data) {
		if((Integer)data<=(Integer)node.data) {
			if(node.left==null) {
				node.left = new Node(data, null, null, node);
				return;
			}
			insert(node.left, data);
		} else {
			if(node.right==null) {
				node.right = new Node(data, null, null, node);
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
	
	public void allOrder(Node<T> node){
		System.out.print("Inorder: "); inOrder(node); System.out.println();
		System.out.print("Preorder: "); preOrder(node); System.out.println();
		System.out.print("Postorder: "); postOrder(node); System.out.println();
	}
	
	public boolean isBalanced(){
		
		if(root==null) {
			return true;
		}

		return isBalanced(root, 0);		
	}

	int MIN = Integer.MAX_VALUE;
	int MAX = Integer.MIN_VALUE;

	public boolean isBalanced(Node node, int depth){

		if(node.left==null && node.right==null) {
			if(depth<=MIN) {
				MIN = depth;
			}

			if(depth>MAX) {
				MAX = depth;
			}

			if((MAX-MIN)>=2) {
				return false;
			}

			return true;
		}

		boolean left = true;
		boolean right = true;
		if(node.left!=null){
			left =  isBalanced(node.left, depth+1);
		}
		
		if(node.right!=null){
			right = isBalanced(node.right, depth+1);
		}
		return  left && right;
	}
	
	

	int arr[];
	
	public Tree createMinTree(int[] arr){
		if(arr.length==0){
			return null;
		}
		
		this.arr = arr;
		Tree T = new Tree();
		T.root = createMinTree(0, arr.length-1);
		return T;
	}

	public Node createMinTree(int start, int end){
		if(end<start) {
			return null;
		}

		int mid = (start+end)/2;
		Node node = new Node(arr[mid], null, null);
		node.left = createMinTree(start, mid-1);
		node.right = createMinTree(mid+1, end);

		return node;

	} 
	
	List<List<Integer>> list = new ArrayList<List<Integer>>();
	
	public void depthList(Node<Integer> node, int depth) {
		if(node==null) {
			return;
		}

		if(list.size()<=depth) {		
			List<Integer> depthLi = new ArrayList<Integer>();
			depthLi.add(node.data);
			list.add(depthLi);
		} else {
			List<Integer> depthLi = list.get(depth);
			depthLi.add(node.data);
		}

		depthList(node.left, depth+1);
		depthList(node.right, depth+1);
	}
	
	public T successor(Node<T> node) {
		if(node.right!=null) {
			node = node.right;
			while(node.left!=null) {
				node = node.left;
			}
			return node.data;
		} else {
			while(node.parent!=null && node.parent.left!=node){
				node = node.parent;
			}
			
			if(node.parent!=null) {
				return node.parent.data;
			}
			return null;		
		}	
	}
	

	public Node<Integer> find(Node<Integer> node, int data) {
		if(node==null) {
			return null;
		}

		if(node.data.equals(data)) {
			return node;
		}

		if(data<node.data) {
			return find(node.left, data);
		} else {
			return find(node.right, data);
		}
	}
	
	public Node LCA(Node A, Node B, Node node) {

		if(A==null || B==null || node==null) {
			return null;
		}

		if(node==A || node==B) {
			return node;
		}

		boolean Aleft = find(A, node.left);
		boolean Aright = find(A, node.right);
		boolean Bleft = find(B, node.left);
		boolean Bright = find(B, node.right);

		if(Aleft && Bleft) {
			return LCA(A, B, node.left);
		} else if(Aright && Bright) {
			return LCA(A, B, node.right);
		} else if((Aleft && Bright) || (Aright && Bleft)) {
			return node;
		} else {
			return null;
		}
	}



	public boolean find(Node node, Node root) {
		if(root == null) {
			return false;
		}

		if(root==node) {
			return true;
		}

		return find(node, root.left) || find(node, root.right);
	}
	
	
	public boolean isSubTree(Node node1, Node root2) {
		if(node1==null) {
			return false;
		}

		if(node1.data.equals(root2.data)) {
			if(treeMatch(node1, root2)) {
				return true;
			}
		}

		return isSubTree(node1.left, root2) ||
				isSubTree(node1.right, root2);
	}


	public boolean treeMatch(Node node1, Node node2) {
		if(node2==null) {
			return true;
		}

		if(node1==null){
			return false;
		}

		if(node1.data.equals(node2.data)) {
			return treeMatch(node1.left, node2.left) && treeMatch(node1.right, node2.right);
		}

		return false;	
	}
	
	public void printSumPaths(Node<Integer> node, int sum) {
		
		if(node==null) {
			return;
		}

		printSumPaths(node, sum, "");
		printSumPaths(node.left, sum);
		printSumPaths(node.right, sum);

	}

	public void printSumPaths(Node<Integer> node, int sum, String pathBuilder) {
		if(node==null){
			return;
		}	

		int diff = sum-(node.data);
		

		String newPath = pathBuilder + "->" + node.data;
		if(diff==0) {
			System.out.println(newPath);
		}

		printSumPaths(node.left, diff, newPath);
		printSumPaths(node.right, diff, newPath);

	}

}

