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
	    if (startIndex >= endIndex) {
	    	return;
	    }
	    
	    int pivotIndex = getPivotIndex(input, startIndex, endIndex);

	    int pivotPosition = partition(input, startIndex, endIndex, pivotIndex);
	    
	    // Sort recursively the left of the pivot and the right of the pivot
	    quickSort(input, startIndex, pivotPosition - 1);
	    quickSort(input, pivotPosition + 1, endIndex);
	}

	private static int partition(double[] input, int startIndex, int endIndex, int pivotIndex) {
		double pivotValue = input[pivotIndex];
		swap(input, pivotIndex, endIndex);
		
		int i = startIndex - 1;
		
		for (int j = startIndex; j <= endIndex - 1; j++) {
			if (input[j] <= pivotValue) {
				i++;
				swap(input, i, j);
			}
		}
		
		swap(input, i + 1, endIndex);
		return i + 1;
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
	}
}
