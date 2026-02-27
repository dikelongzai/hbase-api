package com.howard.structure;

public class Node<K, V> {

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    public Node<K, V> getNext() {
        return next;
    }

    final K key;
    volatile V value;
    volatile Node<K, V> next;

    public Node(Node<K, V> next, K key, V value) {
        this.next = next;
        this.key = key;
        this.value = value;
    }

    public Node(K key, V value) {
        this.key = key;
        this.value = value;
    }
}
