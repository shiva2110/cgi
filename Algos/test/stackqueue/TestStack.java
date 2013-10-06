package stackqueue;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.rules.ExpectedException;

public class TestStack {
	ExpectedException exception = ExpectedException.none();

	@Test
	public void test3stack() throws Exception{
		
		Node<String>[] nodeArr = new Node[3];
		Stack<String> stack = new Stack<String>(nodeArr);
		stack.push(0, "A");		
		stack.push(1, "B");		
		stack.push(2, "C");			
		assertEquals(stack.print(0), "A->");
		assertEquals(stack.print(2), "C->");
		assertEquals(stack.print(1), "B->");
		
		exception.expect(Exception.class);
		try {
			stack.push(2, "C");
		} catch(Exception e) {
			
		}
		
		
		stack.pop(0);
		assertEquals(stack.print(0), null);
		assertEquals(stack.print(2), "C->");
		assertEquals(stack.print(1), "B->");
		
		nodeArr = new Node[6];
		stack = new Stack<String>(nodeArr);
		stack.push(0, "A");		
		stack.push(0, "B");		
		stack.push(0, "C");	
		stack.push(0, "D");		
		stack.push(0, "E");		
		stack.push(0, "F");		
		assertEquals(stack.print(0), "F->E->D->C->B->A->");		
		assertEquals(stack.pop(0), "F");	
		assertEquals(stack.print(0), "E->D->C->B->A->");	
		assertEquals(stack.pop(0), "E");	
		assertEquals(stack.print(0), "D->C->B->A->");	
		assertEquals(stack.pop(1), null);	
		stack.push(1, "M");	
		stack.push(2, "N");	
		assertEquals(stack.print(2), "N->");	
		exception.expect(Exception.class);
		try {
			stack.push(2, "J");
		} catch(Exception e){
			
		}	
	}
	
	
	@Test
	public void testsort(){
		
		System.out.println("-----testsort------");
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(5);
		stack.push(9);
		stack.push(8);
		stack.push(25);
		stack.push(12);
		stack.push(1);
		
		stack.print();
		stack.sort();
		stack.print();
		
		System.out.println("-----testsort------");
	}
}
