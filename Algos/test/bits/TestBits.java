package bits;

import org.junit.Test;

public class TestBits {
	
	public static void main(String[] args){
		TestBits T = new TestBits();
		T.testMultiply();
	}
	@Test
	public void testMultiply() {
		
		bits b = new bits();
		System.out.println(b.multiply(15, 9));
	}
	
	@Test
	public void testSmLg() {
		bits b = new bits();
		int[] smLg = b.smLg(0, 15, 5);
		System.out.println("max: " + smLg[0]);
		System.out.println("min: " + smLg[1]);
		
		
		smLg = b.smLg(0, 32, 5);
		System.out.println("max: " + smLg[0]);
		System.out.println("min: " + smLg[1]);
		
		
		smLg = b.smLg(0, 4, 5);
		System.out.println("max: " + smLg[0]);
		System.out.println("min: " + smLg[1]);
	}
}
