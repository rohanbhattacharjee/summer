package rohan.interview.sortAndSearch;

public class QuickSort {

	public static void main(String[] args) {
		double[] input = new double[] { 6, 1, 10, 0, -2, 7, 11, -3};

		for (int i = 0; i < input.length; i++) {
			System.out.print(input[i]);
			System.out.print(", ");
		}

		quickSort(input, 0, input.length - 1);
		
		System.out.println();
		for (int i = 0; i < input.length; i++) {
			System.out.print(input[i]);
			System.out.print(", ");
		}
	}

	private static void quickSort(double[] input, int startIndex, int endIndex) {
		System.out.println();
	    if (startIndex >= endIndex) {
	    	return;
	    }
	    
	    int pivotIndex = getPivotIndex(input, startIndex, endIndex);
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
	    
	    // Sort recursively the left of the pivot and the right of the pivot
	    quickSort(input, startIndex, j - 1);
	    quickSort(input, j + 1, endIndex);
	}

	// Decides on a pivot element, and puts it at the endIndex of the input array.
	private static int getPivotIndex(double[] input, int startIndex, int endIndex) {
		int index = startIndex;
		return index;
	}

	private static void swap(double[] input, int index1, int index2) {
		double temp = input[index1];
		input[index1] = input[index2];
		input[index2] = temp;
		
		System.out.println();
		for (int i = 0; i < input.length; i++) {
			System.out.print(input[i]);
			System.out.print(", ");
		}
	}
}
