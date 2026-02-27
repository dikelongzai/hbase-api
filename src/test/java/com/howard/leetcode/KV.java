package com.howard.leetcode;

import java.io.Serializable;

public class KV<K, V> implements Serializable {
    public KV(K key, V value) {
        this.key = key;
        this.value = value;
    }

    private K key;

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public KV() {
    }

    public void setValue(V value) {
        this.value = value;
    }

    private V value;
}
