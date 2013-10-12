package bits;

import java.util.ArrayList;
import java.util.List;

public class bits {
	public int multiply(int N, int M) { //M=15
		
		if(M==0) {
			return 0;
		}	
		
		List<Integer> shifts = new ArrayList<Integer>();
		
		while(true) {
			int temp = M;
			int nShift = 0;
			while(temp!=1) {
				temp = temp >> 1;
				nShift++;
			}
			shifts.add(nShift); //nshift=3,2,1,0
			M = M-((int)Math.pow(2, nShift)); //M=7,3,1
			
			if(nShift==0){
				break;
			}
		}

		int result = 0;
		for(Integer shift: shifts) {
			result = result + (N<<shift);
		}
		
		return result;
	}
	
	public int mask(int i, int j, int N, int M) {
		
		int bitsRemoved = removeBits(i, j, N);
		for(int x=1; x<=i; x++){
			M = M<<x;
		}

		return M & bitsRemoved;

	}


	public int removeBits(int i, int j, int N) {
		int comp = ~N; //complement
		int allOne = N|comp;
		
		int temp = 1;
		for(int x=i; x<=j; x++){
			temp = temp | (temp<<x);
		}

		temp = xor(temp,allOne); //xor
		return N&temp;


	}

	public int xor(int x, int y) {
		return (~(x&y) & (x|y));

	}
	

	public int[] smLg(int rangeStart, int rangeEnd, int N) {

		//count the number of 1 Bits in N
		int bitCount = countOneBits(N);
		int[] smLg = new int[2];
		smLg[0] = Integer.MIN_VALUE;
		smLg[1] = Integer.MAX_VALUE;
		
		for(int i=rangeStart; i<=rangeEnd; i++) {
			int count = countOneBits(i);
			if(count==bitCount) {
				if(i>smLg[0]) {
					smLg[0]=i;
				} 

				if(i<smLg[1] ){
					smLg[1] =i;
				}
			}
		}
		
		return smLg;
	}

	public int countOneBits(int N) {
		int bitCount = 0;	
		while(N>0) {
			if(N%2!=0){
				bitCount++;
			}
			N = N >> 1;
		}
		return bitCount;
	}

}
