package rohan.interview.recursion;

import java.util.HashMap;

public class CountWaysToClimbStairs {

	public static void main(String[] args) {

		long startTime = System.currentTimeMillis();
		
		for (int i = 1; i <= 30; i++) {
			HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
			System.out.println(String.format("Total steps = %d, ways = %d", i, countOfWays(i, map)));			
		}
		
		long endTime = System.currentTimeMillis();
		
		System.out.println(String.format("Time to run = %f seconds", (endTime - startTime) / 1000.0));
	}

	static int countOfWays(int n, HashMap<Integer, Integer> map) {
	    if (n < 0) {
	        return 0;
	    }
	    
	    if (n == 0) {
	    	return 1;
	    }

	    if (map.containsKey(n)) {
	    	return map.get(n);
	    }
	    
	    int count = 0;
	    
	    for (int i = 1; i <= 3; i++) {
	        if (n < i) {
	            break;
	        }
	        
	        count += countOfWays(n - i, map);
	    }
	    
	    map.put(n, count);
	    return count;
	}
}
