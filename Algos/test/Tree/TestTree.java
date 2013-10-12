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
		
		Node node32 = tree.find(tree.root, 32);
		Node node26 = tree.find(tree.root, 26);
		System.out.println("find 26 : " + tree.find(node26, node32));	
		
		Node node25 = tree.find(tree.root, 25);
		node32 = tree.find(tree.root, 32);
		System.out.println("find 32 : " + tree.find(node32, node25));	
		
		System.out.println("----------------------------");
	}
	
	@Test
	public void testLCA(){
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
		
		System.out.println("----------------LCA--------------");
		
		Node A = tree.find(tree.root, 29);
		Node B = tree.find(tree.root, 26);
		Node lca = tree.LCA(A, B, tree.root);
		System.out.println("LCA: " + lca.data);
		
		
		A = tree.find(tree.root, 46);
		B = tree.find(tree.root, 51);
		lca = tree.LCA(A, B, tree.root);
		System.out.println("LCA: " + lca.data);
		
		A = tree.find(tree.root, 43);
		B = tree.find(tree.root, 29);
		lca = tree.LCA(A, B, tree.root);
		System.out.println("LCA: " + lca.data);

		A = tree.find(tree.root, 22);
		B = tree.find(tree.root, 29);
		lca = tree.LCA(A, B, tree.root);
		System.out.println("LCA: " + lca.data);
		
		A = tree.find(tree.root, 24);
		B = tree.find(tree.root, 26);
		lca = tree.LCA(A, B, tree.root);
		System.out.println("LCA: " + lca.data);
		
		
		System.out.println("----------------------------");
	}
	
	@Test
	public void testIsSubTree(){

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
			
			System.out.println("-----------is sub tree----------");
			Tree tree2 = new Tree();
			tree2.insert(27);
			tree2.insert(26);
			System.out.println(tree.isSubTree(tree.root, tree2.root));			
			
			tree2 = new Tree();
			tree2.insert(46);
			tree2.insert(51);
			System.out.println(tree.isSubTree(tree.root, tree2.root));
			
			tree2 = new Tree();
			tree2.insert(51);
			tree2.insert(46);
			System.out.println(tree.isSubTree(tree.root, tree2.root));
			
			tree2 = new Tree();
			tree2.insert(46);
			tree2.insert(33);
			tree2.insert(51);
			System.out.println(tree.isSubTree(tree.root, tree2.root));
			
			tree2 = new Tree();
			tree2.insert(46);
			tree2.insert(33);
			tree2.insert(51);
			tree2.insert(47);
			System.out.println(tree.isSubTree(tree.root, tree2.root));
			
			tree2 = new Tree();
			tree2.insert(32);
			tree2.insert(25);
			tree2.insert(22);
			tree2.insert(27);
			tree2.insert(24);
			System.out.println(tree.isSubTree(tree.root, tree2.root));
			
			
			System.out.println("-----------is sub tree----------");
	}
	
	@Test
	public void testPrintPaths(){
		Tree<Integer> tree = new Tree<Integer>();
		tree.insert(32);
		tree.insert(25);
		tree.insert(45);
		tree.insert(21);
		tree.insert(27);
		tree.insert(10);
		tree.insert(26);
		tree.insert(29);
		tree.insert(33);
		tree.insert(51);
		tree.insert(43);
		System.out.println("-------print paths-------");
		tree.printSumPaths(tree.root, 57);
		System.out.println("--");
		tree.printSumPaths(tree.root, 78);
		System.out.println("--");
		tree.printSumPaths(tree.root, 32);
		System.out.println("--");
		
		tree = new Tree<Integer>();
		tree.insert(3);
		tree.insert(2);
		tree.insert(3);
		tree.insert(-3);
		tree.insert(1);
		tree.insert(2);
		tree.insert(3);
		
		tree.printSumPaths(tree.root, 5);
		
		System.out.println("-------print paths-------");
	}
}


