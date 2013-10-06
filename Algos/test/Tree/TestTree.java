package Tree;

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
}
