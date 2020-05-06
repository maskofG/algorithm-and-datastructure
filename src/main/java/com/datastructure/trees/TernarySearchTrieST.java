package com.datastructure.trees;

/**
 * Space wise this 3-way trie performs better than r-way trie.
 * @param <T>
 */

public class TernarySearchTrieST<T> {
    private Node root;

    static class Node {
        public char nodechar;
        public Object value;
        public Node[] next;

        public Node(char c){
            nodechar = c;
            next = new Node[3];
        }
    }

    public void put(String key, T value){
        if (key == null || key.length() == 0 || value == null) return;
        root = recursiveput(root, key, value, 0);
    }

    private Node recursiveput(Node x, String key, T value, int index) {
        if (x == null ) x = new Node(key.charAt(index));
        if (index == key.length()-1) { x.value = value; return x;}
        char c = key.charAt(index);
        if (c < x.nodechar) {
            x.next[0] = recursiveput(x.next[0], key, value, index);
        } else if (c == x.nodechar) {
            x.next[1] = recursiveput(x.next[1], key, value, index+1);
        } else {
            x.next[2] = recursiveput(x.next[2], key, value, index);
        }
        return x;
    }

    public T get(String key) {
        if (key == null || key.length() == 0) return null;
        return recursiveget(root, key, 0);
    }

    private T recursiveget(Node x, String key, int index) {
        if (x == null ) return null;
        char c = key.charAt(index);
         if (c < x.nodechar) {
            return recursiveget(x.next[0], key, index);
        } else if (c == x.nodechar) {
             if (index == key.length()-1) {
                 return (T) x.value;
             } else {
                 return recursiveget(x.next[1], key, index+1);
             }
        } else {
            return recursiveget(x.next[2], key, index);
        }
    }

    public boolean contains(String key) {
        return get(key) != null;
    }

    public void delete(String key){
        if (key == null || key.length() == 0) return;
        root = recursivedelete(root, key, 0);
    }

    private Node recursivedelete(Node x, String key, int index){
        if (x == null) return null;
        char c = key.charAt(index);
        if (c < x.nodechar){
            recursivedelete(x.next[0], key, index);
        } else if ( c == x.nodechar){
            if (index == key.length()-1) {
                x.value = null;
            } else {
               x.next[1] = recursivedelete(x.next[1], key, index+1);
            }
        } else {
            recursivedelete(x.next[2], key, index);
        }

        if (x.value != null) return x;
        for(int i=0;i<3;i++){
            if (x.next[i] != null){
                return x;
            }
        }
        return null;
    }
}