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
	
	
	@Test
	public void testPos(){
		System.out.println("-----------");
		bits b = new bits();
		bitPos pos = b.findBitPosFromRight(13, 4);
		System.out.println("position of 0: " + pos.pos0);
		System.out.println("position of 1: " + pos.pos1);
		System.out.println("-----------");
	}
	
	
	@Test
	public void testPosFromRight(){
		System.out.println("-----------");
		bits b = new bits();
		int pos = b.findPosFromRight(1, 5);
		System.out.println("position of 1 in 101: " +  pos);
		System.out.println("-----------");
	}
}
