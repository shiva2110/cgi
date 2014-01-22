package search;

import java.util.HashSet;
import java.util.Set;

public class Permutation {
	
	
	public static void main(String[] args) {
		char[] cArr = new char[] {'A', 'B', 'C'};
		Permutation P = new Permutation();
		P.findPermutations(cArr);
	}
	
	char[] cArr;

	public void findPermutations(char[] cArr) {
		this.cArr = cArr;
		int bArrLen = (cArr.length/8) + 1;
		byte[] bArr = new byte[bArrLen];
		char[] perm = new char[cArr.length];
		
		permute(bArr, 0, perm);
	}
	
	public void permute(byte[] bArr, int k, char[] perm) {
		if(k==cArr.length) {
			System.out.println(String.valueOf(perm));
			return;
		}
		
		
		byte[] localSet = new byte[16];
		
		for(int i=0; i<cArr.length; i++){
			if(!isOne(bArr, i) && !isOne(localSet, cArr[i])){
				perm[k] = cArr[i];
				flipBit(bArr, i);
				flipBit(localSet, cArr[i]);
				permute(bArr, k+1, perm);
				
				//revert
				flipBit(bArr, i);
				perm[k] = '\0';
			}
		}
		
	}
	

	
	private void flipBit(byte[] bArr, int i) {
		int index = i/8;
		int subIndex = i%8;
		int mask = 1;
		
		while(subIndex > 0) {
			mask = mask << 1;
			subIndex --;
		}
		
		bArr[index] = (byte) (bArr[index] ^ mask);
	}	
	
	private boolean isOne(byte[] bArr, int i) {
		int index = i/8;
		int subIndex = i%8;
		int mask = 1;
		
		while(subIndex > 0) {
			mask = mask << 1;
			subIndex --;
		}
		
		return (bArr[index] & mask) > 0;
	}
}
