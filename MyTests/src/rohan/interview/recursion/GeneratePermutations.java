package rohan.interview.recursion;

import java.util.ArrayList;
import java.util.List;

public class GeneratePermutations {

	public static void main(String[] args) {
		final String input = "abcde";
		List<String> permutations = getPermutations(input);
		
		int count = 0;
		for (String permutation : permutations) {
			System.out.println(String.format("%d: %s", ++count, permutation));
		}
	}
	
	public static List<String> getPermutations(String input) {
	    if (input == null) {
	        return new ArrayList<String>();
	    }
	    
	    return getPermutations(input, 0);
	}

	private static List<String> getPermutations(String input, int position) {
	    if (input == null || input.isEmpty()) {
	        return new ArrayList<String>();
	    }
	    
	    if (position < 0 || position >= input.length()) {
	        throw new IllegalArgumentException("position is outside the valid range");
	    }

	    if (position == input.length() - 1) {
	        List<String> permutation = new ArrayList<String>();
	        permutation.add(String.valueOf(input.charAt(position)));
	        return permutation;
	    }
	    
	    List<String> permutations = getPermutations(input, position + 1);
	    
	    List<String> newPermutations = new ArrayList<String>();
	    String currentChar = String.valueOf(input.charAt(position));
	    
	    for (String permutation : permutations) {     
	        newPermutations.addAll(insertAtAllPositions(permutation, currentChar));
	    }
	    
	    return newPermutations;
	}

	private static List<String> insertAtAllPositions(String permutation, String currentChar) {

	    List<String> newPermutations = new ArrayList<String>();

	    for (int i = 0; i <= permutation.length(); i++) {
	        String newPermutation = permutation.substring(0, i) + currentChar + permutation.substring(i);
	        newPermutations.add(newPermutation);
	    }
	    
	    return newPermutations;
	}
}
