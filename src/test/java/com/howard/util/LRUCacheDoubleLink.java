package com.howard.util;

import com.howard.structure.TwoWayNode;

import java.util.concurrent.ConcurrentHashMap;

public class LRUCacheDoubleLink<K, V> {
    transient volatile TwoWayNode<K, V> head;
    transient volatile TwoWayNode<K, V> tail;
    private ConcurrentHashMap<K, TwoWayNode<K, V>> hashMap = new ConcurrentHashMap();
    private volatile int capacity = 0;

    public LRUCacheDoubleLink(int capacity) {
        this.capacity = capacity;
    }

    public final void put(K key, V value) {
        TwoWayNode node;
        if (hashMap.containsKey(key)) {
            node = hashMap.get(key);
            node.setValue(value);
            unlinkNodeThenmoveNodeTail(node);
        } else {
            //if the node not exits in the map,check capacity first then eliminate the head node if needed
            checkCapacityThenReset();
            node = new TwoWayNode(key, value);
            if (hashMap.isEmpty()) {
                head = node;
                tail = node;
            } else {
                moveNodeToTail(node);
            }

        }

        hashMap.put(key, node);

    }

    public final V get(K key) {
        TwoWayNode<K, V> node = hashMap.get(key);
        if (node != null) {
            moveNodeToTail(node);
            return node.getValue();
        } else {
            return null;
        }
    }

    protected final void checkCapacityThenReset() {
        if (hashMap.size() >= capacity) {
            eliminate();
        }

    }

    protected void eliminate() {
        TwoWayNode<K, V> node = head;
        hashMap.remove(node.getKey());
        //when the second node upgrade to the head,the previous node should set to null
        node.getNext().setPrev(null);
        head = node.getNext();

    }

    private void unlinkNodeThenmoveNodeTail(TwoWayNode<K, V> node) {
        //unlink the node
        node.getPrev().setNext(node.getNext());
        node.getNext().setPrev(node.getPrev());
        moveNodeToTail(node);
    }

    private void moveNodeToTail(TwoWayNode<K, V> node) {
        //if the task is move the current head to tail
        if (node.getKey() == head.getKey()) {
            node.setPrev(null);
            if (node.getNext() != null) {
                head = node.getNext();
            } else {
                head = node;
            }

            //The head node has no front node
        } else {
            node.setPrev(tail);
        }

        //the next node of the going to tail should be set to null
        node.setNext(null);
        // the next node of current tail set to node
        tail.setNext(node);
        tail = node;
    }

}
