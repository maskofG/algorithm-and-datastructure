package com.datastructure.trees;

/**
 * In trie keys are assumed to be string
 * Value can be of any type
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
        if (index < key.length()) {
            char c = key.charAt(index);
            if (index == key.length()-1) {
                return (T) x.value;
            }
            return recursiveget(x.next[c], key, index+1);
        }
        return null;
    }

    public void put(String key, T value) {
        if (key == null || key.length() == 0 || value == null) return;
        root = recursiveput(root, key, value, 0);
    }

    private Node recursiveput(Node x, String key, T value, int index) {
        if (x == null) x = new Node();
        char c = key.charAt(index);
        if (index == key.length()-1) {
            x.value = value;
            return x;
        }
        x.next[c] = recursiveput(x.next[c],key, value, index+1 );
        return x;

    }

    static class LatLong {
        public float lat;
        public float lon;

        public LatLong(float lat, float lon){
            this.lat = lat;
            this.lon = lon;
        }
    }


    public static void main(String[] args) {
        TrieST<LatLong> trie = new TrieST<>();

        trie.put("sa@gmail.com", new LatLong(12.12f, 23.23f) );

        trie.put("mk@gmail.com", new LatLong(12.56f, 44.44f));

        LatLong loc = trie.get("mkl@gmail.com");
        if (loc != null)
            System.out.printf("Lat=%f,Long=%f", loc.lat, loc.lon);
        else System.out.println("null");
    }

}