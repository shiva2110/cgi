package TestGraph;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import Graph.Graph;
import Graph.Node;



public class TestGraph {
	
	@Test
	public void testGraph(){
		Graph<String> graph = new Graph<String>();
		
		List<Node<String>> nodes = new ArrayList<Node<String>>();
		nodes.add(new Node<String>(0, "A"));
		nodes.add(new Node<String>(1, "B"));
		nodes.add(new Node<String>(2, "C"));
		nodes.add(new Node<String>(3, "D"));
		nodes.add(new Node<String>(4, "E"));
		
		boolean[][] matrix = {{false,true,true,false,false}, 
							  {false,false,false,true,true}, 
							  {false,false,false,false,false},
							  {false,false,true,false,false},
							  {false,false,false,false,false}};

		graph.constructGraph(nodes, matrix);
		assertEquals(graph.BFS("C"), "A->B->C->"); System.out.println();
		assertEquals(graph.BFS("F"), "A->B->C->D->E->"); System.out.println();
		assertEquals(graph.BFS("E"), "A->B->C->D->E->"); System.out.println();
		assertEquals(graph.BFS("B"), "A->B->"); System.out.println();
		assertEquals(graph.BFS("A"), "A->"); System.out.println();
		
		System.out.println("====================");
		graph.DFS("E");
		
		

		
	}
}
