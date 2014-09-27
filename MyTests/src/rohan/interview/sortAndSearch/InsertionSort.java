package rohan.interview.sortAndSearch;

public class InsertionSort {

	public static void main(String[] args) {
		int[] input = new int[] { 6, 3, 2, 7, 9 };
		
		int[] output = sort(input);
		
		for (int i : output) {
			System.out.print(i);
			System.out.print(',');
		}
	}

	private static int[] sort(final int[] input) {
		if (input == null || input.length < 2) {
			return input;
		}
		
		int[] output = new int[input.length];
		System.arraycopy(input, 0, output, 0, input.length);
		
		for (int i = 0; i < output.length; i++) {
			int temp = output[i];
			
			int j = i - 1;
			for (; j >= 0; j--) {
				if (output[j] <= temp) {
					break;
				}

				output[j + 1] = output[j];
			}
			
			output[++j] = temp;
		}
		
		return output;
	}
}
