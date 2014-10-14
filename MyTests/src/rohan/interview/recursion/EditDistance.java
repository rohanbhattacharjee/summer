package rohan.interview.recursion;

import java.util.HashMap;

public class EditDistance {

	private static final String keyFormat = "%s_%s";
	private static final int insertCost = 1;
	private static final int deleteCost = 1;
	private static final int replaceCost = 1;
	
	public static void main(String[] args) {
		String word1 = "that";
		String word2 = "htat";
		System.out.println(String.format("%s : %s : %d", word1, word2, minDistance(word1, word2)));
		
		word1 = "hat";
		word2 = "that";
		System.out.println(String.format("%s : %s : %d", word1, word2, minDistance(word1, word2)));
		
		word1 = "property";
		word2 = "prosperity";
		System.out.println(String.format("%s : %s : %d", word1, word2, minDistance(word1, word2)));
		
		word1 = "theirs";
		word2 = "there";
		System.out.println(String.format("%s : %s : %d", word1, word2, minDistance(word1, word2)));

		word1 = "one";
		word2 = "";
		System.out.println(String.format("%s : %s : %d", word1, word2, minDistance(word1, word2)));
	}

    /**
     * computes the cost to transform word1 into word2
     */
    public static int minDistance(String word1, String word2) {
        if (word1 == null) {
            word1 = "";
        }
        
        if (word2 == null) {
            word2 = "";
        }
        
        HashMap<String, Integer> cache = new HashMap<String, Integer>();
        return minDistance(word1.toCharArray(), word1.length() - 1, word2.toCharArray(), word2.length() - 1, cache);
    }
    
    private static int minDistance(char[] word1, int index1, char[] word2, int index2, HashMap<String, Integer> cache) {
        String key = String.format(keyFormat, index1, index2);
        
        if (cache.containsKey(key)) {
            return cache.get(key);
        }
        
        if (index1 < 0) {
            cache.put(key, (index2 + 1) * insertCost);
            return cache.get(key);
        }
        
        if (index2 < 0) {
            cache.put(key, (index1 + 1) * deleteCost);
            return cache.get(key);
        }
        
        char word1Char = word1[index1];
        char word2Char = word2[index2];
        
        if (word1Char == word2Char) {
            int cost = minDistance(word1, index1 - 1, word2, index2 - 1, cache);
            cache.put(key, cost);
            return cost;
        }
        else {
            int costOfInsert = insertCost + minDistance(word1, index1, word2, index2 - 1, cache);
            int costOfDelete = deleteCost + minDistance(word1, index1 - 1, word2, index2, cache);
            int costOfReplace = replaceCost + minDistance(word1, index1 - 1, word2, index2 - 1, cache);

            int cost = Math.min(Math.min(costOfInsert, costOfDelete), costOfReplace);
            cache.put(key, cost);
            return cost;
        }
    }
}
