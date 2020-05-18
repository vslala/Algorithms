package com.bma.algorithms.elementary_symbol_tables;

import com.bma.algorithms.sort.elementary.Util;

public class BinarySearchTree<Key extends Comparable<Key>, Value> {

    private class Node {
        Key key;
        Value val;
        Node left;
        Node right;
        int count;

        public Node(Key key, Value val) {
            this.key = key;
            this.val = val;
        }
    }

    private Node root;

    public void put(Key key, Value val) {
        root = put(root, key, val);
    }

    private Node put(Node x, Key key, Value val) {
        if (x == null) return new Node(key, val);

        int cmp = key.compareTo(x.key);
        if (cmp < 0)
            x.left = put(x.left, key, val);
        else if (cmp > 0)
            x.right = put(x.right, key, val);
        else if (cmp == 0)
            x.val = val;
        x.count = 1 + size(x.left) + size(x.right);
        return x;
    }

    public Value get(Key key) {
        Node x = root;
        while (x != null) {
            int cmp = key.compareTo(x.key);
            if (cmp > 0) x = x.right;
            else if (cmp < 0) x = x.left;
            else if (cmp == 0) return x.val;
        }
        return null;
    }

    public void delete(Key key) {}

    /**
     * The key which is just smaller to the passed value
     * @param key
     * @return
     */
    public Key floor(Key key) {
        Node x = floor(root, key);
        if (x == null ) return null;
        return x.key;
    }

    private Node floor(Node x, Key key) {
        if (x == null) return null;

        int cmp = key.compareTo(x.key);
        if (cmp == 0) return x;
        if (cmp < 0) return floor(x.left, key);

        Node t = floor(x.right, key);
        if (t != null) return t;

        return x;
    }

    public int size() {
        return size(root) + 1;
    }

    private int size(Node x) {
        if (x == null) return 0;
        return x.count;
    }

    public Iterable<Key> iterator() {
        return null;
    }

    public static void main(String[] args) {
        BinarySearchTree<String, String> bst = new BinarySearchTree<>();
        bst.put("0", "D");
        bst.put("1", "E");
        bst.put("2", "F");
        bst.put("3", "A");
        bst.put("3", "A");

        Util.println(bst.get("3"));
        Util.println("Size: " + bst.size());
    }
}
