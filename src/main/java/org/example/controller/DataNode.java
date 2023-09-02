package org.example.controller;

public class DataNode <K, V> {
    public K key;
    public V value;
    final int hash;
    DataNode<K, V> next;
    public DataNode(K key, V value, int hash) {
        this.key = key;
        this.value = value;
        this.hash = hash;
    }

    public void setNext(DataNode<K, V> next) {
        this.next = next;
    }

    public DataNode<K, V> getNext() {
        return next;
    }
}
