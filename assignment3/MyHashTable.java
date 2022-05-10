package com.company;

public class MyHashTable<K, V> {

    private class HashCode<K, V> {
        private K key;
        private V value;
        HashCode next;

        public HashCode(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public HashCode getNext() {
            return next;
        }

        public void setNext(HashCode next) {
            this.next = next;
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

        @Override
        public String toString() {
            return "HashCode{" +
                    "key=" + key +
                    ", value=" + value +
                    '}';
        }
    }

    private HashCode<K, V>[] chainArray;

    private int M = 11;
    private int size;

    public MyHashTable(){
        chainArray = new HashCode[64];
    }

    public MyHashTable(int M){
        this.M = M;
    }

    private int hash(K key){
        return (Math.abs(key.hashCode()));
    }

    public void put(K key, V value){

        int hash = hash(key);

        HashCode<K, V> hashCode = chainArray[hash];

        while (hashCode != null){
            if(hashCode.getKey().equals(key)){
                break;
            }
            hashCode = hashCode.next;
        }

        if(hashCode != null){
            hashCode.setValue(value);
        } else {
            if(size>=0.75*chainArray.length){
                hash = hash(key);
            }

            HashCode newHashCode = new HashCode(key, value);
            newHashCode.next = chainArray[hash];
            chainArray[hash] = newHashCode;
            size++;
        }
    }

    public V get(K key){

        int hash = hash(key);

        HashCode hashCode = chainArray[hash];
        while (hashCode != null) {
            if (hashCode.getKey().equals(key)){
                return (V) hashCode.getValue();
            }

            hashCode = hashCode.next;
        }

        return null;
    }

    public void remove(K key) {

        int hash = hash(key);

        if (chainArray[hash] == null) {
            return;
        }

        if (chainArray[hash].getKey().equals(key)) {
            chainArray[hash] = chainArray[hash].next;
            size--;
            return;
        }

        HashCode previous = chainArray[hash];
        HashCode current = previous.next;
        while (current != null && ! current.getKey().equals(key)) {
            current = current.next;
            previous = current;
        }

        if (current != null) {
            previous.next = current.next;
            size--;
        }
    }

    public boolean contains(V value){
        K key = getKey(value);

        if(key == null){
            return false;
        }

        int hash = hash(getKey(value));

        HashCode hashCode = chainArray[hash];
        while (hashCode != null) {
            if (hashCode.getValue().equals(value)){
                return true;
            }
            hashCode = hashCode.next;
        }

        return false;
    }

    public K getKey(V value){

        for(int i=1; i<=size; i++) {
            HashCode hashCode = chainArray[i];
            while (hashCode != null) {
                if (hashCode.getValue().equals(value)) {
                    return (K) hashCode.getKey();
                }
                hashCode = hashCode.next;
            }
        }

        return null;
    }


}
