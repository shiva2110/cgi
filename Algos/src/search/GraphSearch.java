package search;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

public class GraphSearch<T> {
	
	public static void main(String[] args){
			List<GraphNode<Character>> nodes = new ArrayList<GraphNode<Character>>();
			
			GraphNode source ;
			GraphNode target;
			nodes.add(source = new GraphNode('1'));
			nodes.add(new GraphNode('2'));
			nodes.add(target = new GraphNode('3'));
			nodes.add(new GraphNode('4'));
			nodes.add(new GraphNode('5'));
			nodes.add(new GraphNode('6'));
			
			BitSet[] matrix = new BitSet[6];
			matrix[0] = new BitSet();
			matrix[0].set(1);
			matrix[0].set(2);
			matrix[0].set(3);
			matrix[0].set(4);
			
			matrix[1] = new BitSet();
			matrix[1].set(0);
			matrix[1].set(5);
			
			matrix[2] = new BitSet();
			matrix[2].set(0);
			matrix[2].set(3);
			matrix[2].set(5);
			
			matrix[3] = new BitSet();
			matrix[3].set(0);
			matrix[3].set(2);
			matrix[3].set(5);
			
			matrix[4] = new BitSet();
			matrix[4].set(0);
			matrix[4].set(5);
			
			matrix[5] = new BitSet();
			matrix[5].set(1);
			matrix[5].set(2);
			matrix[5].set(3);
			matrix[5].set(4);
			
			GraphSearch S = new GraphSearch(matrix, nodes);
			S.findPaths(source, target);
			
	}
	
	BitSet[] matrix ;
	List<GraphNode<T>> nodes;
	
	public GraphSearch(BitSet[] matrix, List<GraphNode<T>> graphNodes) {
		this.matrix = matrix;
		this.nodes = graphNodes;
	}
	
	public void findPaths(GraphNode<T> source, GraphNode<T> target) {
		
		int sourceIndex = 0;
		for(int i=0; i<nodes.size(); i++) {
			if(nodes.get(i).equals(source)) {
				sourceIndex = i;
			}
		}
		
		List<T> path = new ArrayList<T>();
		path.add(nodes.get(sourceIndex).data);
		
		findPaths(sourceIndex, target.data, path);
	}
	
	private void findPaths(int sourceIndex, T target, List<T> path) {
		
		if(nodes.get(sourceIndex).data.equals(target)) {
			System.out.println(path.toString());
			return;
		}
	
		
		List<Integer> adjacencyList = findAdjacencyList(sourceIndex);
		for(Integer nodeIndex: adjacencyList) {
			GraphNode<T> node = nodes.get(nodeIndex);
			if(path.contains(node.data)) {
				continue;
			}
			
			path.add(node.data);
			
			findPaths(nodeIndex, target, path);
			
			path.remove(path.size()-1);
			
		}
	}
	
	private List<Integer> findAdjacencyList(int index) {
		
		List<Integer> adjacencyList = new ArrayList<Integer>();
		BitSet bitSet =  matrix[index];
		for(int setIndex=bitSet.nextSetBit(0); setIndex>=0; setIndex=bitSet.nextSetBit(setIndex+1)) {
			adjacencyList.add(setIndex);
		}
		
		return adjacencyList;
	}
}
