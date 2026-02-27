package com.howard.structure;

public class TwoWayNode<K, V> {
    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    final K key;
    volatile V value;

    public void setValue(V value) {
        this.value = value;
    }

    public TwoWayNode<K, V> getPrev() {
        return prev;
    }

    public void setPrev(TwoWayNode<K, V> prev) {
        this.prev = prev;
    }

    public TwoWayNode<K, V> getNext() {
        return next;
    }

    public void setNext(TwoWayNode<K, V> next) {
        this.next = next;
    }

    volatile TwoWayNode<K, V> prev;
    volatile TwoWayNode<K, V> next;

    public TwoWayNode(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public TwoWayNode(K key, V value, TwoWayNode<K, V> prev) {
        this.key = key;
        this.value = value;
        this.prev = prev;
    }

    /**
     * predecessor Node
     *
     * @return
     */
    final TwoWayNode predecessor() {
        TwoWayNode node = prev;
        if (node == null)
            throw new NullPointerException();
        else
            return node;
    }
}
