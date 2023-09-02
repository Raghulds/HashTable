package org.example.controller;

import java.util.ArrayList;
import java.util.Objects;

public class Map<K, V> {
    private ArrayList<DataNode<K, V>> buckets;
    int bucketsCount;
    public Map() {
        this.buckets = new ArrayList<>();
        this.bucketsCount = 100;
        for(int i=0; i<this.bucketsCount; i++) this.buckets.add(i, null);
    }

    private final int generateHash(K key) {
        return Objects.hashCode(key);
    }

    private int getBucketIndexForKey(K key) {
        int hash = generateHash(key);
        int bucketIndex = hash % bucketsCount;
        return bucketIndex;
    }

    public void add(K key, V value) {
        int bucketIndex = getBucketIndexForKey(key);
        DataNode<K, V> dataNode = buckets.get(bucketIndex);
        int hashCode = generateHash(key);
        if(dataNode == null) {
            buckets.add(bucketIndex, new DataNode<>(key, value, hashCode));
        } else {
            DataNode<K, V> currNode = dataNode;
            while(currNode != null && currNode.next != null) {
                currNode = currNode.next;
            }
            currNode.next = new DataNode<>(key, value, hashCode);
        }
    }
    public void remove(K key) {
        int bucketIndex = getBucketIndexForKey(key);
        DataNode<K, V> dataNode = buckets.get(bucketIndex);
        if(dataNode != null) {
            DataNode<K, V> currNode = dataNode;
            DataNode<K, V> prevNode = currNode;
            while(currNode != null) {
                if(currNode.key.equals(key)) {
                    if(prevNode.key.equals(currNode.key)) {
                        currNode = currNode.next;
                        buckets.add(bucketIndex, currNode);
                        return;
                    }
                    prevNode = currNode;
                    currNode = currNode.next;
                }
            }
        }
    }
    public V get(K key) {
        int bucketIndex = getBucketIndexForKey(key);
        DataNode<K, V> dataNode = buckets.get(bucketIndex);
        DataNode<K, V> currNode = dataNode;
        while(currNode != null) {
            if(currNode.key.equals(key)) {
                return currNode.value;
            }
            currNode = currNode.next;
        }
        return null;
    }
}
