package rohan.interview.trees;

import java.util.ArrayList;
import java.util.List;

public class Trie {

    private TrieNode root;
    private static final char endOfWordSentinel = '$';
    
    public Trie() {
        this.root = new TrieNode(' ');
    }
    
    public static void main(String[] args) {
    	List<String> words = getWords();
    	
    	Trie trie = new Trie();
    	trie.buildTrie(words);
    	
    	String prefix = "bo";
    	List<String> results = trie.getWords(prefix);
    	
    	System.out.println("prefix = " + prefix);
    	System.out.println("------");
    	for (String result : results) {
    		System.out.println(result);
    	}
    }
    
    public void buildTrie(List<String> words) {
        if (words == null || words.size() == 0) {
            return;
        }
        
        for (String word : words) {
            char[] chars = word.toCharArray();
            
            TrieNode node = root;
            
            for (char character : chars) {
                if (! node.containsChild(character)) {
                    node.addChild(character);
                }
                
                node = node.getChild(character);
            }
            
            node.addChild(endOfWordSentinel);
        }
    }
    
    public List<String> getWords(String prefix) {
        if (prefix == null) {
            prefix = "";
        }

        prefix = prefix.trim();
       
        char[] characters = prefix.toCharArray();
        
        TrieNode node = root;
        
        for (char character : characters) {
            if (! node.containsChild(character)) {
                return new ArrayList<String>();
            }
            
            node = node.getChild(character);
        }
        
        List<String> allSuffixes = getAllSubtrees(node);
        List<String> allWords = new ArrayList<String>(allSuffixes.size());
        
        
        for (String suffix : allSuffixes) {
            String word = prefix.substring(0, prefix.length() - 1) + suffix;
            allWords.add(word); 
        }
        
        return allWords;
    }
    
    private List<String> getAllSubtrees(TrieNode node) {
    	StringBuffer buffer = new StringBuffer();
    	List<String> allSubtrees = new ArrayList<String>();

    	getAllSubtrees(node, buffer, allSubtrees);

        return allSubtrees;
    }
    
    private void getAllSubtrees(TrieNode node, StringBuffer buffer, List<String> allSubtrees)  {
    	if (node == null) {
    		return;
    	}
    	
    	if (node.value == endOfWordSentinel) {
    		allSubtrees.add(buffer.toString());
    		return;
    	}
    	
    	buffer.append(node.value);
    	
    	for (TrieNode child : node.children) {
    		getAllSubtrees(child, buffer, allSubtrees);
    	}
    	
    	buffer.setLength(buffer.length() - 1);
    }

    private static List<String> getWords() {
    	List<String> words = new ArrayList<String>();
    	
    	words.add("army");
    	words.add("bad");
    	words.add("boat");
    	words.add("boy");
    	words.add("body");
    	words.add("bodyguard");
    	
    	return words;
    }

    private class TrieNode {
        char value;
        List<TrieNode> children;
        
        TrieNode(char value) {
            this.value = value;
        }
        
        public boolean containsChild(char character) {
            if (children == null || children.size() == 0) {
                return false;
            }

            TrieNode temp = new TrieNode(character);
            return children.contains(temp);   
        }

        public void addChild(char character) {
            if (children == null) {
                children = new ArrayList<TrieNode>();
            }
            
            TrieNode newChild = new TrieNode(character);
            children.add(newChild);
        }
        
        public TrieNode getChild(char character) {
            if (! containsChild(character)) {
                return null;
            }
            
            TrieNode child = new TrieNode(character);
            return children.get(children.indexOf(child));
        }

        @Override
        public boolean equals(Object other) {
            if (other == null) {
                return false;
            }
            
            if (other instanceof TrieNode) {
                return value == ((TrieNode) other).value;
            }
            
            return false;
        }
        
        @Override
        public int hashCode() {
            return value;
        }
        
        @Override
        public String toString() {
        	return String.valueOf(value);
        }
    }
}