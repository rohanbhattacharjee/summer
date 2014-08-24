package rohan.interview.sortAndSearch;

public class MaximumSumSubarray {
    public static void main(String[] args) {
    	
        int[] input1 = makeArray1();
        int maximumSum1 = findMaximumSum(input1);
        System.out.println(maximumSum1);
        
        int[] input2 = makeArray2();
        int maximumSum2 = findMaximumSum(input2);
        System.out.println(maximumSum2);
        
        int[] input3 = makeArray3();
        int maximumSum3 = findMaximumSum(input3);
        System.out.println(maximumSum3);
    }
    
    private static int findMaximumSum(int[] input) {
        if (input == null) {
            return 0;
        }
        
        int maximumSum = 0;
        int currentSum = 0;
        
        for (int i = 0; i < input.length; i++) {
            if (currentSum + input[i] > 0) {
                currentSum = currentSum + input[i];
            }
            else {
            	currentSum = 0;
            }
            
            if (currentSum > maximumSum) {
                maximumSum = currentSum;
            }
        }

        return maximumSum;
    }
    
    private static int[] makeArray1() {
        int[] input = new int[] { 2, 3, -8, -1, 2, 4, -2, 3 };
        return input;
    }
    
    private static int[] makeArray2() {
        int[] input = new int[] { 3, 4, -3, -1, 8, -11, 12 };
        return input;
    }
    
    private static int[] makeArray3() {
        int[] input = new int[] { -3, -1, -11 };
        return input;
    }
}
