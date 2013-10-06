package arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Cracking {
	public boolean checkUniqueChars(String s) {
		if(s==null){
			return true;
		}
		char[] cArr = s.toCharArray();
		boolean[] ascii = new boolean[128];
		for(char c : cArr) {
			int i = (int) c;
			if(ascii[i]) {
				return false;
			}
			ascii[i] = true;
		}
		return true;	
	}
	
	public char[] reverse(char[] cArr){
		
		char[] reverseStr = new char[cArr.length];
		int j = 0;
		if(cArr.length>=1) {
			for(int i=cArr.length-2; i>=0; i--){
				reverseStr[j] = cArr[i];
				j++;
			}
		}
		reverseStr[j] = '\0';
		return reverseStr;
	}
	
	
	public String removeDupChars(String s){
		char[] cArr = s.toCharArray();
		boolean[] buffer = new boolean[128];
		StringBuilder sb = new StringBuilder();

		for(char c: cArr){
			if(!buffer[c]){
				sb.append(c );
			}
			buffer[c] = true;
		}
		return sb.toString();
	}
	
	public String removeDupCharsSlow(String s){
		char[] cArr = s.toCharArray();
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<cArr.length; i++) {
			if(i==0) {
				sb.append(cArr[i]); continue;
			}
		
			boolean dup = false;
			for(int j=0; j<i; j++){
				if(cArr[i]==cArr[j]) {
					dup=true;
					break;
				}
			}

			if(!dup){
				sb.append(cArr[i]);
			}
		}

		return sb.toString();
	}
	
	public boolean isAnagram(String s1, String s2){
		if(s1==null || s2==null){
			return false;
		}
		
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		char[] cArr = s1.toCharArray();
		for(char c: cArr) {
			Character ch = new Character(c);
			Integer i = null;
			if((i=map.get(ch))!=null){
				i++;
				map.put(ch, i++);
			} else {
				map.put(ch, 1);
			}
		}

		cArr = s2.toCharArray();
		for(char c: cArr) {
			Character ch = new Character(c);
			Integer i = null;
			if((i=map.get(ch))!=null){
				i--;
				map.put(ch, i);
			} else {
				return false;
			}
		}

		for(Character c: map.keySet()) {
			if(!map.get(c).equals(0)){
				return false;
			}
		}

		return true;
		
	}
	
	
	public char[] replaceSpace(char[] str) {

		int count = 0;
		for(char c: str) {
			if(c==' '){
				count++;
			}
		}
		
		count = (str.length - count) + (count*3);

		if(count==0) {
			return str;
		}

		char[] str2 = new char[count];
		int i=0;
		for(char c: str) {
			if(c==' ') {
				str2[i] = '%';
				str2[++i] = '2';
				str2[++i] = '0';
			} else {
				str2[i] = c;
			}

			i++;
		}

		System.out.println(str2);
		return str2;
	}
	
	int[][] image;
	
	public int[][] rotate(int[][] image) {
		this.image = image;
		rotateRec(image.length-1, image.length-1, 0, 0);
		return this.image;
		
	}

	public void rotateRec(int rowLen, int colLen, int x, int y) { 

		System.out.println(rowLen + "; " + colLen + "; " + x + "; " + y);
		if(x>rowLen || y>colLen) {
			return;
		}

		int[] temp0 = getRow(x, y, colLen);		
		int[] temp1 = getCol(colLen, x, rowLen); 
		int[] temp2 = getRow(rowLen, y, colLen); 
		int[] temp3 = getCol(y, x, rowLen); 
		
		setCol(colLen, temp0, x, rowLen); 
		setRow(rowLen, temp1, y, colLen); 
		setCol(y, temp2, x, rowLen); 	 
		setRow(x, temp3, y, colLen); 

		rotateRec(rowLen-1, colLen-1, ++x, ++y);
	}

	public int[] getCol(int colIndex, int start, int end) {
		int[] ret = new int[(end-start)+1];
		int j=0;
		for(int i=start; i<=end; i++){
			ret[j] = image[i][colIndex];
			j++;
		}
		return ret;
	}

	public int[] getRow(int rowIndex, int start, int end) {
		int[] ret = new int[(end-start)+1];
		int j=0;
		for(int i=start; i<=end; i++){
			ret[j] = image[rowIndex][i];
			j++;
		}
		return ret;
	}


	public void setCol(int colIndex, int[] values, int start, int end){
		int valIndex = 0;
		for(int i=start; i<=end; i++) {
			image[i][colIndex] = values[valIndex];
			valIndex++;
		}
	}

	public void setRow(int rowIndex, int[] values, int start, int end){
		int valIndex = values.length-1;
		for(int i=start; i<=end; i++) {
			image[rowIndex][i] = values[valIndex];
			valIndex--;
		}
	}
	
	public void print(int[] temp){
		for(int i=0; i<temp.length; i++){
			System.out.print(temp[i] + ",");
		}
		System.out.println();
	}
	
	
	int[][] arr;
	
	public int[][] strikeZeros(int[][] arr){

		this.arr = arr;
		if(arr.length==0){
			return arr;
		}

		Set<Integer> set = new HashSet<Integer>();
		for(int i=0; i<arr[0].length; i++) {
			set.add(new Integer(i));
		}
		
		int rows = arr.length;

		int count = 0;
		for(int r=0; r<rows; r++) {
			count++;
			List<Integer> list = new ArrayList<Integer>();
			for(Integer c: set) {
				if(arr[r][c]==0){
					list.add( c);
				}
			}

			if(list.size()!=0) {
				for(Integer c: list) {
					strikeCol( c);
					set.remove( c);
				}
				strikeRow( r);
			}
			
			if(set.isEmpty()){
				break;
			}
		}
		
		System.out.println("rows parsed: " + count);
		
		return arr;
	}

	public void strikeCol(Integer c) {
		for(int i=0; i<arr.length; i++){
			arr[i][c] = 0;
		}
	}

	public void strikeRow(Integer r) {
		for(int i=0; i<arr[r].length; i++){
			arr[r][i] = 0;
		}
	}

}
