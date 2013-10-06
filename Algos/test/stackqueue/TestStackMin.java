package stackqueue;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestStackMin {
	
	
	@Test
	public void testStackMin(){
		StackMin stackMin = new StackMin();
		stackMin.push(45);
		stackMin.push(55);
		stackMin.push(12);
		stackMin.push(21);
		assertTrue(stackMin.min().equals(12));
		stackMin.pop();
		assertTrue(stackMin.min().equals(12));
		stackMin.pop();
		assertTrue(stackMin.min().equals(45));
		stackMin.push(65);
		stackMin.push(72);
		stackMin.push(81);
		assertTrue(stackMin.min().equals(45));
	}
}
