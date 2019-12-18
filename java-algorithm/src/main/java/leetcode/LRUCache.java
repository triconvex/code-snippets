package leetcode;

import java.util.LinkedHashMap;
import java.util.Map;

class LRUCache {

    private Map<Integer, Integer> cache;

    public LRUCache(int capacity) {
        this.cache = new LinkedHashMap<Integer, Integer>(capacity, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return size() > capacity;
            }
        };
    }

    public int get(int key) {
        return cache.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        cache.put(key, value);
    }

}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

class LRUCacheWithBasicLinkedHashMap {

    private Map<Integer, Integer> cache = new LinkedHashMap<>();
    private int capacity;

    public LRUCacheWithBasicLinkedHashMap(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if(cache.containsKey(key)) {
            int value = cache.get(key);
            cache.remove(key);
            cache.put(key, value);
            return value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if(cache.containsKey(key)) {
            cache.remove(key);
        } else if(cache.size() == capacity) {
            cache.remove(cache.keySet().iterator().next());
        }
        cache.put(key, value);
    }

}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
