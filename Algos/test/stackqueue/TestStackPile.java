package stackqueue;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestStackPile {

	
	@Test
	public void teststackpile(){
		StackPile pile = new StackPile();
		pile.push("A");
		pile.push("B");
		pile.push("C");
		pile.push("D");
		pile.push("E");
		pile.push("F");
		pile.push("G");		
		assertEquals(pile.pop(), "G");
		assertEquals(pile.pop(), "F");
		assertEquals(pile.pop(), "E");
		assertEquals(pile.pop(), "D");
		assertEquals(pile.pop(), "C");
		assertEquals(pile.pop(), "B");
		assertEquals(pile.pop(), "A");
		assertEquals(pile.pop(), null);
		
		pile = new StackPile();
		assertEquals(pile.pop(), null);
		
		pile.push("A");
		pile.push("B");
		pile.push("C");
		pile.push("D");
		pile.push("E");
		pile.push("F");
		pile.push("G");
		pile.push("H");
		pile.push("I");
		pile.push("J");
		pile.push("K");
		pile.push("L");
		pile.push("M");
		
		assertEquals(pile.pop(), "M");
		assertEquals(pile.pop(), "L");
		assertEquals(pile.pop(), "K");
		assertEquals(pile.pop(), "J");		
	}
	
	
	@Test
	public void teststackpile1() throws Exception{
		StackPile pile = new StackPile();
		pile.push("A");
		pile.push("B");
		pile.push("C");
		pile.push("D");
		
		assertEquals(pile.pop(0), "D");
		pile.push("D");
		pile.push("E");
		pile.push("F");
		pile.push("G");
		assertEquals(pile.pop(1), "G");
		assertEquals(pile.pop(1), "F");
		assertEquals(pile.pop(1), null);
		
		pile.push("F");
		pile.push("G");
		pile.push("H");
		pile.push("I");
		pile.push("J");
		
		pile.push("K");
		pile.push("L");
		pile.push("M");
		pile.push("N");
		pile.push("O");
		
		assertEquals(pile.pop(2), "O");
		assertEquals(pile.pop(1), "J");
		assertEquals(pile.pop(2), "N");
		assertEquals(pile.pop(1), "I");
		assertEquals(pile.pop(2), "M");		
		assertEquals(pile.pop(1), "H");		
		assertEquals(pile.pop(2), "L");	
		assertEquals(pile.pop(1), "G");	
		assertEquals(pile.pop(2), "K");	
		assertEquals(pile.pop(1), "F");	
		
		System.out.println(pile.curStackIndex + ";" + pile.curStackSize.size() + ";" + pile.list.size());
		System.out.println(pile.curStackSize.get(2)+ ";" +  pile.curStackSize.get(1) + ";" + pile.curStackSize.get(0));
		assertEquals(pile.pop(), "E");	
		assertEquals(pile.pop(), "D");	
		assertEquals(pile.pop(), "C");	
		assertEquals(pile.pop(), "B");	
		assertEquals(pile.pop(0), "A");	
		assertEquals(pile.pop(), null);	
	}
}
