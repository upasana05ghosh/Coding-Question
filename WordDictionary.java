package com.practise;

public class WordDictionary {

    public static void main(String[] args) {
         WordDictionary obj = new WordDictionary();
         obj.addWord("at");
         obj.addWord("and");
         obj.addWord("an");
         obj.addWord("add");
         boolean param_2 = obj.search("a");
         System.out.println(param_2);


    }
    public TrieNode root;
    class TrieNode {
        TrieNode [] children;
        boolean isEnd;

        public TrieNode() {
            children = new TrieNode[26];
        }

        public TrieNode getChild(char ch) {
            return children[ch  - 'a'];
        }
    }
    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new TrieNode();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode curr = root;
        for(char c : word.toCharArray()) {
            if(curr.getChild(c) == null) {
                curr.children[c- 'a'] = new TrieNode();
            }
            curr = curr.getChild(c);
        }
        curr.isEnd = true;
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return match(word, root);
    }

    private boolean match(String word, TrieNode curr) {
        if(word.isEmpty())
            return curr.isEnd;

        char ch = word.charAt(0);

        if(ch == '.') {
            for(int i = 0; i< 26; i++) {
                if(curr.children[i] != null)
                    if(match(word.substring(1), curr.children[i]))
                        return true;
            }
        } else {
            if(curr.getChild(ch) != null) {
                return match(word.substring(1), curr.getChild(ch));
            }
        }
        return false;
    }

}
