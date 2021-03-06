package com.datastructure.trees;

/**
 * In Standard R-Way trie keys are assumed to be string
 * Value can be of any type
 *
 * To avoid complexity - I am not building this datastructure as threadsafe.
 *
 *
 * @param <T>
 */

public class TrieST<T> {

    private Node root;

    static class Node {
        public Object value;
        public Node[] next;

        public Node() {
            next = new Node[256];
        }
    }

    public T get(String key) {
        if (key == null || key.length() == 0 ) return null;
        return recursiveget(root, key, 0);
    }

    private T recursiveget(Node x, String key, int index) {
        if (x == null) return null;
        if (index == key.length()) { return (T) x.value; }
        char c = key.charAt(index);
        return recursiveget(x.next[c], key, index+1);
    }

    public void put(String key, T value) {
        if (key == null || key.length() == 0 || value == null) return;
        root = recursiveput(root, key, value, 0);
    }

    private Node recursiveput(Node x, String key, T value, int index) {
        if (x == null) x = new Node();
        if (index == key.length()) { x.value = value; return x;}
        char c = key.charAt(index);
        x.next[c] = recursiveput(x.next[c],key, value, index+1 );
        return x;

    }

    public boolean contains(String key){
        return this.get(key) != null;
    }

    public void delete(String key) {
        if (key == null || key.length() == 0) return;
        recursivegetanddelete(root, key, 0);
    }

    private Node recursivegetanddelete(Node x, String key, int index) {
        if (x == null) return null;
        if (index == key.length()) {
            x.value = null;
        }
        if (index < key.length()) {
            char c = key.charAt(index);
            x.next[c] = recursivegetanddelete(x.next[c], key, index+1);
        }
        if (x.value != null) return x;

        for(int i=0; i<256;i++) {
            if (x.next[i] != null) {
                return x;
            }
        }
        return null;

    }

}