package rohan.interview.recursion;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * This version of the code is not memoized. It should be easy to do the caching
 * by storing information with the key as sentence, and the value as the list of
 * words (even if that list is empty).
 * @author Rohan
 *
 */
public class SplitIntoWords {
    public static void main(String[] args) {
        HashSet<String> dictionary = initializeDictionary();
        
        String sentence = "bedbathandbeyond";
        List<List<String>> allWords = splitIntoWords(sentence.toLowerCase(), dictionary);
        
        System.out.println(sentence);
        for (List<String> words : allWords) {
        	for (String word : words) {
                System.out.print(word);
                System.out.print(" ");
        	}
        	
        	System.out.println();
        }
        
        System.out.println();
        System.out.println("---------");
        
        String sentence2 = "bedbathandbeyonds";
        List<List<String>> allWords2 = splitIntoWords(sentence2.toLowerCase(), dictionary);

        System.out.println(sentence2);
        for (List<String> words : allWords2) {
        	for (String word : words) {
                System.out.print(word);
                System.out.print(" ");
        	}
        	
        	System.out.println();
        }

        System.out.println();
        System.out.println("---------");
    }
    
    public static List<List<String>> splitIntoWords(String sentence, HashSet<String> dictionary) {
        if (sentence == null || sentence.isEmpty()) {
            return new ArrayList<List<String>>();
        }
        
        List<List<String>> words = new ArrayList<List<String>>();
        
        for (int i = 1; i <= sentence.length(); i++) {
            String candidateWord = sentence.substring(0, i);
            
            if (! dictionary.contains(candidateWord)) {
                continue;
            }
            
            String remainingSentence = sentence.substring(i);
            
            if (remainingSentence == null || remainingSentence.isEmpty()) {
                List<String> currentWord = new ArrayList<String>();
                currentWord.add(candidateWord);
                words.add(currentWord);

                break;
            }
                        
            List<List<String>> followingWords = splitIntoWords(remainingSentence, dictionary);
            
            if (followingWords != null && followingWords.size() > 0) {
            	for (List<String> possibleWordSequences : followingWords) {
            		possibleWordSequences.add(0, candidateWord);
            		words.add(possibleWordSequences);
            	}
            }
        }
        
        return words;
    }
    
    private static HashSet<String> initializeDictionary() {
        HashSet<String> dictionary = new HashSet<String>();
        dictionary.add("and");
        dictionary.add("bath");
        dictionary.add("bed");
        dictionary.add("beyond");
        dictionary.add("hand");
        dictionary.add("bat");

        return dictionary;    
    }
}