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
	
	public Node LCAOptimized(Node A, Node B) {

		if(A==null || B==null || root==null) {
			return null;
		}

		MutableInt depthA = new MutableInt(0); MutableInt depthB = new MutableInt(0);
		boolean foundA = findDepth(A, root, depthA);
		boolean foundB = findDepth(B, root, depthB);

		if(!foundA || !foundB) {
			return null;
		}
		
		if(depthA.value() > depthB.value()) {
			A = moveUp(A, depthB.value(), depthA.value());
		} else if(depthB.value() > depthA.value()) {
			B= moveUp(B, depthA.value(), depthB.value());
		}

		while(A!=B && A!=null && B!=null) {
			A = A.parent;	
			B = B.parent;
	 	}

		return A;	
	}


	public boolean findDepth(Node node, Node curNode, MutableInt depth) {
		 if(curNode==null || node==null){
			return false;
		 }

		 if(curNode==node) {
			return true; 
		}
		
		int temp = depth.value();
		boolean foundLeft = findDepth(node, curNode.left, depth.add(1));
		if(foundLeft) {
			return foundLeft;
		}

		depth.reset(temp);
		boolean foundRight = findDepth(node, curNode.right, depth.add(1));
		return foundRight;
	}

	public Node moveUp(Node node, int targetDepth, int curDepth) {

		if(targetDepth>=curDepth) {
			return null;
		}

		while(node!=null && targetDepth<curDepth) {
			node = node.parent;
			curDepth = curDepth - 1;
		}
		
		return node;
	}
	

}

