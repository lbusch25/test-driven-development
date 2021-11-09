package com.lawson.testdrivendevelopment.structures;

public class Trie {
    //aka a prefix tree
    public TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        // iterate over the word until last character
        // check for links at each point
        // if a link exists - use that path
        // else construct a new trie - mark end if last character
        TrieNode curr = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (curr.containsKey(c)) {
                curr = curr.getKey(c);
            } else {
                TrieNode next = new TrieNode();
                curr.setKey(c, next);
                curr = next;
            }
        }
        curr.setEnd(true);
    }

    public boolean search(String word) {
        //returns true if word in trie (IE if isEnd is true)
        //returns false otherwise
        TrieNode curr = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (curr.containsKey(c)) {
                curr = curr.getKey(c);
            } else {
                return false;
            }
        }
        return curr.isEnd();
    }

    public boolean startsWith(String prefix) {
        //returns true if the prefix exists (ie doesn't have to be end)
        //else return false
        TrieNode curr = root;
        for (int i = 0; i < prefix.length(); i++) {
            if (!curr.containsKey(prefix.charAt(i))) {
                return false;
            }
            curr = curr.getKey(prefix.charAt(i));
        }
        return true;
    }

    /*
     * Your Trie object will be instantiated and called as such:
     * Trie obj = new Trie();
     * obj.insert(word);
     * boolean param_2 = obj.search(word);
     * boolean param_3 = obj.startsWith(prefix);
     */
}
