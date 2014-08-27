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
        List<String> words = splitIntoWords(sentence.toLowerCase(), dictionary);
        
        System.out.println(sentence);
        for (String word : words) {
            System.out.print(word);
            System.out.print(" ");
        }
        
        System.out.println();
        System.out.println("---------");
        
        HashSet<String> dictionary2 = initializeDictionary2();
        
        String sentence2 = "bedbathandbeyond";
        List<String> words2 = splitIntoWords(sentence2.toLowerCase(), dictionary2);
        
        System.out.println(sentence2);
        for (String word : words2) {
            System.out.print(word);
            System.out.print(" ");
        }

        System.out.println();
        System.out.println("---------");

        String sentence3 = "bedbathandbeyonds";
        List<String> words3 = splitIntoWords(sentence3.toLowerCase(), dictionary2);
        
        System.out.println(sentence3);
        for (String word : words3) {
            System.out.print(word);
            System.out.print(" ");
        }
        
        System.out.println();
        System.out.println("---------");
    }
    
    public static List<String> splitIntoWords(String sentence, HashSet<String> dictionary) {
        if (sentence == null || sentence.isEmpty()) {
            return new ArrayList<String>();
        }
        
        List<String> words = new ArrayList<String>();
        
        for (int i = 1; i <= sentence.length(); i++) {
            String candidateWord = sentence.substring(0, i);
            
            if (! dictionary.contains(candidateWord)) {
                continue;
            }
            
            words.add(candidateWord);
            
            String remainingSentence = sentence.substring(i);
            
            if (remainingSentence == null || remainingSentence.isEmpty()) {
                break;
            }
                        
            List<String> followingWords = splitIntoWords(remainingSentence, dictionary);
            
            if (followingWords == null || followingWords.size() == 0) {
                words.remove(candidateWord);
            }
            else {
                words.addAll(followingWords);
                break;
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

        return dictionary;    
    }
    
    private static HashSet<String> initializeDictionary2() {
        HashSet<String> dictionary = new HashSet<String>();
        dictionary.add("hand");
        dictionary.add("bat");
        dictionary.add("bed");
        dictionary.add("beyond");

        return dictionary;    
    }
}