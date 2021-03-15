package com.practise;

public class MyHashMap {
Node [] node = new Node[5];

    private class Node {
        int key, val;
        Node next;

        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    /** Initialize your data structure here. */
    public MyHashMap() {

    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        int index = getIndex(key);
        if(node[index] == null) {
            node[index] = new Node(key, value);
            return;
        }
        Node curr = node[index];
        Node prev = curr;
        while(curr != null && curr.key != key) {
            prev = curr;
            curr = curr.next;
        }
        if (curr != null && curr.key == key)
            curr.val = value;
        else
            prev.next = new Node(key,value);
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int index = getIndex(key);
        if(node[index] == null)
            return -1;
        return findInList(node[index], key);
    }

    private int findInList(Node head, int key) {
        if(head == null)
            return -1;
        if (head.key == key)
            return head.val;
        return findInList(head.next, key);
    }

    private int getIndex(int key) {
        return key % node.length;
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        System.out.println(key);
        int index = getIndex(key);

        if(node[index] == null)
            return;

        if(node[index].key == key) {
            node[index] = null;
            return;
        }
        System.out.println("Removing");
        Node prev, curr;
        curr = node[index];
        prev = null;

        while(curr!= null && curr.key != key) {
            prev = curr;
            curr = curr.next;
        }
        prev.next = curr.next;
        curr = null;
    }


    public static void main(String [] s) {
        MyHashMap hashMap = new MyHashMap();
        hashMap.put(1, 1);
        hashMap.put(2, 2);
        System.out.println(hashMap.get(1));
        //hashMap.get(1);            // returns 1
        //hashMap.get(3);            // returns -1 (not found)
        hashMap.put(2, 3);          // update the existing value
        //hashMap.get(2);            // returns 1
        hashMap.remove(2);          // remove the mapping for 2
        System.out.println(hashMap.get(2));            // returns -1 (not found)// returns 1
    }
}
