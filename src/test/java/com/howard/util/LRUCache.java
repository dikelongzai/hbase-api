package com.howard.util;

import com.howard.structure.Node;

import java.util.HashMap;
import java.util.LinkedList;

public class LRUCache<K, V> {
    private int capacity;
    private volatile Node<K, V> headNode;
    private HashMap<K, Integer> keyQueueIndex = new HashMap<>();
    private LinkedList<Node<K, V>> queue = new LinkedList<>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public HashMap<K, Integer> getAllIndex() {
        return keyQueueIndex;
    }

    public LinkedList<Node<K, V>> getAllNodes() {
        return queue;
    }

    public void put(K key, V value) {
        if (keyQueueIndex.containsKey(key)) {
            getThenRemoveBasedIndex(key);
        }
        /** delete the first element of the queue before put new element */
        checkCapacityThenReset();
        changeNodeIndex(key, value);


    }

    private void getThenRemoveBasedIndex(K key) {
        int index = keyQueueIndex.get(key);
        queue.remove(index);
        keyQueueIndex.remove(key);
        resetKeyQueueIndex(index);

    }

    private void changeNodeIndex(K key, V value) {
        queue.addLast(new Node<K, V>(key, value));
        int index = queue.size() - 1;
        //add The node to the end of queue
        keyQueueIndex.put(key, index);
    }

    private void resetKeyQueueIndex(int startIndex) {
        keyQueueIndex.clear();
        for (int i = startIndex; i < queue.size(); i++) {
            keyQueueIndex.put(queue.get(i).getKey(), i);

        }
    }

    public V get(K key) {
        if (keyQueueIndex.containsKey(key)) {
            V value = queue.get(keyQueueIndex.get(key)).getValue();
            /** get the value then remove the key from hashmap finally reset the index to last of the queue*/
            getThenRemoveBasedIndex(key);
            changeNodeIndex(key, value);
            return value;
        } else {
            return null;
        }


    }

    protected final void checkCapacityThenReset() {
        if (keyQueueIndex.size() >= capacity) {
            Node<K, V> node = queue.poll();
            keyQueueIndex.remove(node.getKey());
            resetKeyQueueIndex(0);
        }

    }
//
//    protected final void removeHead() {
//        if (LRUMap.size() > capacity) {
//            LRUMap.remove(headNode.key);
//        }
//    }




}
