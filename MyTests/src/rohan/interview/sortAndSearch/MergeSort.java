package rohan.interview.sortAndSearch;

public class MergeSort {

	public static void main(String[] args) {
		double[] input = new double[] { 6, 1, 10, 0, -2, 7, 11, -3};

		for (int i = 0; i < input.length; i++) {
			System.out.print(input[i]);
			System.out.print(", ");
		}

		mergeSort(input, 0, input.length - 1);
		
		System.out.println();
		for (int i = 0; i < input.length; i++) {
			System.out.print(input[i]);
			System.out.print(", ");
		}
	}

	private static void mergeSort(double[] input, int startIndex, int endIndex) {
		if (startIndex >= endIndex) {
			return;
		}
		
		int middleIndex = (startIndex + endIndex) / 2;
		
		mergeSort(input, startIndex, middleIndex);
		mergeSort(input, middleIndex + 1, endIndex);
		
		double[] sortedArray1 = new double[middleIndex - startIndex + 1];
		double[] sortedArray2 = new double[endIndex - (middleIndex + 1) + 1];
		
		System.arraycopy(input, startIndex, sortedArray1, 0, sortedArray1.length);
		System.arraycopy(input, middleIndex + 1, sortedArray2, 0, sortedArray2.length);
		
		double[] mergedSortedArray = merge(sortedArray1, sortedArray2);
		
		System.arraycopy(mergedSortedArray, 0, input, startIndex, mergedSortedArray.length);
	}

	private static double[] merge(double[] sortedArray1, double[] sortedArray2) {
		double[] mergedSortedArray = new double[sortedArray1.length + sortedArray2.length];
		
		int index1 = 0;
		int index2 = 0;
		int mergeIndex = 0;
		
		while (index1 < sortedArray1.length && index2 < sortedArray2.length) {
			if (sortedArray1[index1] <= sortedArray2[index2]) {
				mergedSortedArray[mergeIndex++] = sortedArray1[index1++];
			}
			else {
				mergedSortedArray[mergeIndex++] = sortedArray2[index2++];
			}
		}
		
		double[] remainingArray = index1 < sortedArray1.length ? sortedArray1 : sortedArray2;
		int remainingIndex = index1 < sortedArray1.length ? index1 : index2;

		System.arraycopy(remainingArray, remainingIndex, mergedSortedArray, mergeIndex, remainingArray.length - remainingIndex);
		
		return mergedSortedArray;
	}
}
