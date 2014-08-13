package rohan.interview.recursion;

import java.util.ArrayList;
import java.util.List;

public class GenerateAllSubsets {

	public static void main(String[] args) {
		List<String> elements = new ArrayList<String>();
		addElements(elements);
		
		List<List<String>> subsets = new ArrayList<List<String>>();
		
		findSubsets(elements, 0, subsets);
		printElements(subsets);
	}

	static void findSubsets(List<String> elements, int position, List<List<String>> subsets) {
		if (elements == null || elements.size() == 0) {
			return;
		}
		
		if (position >= elements.size()) {
			subsets.add(new ArrayList<String>());
			return;
		}
		
		String element = elements.get(position);
		
		findSubsets(elements, position + 1, subsets);
		
		List<List<String>> newSubsets = new ArrayList<List<String>>();

		for (List<String> subset : subsets) {
			List<String> subsetCopy = new ArrayList<String>(subset);
			subsetCopy.add(element);		
			newSubsets.add(subsetCopy);
		}
		
		subsets.addAll(newSubsets);
	}
	
	private static void addElements(List<String> elements) {
		elements.add("A");
		elements.add("B");
		elements.add("C");
		elements.add("D");
	}

	private static void printElements(List<List<String>> subsets) {
		int count = 0;

		for (List<String> subset : subsets) {
			count++;
			
			for (String element : subset) {
				System.out.print(element);
				System.out.print(" - ");
			}
			
			System.out.println();
		}
		
		System.out.println(String.format("Subset count = %d" , count));
	}
}
