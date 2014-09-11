package rohan.interview.linkedList;

import java.util.HashMap;
import java.util.LinkedList;

public class LRUCache {
    
    private HashMap<Integer, Integer> cache;
    private LinkedList<Integer> queue;
    private final int capacity;
    
    public static void main(String[] args) {
    	int capacity = 2;
    	LRUCache lruCache = new LRUCache(capacity);
    	
    	lruCache.set(2, 1);
    	System.out.println(String.format("%s = %d", "get(2)", lruCache.get(2)));
    	
    	lruCache.set(1, 1);
    	System.out.println(String.format("%s = %d", "get(1)", lruCache.get(1)));
    	
    	lruCache.set(4, 1);
    	System.out.println(String.format("%s = %d", "get(4)", lruCache.get(4)));
    	System.out.println(String.format("%s = %d", "get(2)", lruCache.get(2)));
    	System.out.println(String.format("%s = %d", "get(1)", lruCache.get(1)));
    }
    
    public LRUCache(int capacity) {
        assert(capacity > 0);
        this.capacity = capacity;
        cache = new HashMap<Integer, Integer>(capacity);
        queue = new LinkedList<Integer>();
    }
    
    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }
        
        int value = cache.get(key);
        queue.remove(new Integer(key));
        queue.add(key);
        return value;
    }
    
    public void set(int key, int value) {
        if (cache.containsKey(key)) {
            updateCache(key, value);
            return;
        }
        
        if (cache.size() >= capacity) {
            int entry = queue.poll();
            cache.remove(entry);
        }
        
        cache.put(key, value);
        queue.add(key);
    }
    
    private void updateCache(int key, int value) {
        cache.remove(key);
        queue.remove(new Integer(key));
        cache.put(key, value);
        queue.add(key);
    }
}