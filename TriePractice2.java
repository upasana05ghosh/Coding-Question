package com.practise;

public class TriePractice2 {

    class TrieNode {
        TrieNode [] children;
        boolean isEnd;

        public TrieNode() {
            children = new TrieNode[26];
        }

        public TrieNode getChild(char c) {
            return children[c - 'a'];
        }
    }

    TrieNode root ;

    public TriePractice2() {
        root = new TrieNode();
    }

    public void insert(String s) {
        TrieNode currNode = root;
        for(char c: s.toCharArray()) {
            if (currNode.getChild(c) == null)
                currNode.children[c - 'a'] = new TrieNode();
            currNode = currNode.getChild(c);
        }
        currNode.isEnd = true;
    }

    public boolean isStringPresent(String s) {
        TrieNode currNode = root;
        for(char c: s.toCharArray()) {
            if (currNode.getChild(c) == null)
                return false;
            currNode = currNode.getChild(c);
        }
        return currNode.isEnd == true;
    }

    public boolean isPreString(String s) {
        TrieNode currNode = root;
        for(char c: s.toCharArray()) {
            if (currNode.getChild(c) == null)
                return false;
            currNode = currNode.getChild(c);
        }
        return true;
    }

    public static void main(String s[]) {
        TriePractice2 node = new TriePractice2();

        node.insert("apple");
        System.out.println(node.isPreString("apl"));
        System.out.println(node.isPreString("appl"));

        System.out.println(node.isStringPresent("app"));
        System.out.println(node.isStringPresent("apple"));
    }

}
