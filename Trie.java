package com.practise;

/**
 * Implement a Trie with insert, search and startsWith method
 *
 * Trie trie = new Trie();
 * trie.insert("apple");
 * trie.search("app"); //false
 * trie.startsWith("app"); //true
 */
class TrieNode {
    char ch;
    boolean terminate;
    TrieNode [] children;

    TrieNode() {
        children = new TrieNode[26];
    }

    TrieNode(char ch) {
        this.ch = ch;
        children = new TrieNode[26];
    }

    public TrieNode getNext(char ch) {
        return children[ch - 'a'];
    }

    public TrieNode setChild(char ch) {
        this.children[ch - 'a'] = new TrieNode(ch);
        return this.children[ch - 'a'];
    }
}

public class Trie {
    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String s) {
        TrieNode currNode = root;

        for(char c : s.toCharArray()) {
            if (currNode.getNext(c) == null) {
                currNode.setChild(c);
            }
            currNode = currNode.getNext(c);
        }
        currNode.terminate = true;
    }

    public boolean search(String s) {
        TrieNode currNode = root;

        for(char c: s.toCharArray()) {
            currNode = currNode.getNext(c);
            if (currNode == null)
                return false;
        }

        return currNode.terminate == true;
    }

    public boolean startsWith(String s) {
        TrieNode currNode = root;

        for(char c: s.toCharArray()) {
            currNode = currNode.getNext(c);
            if (currNode == null)
                return false;
        }

        return true;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("appple");
        System.out.println(trie.search("app"));
        System.out.println(trie.startsWith("app"));
    }
}
