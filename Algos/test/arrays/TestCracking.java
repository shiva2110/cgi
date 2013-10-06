package arrays;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class TestCracking {
	
	@Test
	public void testcheckUniqueChars(){
		Cracking c = new Cracking();
		assertTrue(c.checkUniqueChars(null));
		assertTrue(c.checkUniqueChars(""));
		assertFalse(c.checkUniqueChars("aaaaa"));
		assertFalse(c.checkUniqueChars("abcdc"));
		assertTrue(c.checkUniqueChars("abcde"));
	}
	
	@Test
	public void testreverse(){
		Cracking c = new Cracking();
		assertTrue(Arrays.equals( c.reverse("\0".toCharArray()),  "\0".toCharArray()));
		assertTrue(Arrays.equals( c.reverse("a\0".toCharArray()),  "a\0".toCharArray()));
		assertTrue(Arrays.equals( c.reverse("abc\0".toCharArray()),  "cba\0".toCharArray()));
		assertTrue(Arrays.equals( c.reverse("ab\0cd\0".toCharArray()),  "dc\0ba\0".toCharArray()));
		
	}
	
	@Test
	public void testremoveDupChars(){
		Cracking c = new Cracking();
		assertEquals(c.removeDupChars(""), "");
		assertEquals(c.removeDupChars("a"), "a");
		assertEquals(c.removeDupChars("aa"), "a");
		assertEquals(c.removeDupChars("abcfdfg"), "abcfdg");
		assertEquals(c.removeDupChars("abcdb"), "abcd");
		assertEquals(c.removeDupChars("abccde"), "abcde");
	}
	
	@Test
	public void testremoveDupCharsSlow(){
		Cracking c = new Cracking();
		assertEquals(c.removeDupCharsSlow(""), "");
		assertEquals(c.removeDupCharsSlow("a"), "a");
		assertEquals(c.removeDupCharsSlow("aa"), "a");
		assertEquals(c.removeDupCharsSlow("abcfdfg"), "abcfdg");
		assertEquals(c.removeDupCharsSlow("abcdb"), "abcd");
		assertEquals(c.removeDupCharsSlow("abccde"), "abcde");
	}
	
	@Test
	public void testIsAnagram(){
		Cracking c = new Cracking();
		assertTrue(c.isAnagram("", ""));
		assertTrue(c.isAnagram("a", "a"));
		assertFalse(c.isAnagram(null, "a"));
		assertTrue(c.isAnagram("abcdde", "ebaddc"));
		assertFalse(c.isAnagram("abcde", "ebaddc"));
		assertFalse(c.isAnagram("abcddde", "ebaddc"));
		assertTrue(c.isAnagram("abbbbcdde", "ebabdbdcb"));
	}
	
	@Test
	public void testReplaceSpace(){
		Cracking c = new Cracking();
		assertTrue(Arrays.equals(c.replaceSpace("".toCharArray()), "".toCharArray()));
		assertTrue(Arrays.equals(c.replaceSpace("a".toCharArray()), "a".toCharArray()));
		assertTrue(Arrays.equals(c.replaceSpace(" a".toCharArray()), "%20a".toCharArray()));
		assertTrue(Arrays.equals(c.replaceSpace(" a ".toCharArray()), "%20a%20".toCharArray()));
		assertTrue(Arrays.equals(c.replaceSpace("   ".toCharArray()), "%20%20%20".toCharArray()));
		assertTrue(Arrays.equals(c.replaceSpace("a b c ".toCharArray()), "a%20b%20c%20".toCharArray()));
	}
	
	@Test
	public void testrotate() {
		Cracking c = new Cracking();
		int[][] image = new int[4][4];
		image[0][0] = 101;
		image[0][1] = 102;
		image[0][2] = 103;
		image[0][3] = 104;
		
		image[1][0] = 111;
		image[1][1] = 112;
		image[1][2] = 113;
		image[1][3] = 114;
		
		image[2][0] = 121;
		image[2][1] = 122;
		image[2][2] = 123;
		image[2][3] = 124;
		
		image[3][0] = 131;
		image[3][1] = 132;
		image[3][2] = 133;
		image[3][3] = 134;
		
		image = c.rotate(image)	;
		
		System.out.println("===========");
		for(int i=0; i<4; i++){
			for(int j=0; j<4; j++){
				System.out.print(image[i][j] + ",");
			}
			System.out.println();
		}	
	}
	
	@Test
	public void teststrike(){
		int[][] arr = new int[4][3];
		arr[0][0] = 0;
		arr[0][1] = 0;
		arr[0][2] = 0;
		
		arr[1][0] = 2;
		arr[1][1] = 4;
		arr[1][2] = 13;
		
		arr[2][0] = 2;
		arr[2][1] = 4;
		arr[2][2] = 13;
		
		arr[3][0] = 0;
		arr[3][1] = 4;
		arr[3][2] = 13;
		
		Cracking c = new Cracking();
		int[][] result = c.strikeZeros(arr);
		
		for(int i=0; i<result.length; i++){
			c.print(result[i]);
		}
		
		
	}
}
