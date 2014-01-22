package search;

public class Subset {
	public static void main(String[] args){
		Subset S = new Subset();
		S.findSubsets(new char[]{'A', 'B', 'C'});
	}
	
	public void findSubsets(char[] c) {
		int bytArrLen = (c.length/8) + 1;
		byte[] bytArr = new byte[bytArrLen];
		findSubsets(bytArr, 0, c);
	}
	
	public void findSubsets(byte[] bytArr, int k, char[] c) {
		if(k==c.length) {
			printSubset(bytArr, c);
			return;
		}
		
		
	
		int index = k/8;
		int subIndex = k%8;
		int mask = 1;
		while(subIndex>0) {
			mask = mask << 1;
			subIndex--;
		}
		
		
		
		bytArr[index] = (byte) (bytArr[index] ^ mask);
		findSubsets(bytArr, k+1, c);
		bytArr[index] = (byte) (bytArr[index] ^ mask);
		findSubsets(bytArr, k+1, c);
	}
	
	public void printSubset(byte[] bytArr, char[] c) {
		
		int index =0 ;
		for(int i=0; i<bytArr.length; i++) {
			byte b = bytArr[i];			
			
			for(int j=0; j<8; j++) {				
				if((b & 1)==1) {
					System.out.print(c[index] + ",");
				}
				b=(byte) (b>>1);
				index++;
			}
		}
		
		System.out.println();
	}
	

}
