package Graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import java.util.concurrent.SynchronousQueue;

import stackqueue.Queue;



public class Graph<T> {
	Node<T> root;
	

	public void constructGraph(List<Node<T>> nodes, boolean[][] matrix){
		//store the nodes in hashmap for easier access
		Map<Integer, Node<T>> map = new HashMap<Integer, Node<T>>();
		for(Node<T> node: nodes){
			map.put(node.key, node);
		}
		
		root = map.get(0);
		
		//make the connections
		for(int i=0; i<matrix.length; i++){
			for(int j=0; j<matrix.length; j++){
				if(i==j){
					continue;
				}
				
				if(matrix[i][j]){
					Node<T> node = map.get(i);
					node.connects.add(map.get(j));
				}
			}
		}		
	}
	
	public void reset(){
		
	}
	
	
	public String BFS(T data) {
		 Queue<Node<T>> queue = new Queue<Node<T>>();
		 Set<Integer> explored = new HashSet<Integer>();
		 explored.add(root.key);
		 queue.queue(root);
		 
		 StringBuilder sb = new StringBuilder();
		 
		 
		
		while(!queue.isEmpty()){
			Node<T> node = queue.dequeue();
			sb.append(node.data + "->");
			System.out.print(node.data + "->");
			if(node.data.equals(data)){
				return sb.toString();
			}			
			for(Node<T> child: node.connects) {
				if(!explored.contains(child.key)) {
					explored.add(child.key);
					queue.queue(child);
				}				
			}			
		}
		return sb.toString();
	}


	public Node<T> DFS(T data) {
		HashSet<Integer> explored = new HashSet<Integer>();
		explored.add(root.key);	
		return DFS(root, data, explored);
	}

	public Node<T> DFS(Node<T> node, T data, HashSet<Integer> explored) {
		System.out.print(node.data + "->");
		if(node.data.equals(data)) {
			return node;
		}

		for(Node<T> child: node.connects) {
			if(!explored.contains(child.key)) {
				explored.add(child.key);
				Node<T> found;
				if((found=DFS(child, data, explored))!=null) {
					return found;
				}
			}
		}

		return null;
	}
	

}
