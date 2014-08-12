package rohan.interview.sortAndSearch;

public class FindKthSmallestElement {

	public static void main(String[] args) {
		float[] input = new float[] { 3, 2, 1, 5, 4 };
		float kthSmallest = findKthSmallestElement(input, 0);
		System.out.println(kthSmallest);
		
		input = new float[] { 3, 2, 1, 5, 4 };
		kthSmallest = findKthSmallestElement(input, 1);
		System.out.println(kthSmallest);

		input = new float[] { 3, 2, 1, 5, 4 };
		kthSmallest = findKthSmallestElement(input, 2);
		System.out.println(kthSmallest);

		input = new float[] { 3, 2, 1, 5, 4 };
		kthSmallest = findKthSmallestElement(input, 3);
		System.out.println(kthSmallest);

		input = new float[] { 3, 2, 1, 5, 4 };
		kthSmallest = findKthSmallestElement(input, 4);
		System.out.println(kthSmallest);
	}

	public static float findKthSmallestElement(float[] input, int k) {
	    if (input == null || input.length == 0) {
	        throw new IllegalArgumentException("input is empty");
	    }
	    
	    if (k < 0 || k > input.length - 1) {
	        throw new IllegalArgumentException("invalid k");
	    }
	    
	    return findKthSmallestElement(input, k, 0, input.length - 1);
	}

	private static float findKthSmallestElement(float[] input, int k, int startIndex, int endIndex) {
	    if (startIndex >= endIndex) {
	        assert(k == 0);
	        return input[startIndex];
	    }
	    
	    int pivotIndex = getPivotIndex(input, startIndex, endIndex);
	    
	    int pivotPosition = partition(input, startIndex, endIndex, pivotIndex);
	    
	    if (pivotPosition == k) {
	        return input[pivotPosition];
	    }
	    
	    if (pivotPosition > k) {
	        return findKthSmallestElement(input, k, startIndex, pivotPosition - 1);
	    }
	    
	    return findKthSmallestElement(input, k - pivotPosition, pivotPosition + 1, endIndex);
	}

	private static int getPivotIndex(float[] input, int startIndex, int endIndex) {
	    return startIndex;
	}

	private static int partition(float[] input, int startIndex, int endIndex, int pivotIndex) {
	    double pivotValue = input[pivotIndex];
	    
	    swap(input, pivotIndex, endIndex);
	    
	    // Arrange all the numbers such that numbers smaller than the pivot
	    // are to the left of the numbers larger than the pivot
	    int i = startIndex;
	    int j = endIndex;
	    
	    while (i < j) {
	        for (; i <= j; i++) {
	            if (input[i] > pivotValue) {
	                break;
	            }
	        }

	        for (; j > i; j--) {
	            if (input[j] < pivotValue) {
	                break;
	            }
	        }

	        if (i < j) {
		        swap(input, i, j);	        	
	        }
	    }
	    
	    // Put the pivot in the right place
	    swap(input, j, endIndex);
	    
	    return j;
	}

	private static void swap(float[] input, int index1, int index2) {
	    float temp = input[index1];
	    input[index1] = input[index2];
	    input[index2] = temp;
	}
}
