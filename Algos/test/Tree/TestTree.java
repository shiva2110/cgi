package Tree;

import java.util.List;

import org.junit.Test;

public class TestTree {
	@Test
	public void testTree(){
		Tree<Integer> tree = new Tree<Integer>();
		tree.insert(32);
		tree.insert(25);
		tree.insert(46);
		tree.insert(22);
		tree.insert(27);
		tree.insert(24);
		tree.insert(26);
		tree.insert(29);
		tree.insert(33);
		tree.insert(51);
		tree.insert(43);
		
		tree.inOrder(tree.root);
		System.out.println();
		tree.preOrder(tree.root);
		System.out.println();
		tree.postOrder(tree.root);
		System.out.println();
	}
	
	@Test
	public void testBalanced(){
		Tree<Integer> tree = new Tree<Integer>();
		tree.insert(32);
		tree.insert(43);
		tree.insert(21);
		tree.insert(27);
		System.out.println("alanced: " + tree.isBalanced());
		System.out.println("max:" + tree.MAX);
		System.out.println("min:" + tree.MIN);
		
	}
	
	
	@Test
	public void testMinTree() {
		
		Tree tree = new Tree();
		Tree T = tree.createMinTree(new int[]{0});
		T.allOrder(T.root);
		System.out.println("---------");
		
		T = tree.createMinTree(new int[]{0,1});
		T.allOrder(T.root);
		System.out.println("---------");
		
		T = tree.createMinTree(new int[]{0,1,2});
		T.allOrder(T.root);
		System.out.println("---------");
		
		T = tree.createMinTree(new int[]{0,1,2,3});
		T.allOrder(T.root);
		System.out.println("---------");
		
		T = tree.createMinTree(new int[]{0,1,2,3,4});
		T.allOrder(T.root);
		System.out.println("---------")		;
	}
	
	@Test
	public void testDepthList(){
		System.out.println("--------------Tree depth list------------------");
		Tree tree = new Tree();
		tree.insert(32);
		tree.insert(25);
		tree.insert(46);
		tree.insert(22);
		tree.insert(27);
		tree.insert(24);
		tree.insert(26);
		tree.insert(29);
		tree.insert(33);
		tree.insert(51);
		tree.insert(43);
		tree.depthList(tree.root, 0);
		System.out.println(tree.list);
	}
	
	@Test
	public void testSuccessor(){
		Tree tree = new Tree();
		tree.insert(32);
		tree.insert(25);
		tree.insert(46);
		tree.insert(22);
		tree.insert(27);
		tree.insert(24);
		tree.insert(26);
		tree.insert(29);
		tree.insert(33);
		tree.insert(51);
		tree.insert(43);
		
		Node node = tree.find(tree.root, 25);
		System.out.println("successor for 25: " + tree.successor(node));
		
		node = tree.find(tree.root, 24);
		System.out.println("successor for 24: " + tree.successor(node));
		
		node = tree.find(tree.root, 32);
		System.out.println("successor for 32: " + tree.successor(node));
		
		node = tree.find(tree.root, 51);
		System.out.println("successor for 51: " + tree.successor(node));
	}
	
	@Test 
	public void testFind() {
		Tree tree = new Tree();
		tree.insert(32);
		tree.insert(25);
		tree.insert(46);
		tree.insert(22);
		tree.insert(27);
		tree.insert(24);
		tree.insert(26);
		tree.insert(29);
		tree.insert(33);
		tree.insert(51);
		tree.insert(43);
		
		System.out.println("------------Find-------------");
		
		Node node = tree.find(tree.root, 22);
		System.out.println(node.data);
		
		node = tree.find(tree.root, 46);
		System.out.println(node.data);
		
		node = tree.find(tree.root, 33);
		System.out.println(node.data);
		
		System.out.println("----------------------------");
	}
	
	@Test
	public void testLCAOptimized(){
		
		System.out.println("----------LCA optimized-----------");
		Tree tree = new Tree();
		tree.insert(32);
		tree.insert(25);
		tree.insert(46);
		tree.insert(22);
		tree.insert(27);
		tree.insert(24);
		tree.insert(26);
		tree.insert(29);
		tree.insert(33);
		tree.insert(51);
		tree.insert(43);
		
		Node A = tree.find(tree.root, 26);
		Node B = tree.find(tree.root, 29);
		Node node = tree.LCAOptimized(A, B);
		System.out.println(node.data);
		
		A = tree.find(tree.root, 27);
		B = tree.find(tree.root, 29);
		node = tree.LCAOptimized(A, B);
		System.out.println(node.data);
		
		A = tree.find(tree.root, 22);
		B = tree.find(tree.root, 33);
		node = tree.LCAOptimized(A, B);
		System.out.println(node.data);
		
		A = tree.find(tree.root, 51);
		B = tree.find(tree.root, 43);
		node = tree.LCAOptimized(A, B);
		System.out.println(node.data);
		
		System.out.println("----------LCA optimized-----------");
	}
}


