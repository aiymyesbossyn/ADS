package com.company;

public class BST <K extends Comparable<K>, V> {
    private Node node;

    private class Node{
        private K key;
        private V value;
        private Node left, right;

        public Node(K key, V value){
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }
    }

    public void put(K key, V val) {
        if(key == null){
            System.out.println("Key is null!");
            return;
        }

        if(val == null){
            delete(key);
            return;
        }

        node = put(node, key, val);
    }

    private Node put(Node node, K key, V val){
        if (node == null){
            return new Node(key, val);
        }

        int x = key.compareTo(node.getKey());

        if (x < 0) {
            node.setLeft(put(node.getLeft(), key, val));
        } else if (x > 0) {
            node.setRight(put(node.getRight(), key, val));
        } else {
            node.setValue(val);
        }

        return node;
    }

    public V get(K key){
        if(key == null){
            System.out.println("Key is null!");
            return null;
        }

        return get(node, key);
    }

    private V get(Node node, K key){
        if (key == null){
            System.out.println("Key is null!");
            return null;
        }
        if (node == null){
            return null;
        }

        int x = key.compareTo(node.key);

        if (x < 0){
            return get(node.getLeft(), key);
        } else if (x > 0){
            return get(node.getRight(), key);
        } else
            return node.getValue();
    }

    public void delete(K key){
        if(key == null){
            System.out.println("Key is null!");
            return;
        }

        node = delete(node, key);
    }

    private Node delete(Node node, K key){
        if(node == null){
            return null;
        }

        int x = key.compareTo(node.getKey());

        if (x < 0){
            node.setLeft(delete(node.getLeft(),  key));
        } else if (x > 0) {
            node.setRight(delete(node.getRight(), key));
        } else {
            if (node.getRight() == null){
                return node.getLeft();
            }
            if (node.getLeft() == null){
                return node.getRight();
            }
        }

        return node;
    }
}
