package linkedlist;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestCracking {
	
	@Test
	public void testAdd(){
		List<String> list = new List<String>();
		list.add("A");
		list.add("b");
		list.add("C");
		list.add("D");
		list.print();
	}
	
	@Test
	public void testDelete(){
		List<String> list = new List<String>();
		list.add("A");
		assertEquals(list.print(), "A->");
		list.delete("A");
		assertEquals(list.print(), "");
		
		list = new List<String>();
		list.add("A").add("B").add("A");
		assertEquals(list.print(), "A->B->A->");
		list.delete("A");
		assertEquals(list.print(), "B->");
		
		list = new List<String>();
		list.add("A").add("B").add("C").add("B").add("D");
		assertEquals(list.print(), "D->B->C->B->A->");
		list.delete("B");
		assertEquals(list.print(), "D->C->A->");
		
		list = new List<String>();
		list.add("A").add("B").add("B").add("B").add("B");
		assertEquals(list.print(), "B->B->B->B->A->");
		list.delete("B");
		assertEquals(list.print(), "A->");
		
		list = new List<String>();
		list.add("A").add("B").add("B").add("B").add("D");
		assertEquals(list.print(), "D->B->B->B->A->");
		list.delete("B");
		assertEquals(list.print(), "D->A->");
	}
	
	@Test
	public void testRemoveDup(){
		List<String> list = new List<String>();
		list.add("A").add("A");
		assertEquals(list.print(), "A->A->");
		list.removeDuplicates();
		assertEquals(list.print(), "A->");
		
		list = new List<String>();
		list.add("A").add("B").add("A");
		assertEquals(list.print(), "A->B->A->");
		list.removeDuplicates();
		assertEquals(list.print(), "A->B->");
		
		list = new List<String>();
		list.add("C").add("B").add("B").add("A");
		assertEquals(list.print(), "A->B->B->C->");
		list.removeDuplicates();
		assertEquals(list.print(), "A->B->C->");
		
		list = new List<String>();
		list.add("C").add("B").add("A").add("B").add("D").add("B").add("E");
		assertEquals(list.print(), "E->B->D->B->A->B->C->");
		list.removeDuplicates();
		assertEquals(list.print(), "E->B->D->A->C->");
		
	}
	
	
	@Test
	public void testlastN(){
		List<String> list = new List<String>();
		list.add("A");
		assertEquals(list.getLast(3), "A");
		assertEquals(list.getLast(2), "A");
		assertEquals(list.getLast(1), "A");
		assertEquals(list.getLast(0), "A");
		
		list = new List<String>();
		list.add("A").add("B").add("C").add("D");
		assertEquals(list.getLast(0), "A");
		assertEquals(list.getLast(1), "B");
		assertEquals(list.getLast(2), "C");
		assertEquals(list.getLast(3), "D");
		assertEquals(list.getLast(4), "D");
	}
	
	@Test
	public void testsum(){
		System.out.println("===========");
		List<Integer> list1 = new List<Integer>();
		list1.add(9);
		List<Integer> list2 = new List<Integer>();
		list2.add(9);		
		List<Integer> sum = List.sum(list1, list2);
		sum.print();
		
		list1 = new List<Integer>();
		list1.add(9).add(9);
		list2 = new List<Integer>();
		list2.add(9);	
		sum = List.sum(list1, list2);
		sum.print();
		
		list1 = new List<Integer>();
		list1.add(9).add(9).add(9);
		list2 = new List<Integer>();
		list2.add(9).add(9);	
		sum = List.sum(list1, list2);
		sum.print();
		
		list1 = new List<Integer>();
		list1.add(9).add(9);
		list2 = new List<Integer>();
		list2.add(9).add(9).add(9);	
		sum = List.sum(list1, list2);
		sum.print();
		
		list1 = new List<Integer>();
		list2 = new List<Integer>();
		list2.add(9).add(9).add(9);	
		sum = List.sum(list1, list2);
		sum.print();
	}
}
