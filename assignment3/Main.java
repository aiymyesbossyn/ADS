package com.company;

import java.util.Hashtable;

public class Main {

    public static void main(String[] args) {
        BST bst = new BST();
        //Insert data
        System.out.println("=========BST=========");
        bst.put(1, 1);
        bst.put(2,"Value");

        //get by key
        System.out.println("Get value for 2 key " + bst.get(2));

        //delete by key
        bst.delete(1);
        System.out.println("Delete by 2 key: " + bst.get(1));

        //insert new data
        bst.put(1,"new val");
        System.out.println("Insert new data (Key = 1, Value = 'new val': " + bst.get(1));

        System.out.println("\n=========Hash table=========");
        MyHashTable hashTable = new MyHashTable();
        hashTable.put(1, "Value");
        hashTable.put(2, "New value");
        System.out.println("Get by 1 key " + hashTable.get(1));
        System.out.println("Gey by 2 key " + hashTable.get(2));

        System.out.println("Check contains for 'New value' value " + hashTable.contains("New value"));
        System.out.println("Check contains for 'Value' value " +hashTable.contains("Value"));
        System.out.println("Check contains for 'Vaue' value " +hashTable.contains("Vaue"));
    }
}
