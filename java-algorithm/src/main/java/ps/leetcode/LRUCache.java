package ps.leetcode;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache {

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

class LRUCacheWithDoublyLinkedListAndHashMap {

    private Map<Integer, DoublyLinkedNode> cache = new HashMap<>();
    private DoublyLinkedNode head, tail;
    private int capacity;

    public LRUCacheWithDoublyLinkedListAndHashMap(int capacity) {
        this.capacity = capacity;

        this.head = new DoublyLinkedNode();
        this.head.pre = null;

        this.tail = new DoublyLinkedNode();
        this.tail.post = null;

        this.head.post = tail;
        this.tail.pre = head;
    }

    public int get(int key) {
        if(cache.containsKey(key)) {
            DoublyLinkedNode node = cache.get(key);
            moveToHead(node);
            return node.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if(cache.containsKey(key)) {
            cache.get(key).value = value;
            moveToHead(cache.get(key));
        } else {
            if(cache.size() == capacity) {
                cache.remove(popTail().key);
            }

            DoublyLinkedNode newNode = new DoublyLinkedNode(key, value);
            add(newNode);
            cache.put(key, newNode);
        }
    }

    class DoublyLinkedNode {
        int key;
        int value;
        DoublyLinkedNode pre, post;

        public DoublyLinkedNode() {}

        public DoublyLinkedNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private void add(DoublyLinkedNode node) {
        node.pre = head;
        node.post = head.post;

        head.post.pre = node;
        head.post = node;
    }

    private void remove(DoublyLinkedNode node) {
        DoublyLinkedNode pre = node.pre;
        DoublyLinkedNode post = node.post;

        pre.post = post;
        post.pre = pre;
    }

    private void moveToHead(DoublyLinkedNode node) {
        remove(node);
        add(node);
    }

    private DoublyLinkedNode popTail() {
        DoublyLinkedNode node = tail.pre;
        remove(node);
        return node;
    }

}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
