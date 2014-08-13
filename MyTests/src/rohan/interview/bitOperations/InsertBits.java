package rohan.interview.bitOperations;

public class InsertBits {

	public static void main(String[] args) {
		int n = 1 << 10;
		System.out.println(Integer.toBinaryString(n));
		int m = 19;
		System.out.println(Integer.toBinaryString(m));
		
		int i = 2;
		int j = 6;
		
		int k = insert(n, m , i, j);
		System.out.println(Integer.toBinaryString(k));
	}

	private static int insert(int n, int m, int i, int j) {
	
		int mask = 1 << (j - i + 1);
		System.out.println(Integer.toBinaryString(mask));
		
		mask = mask - 1;
		System.out.println(Integer.toBinaryString(mask));
		
		mask = mask << i;
		System.out.println(Integer.toBinaryString(mask));
		
		mask = ~mask;
		System.out.println(Integer.toBinaryString(mask));
		
		n = n & mask;
		System.out.println(Integer.toBinaryString(n));

		m = m << i;
		System.out.println(Integer.toBinaryString(m));

		n = n | m;
		System.out.println(Integer.toBinaryString(n));
		
		return n;
	}

}
