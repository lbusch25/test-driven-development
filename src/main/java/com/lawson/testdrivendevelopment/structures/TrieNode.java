package com.lawson.testdrivendevelopment.structures;

public class TrieNode {
    /* TrieNode's have the following characteristics
     * 1. Maximum of R links to children
     *      (in this case 26 since alphabet has 26 characters)
     * 2. Boolean field indicating whether the node corresponds to the end
     *      of the key or is a prefix
     *
     * => is a recursive structure => holds an array of TrieNodes
     * => needs an end marker field
     * => needs getters and setters for fields
     */

    private TrieNode[] children;

    private boolean isEnd = false; //starting with false since setting true is more operations

    private int size = 26;

    protected TrieNode() {
        this.children = new TrieNode[26];
    }

    protected boolean containsKey(char c) {
        return this.children[c - 'a'] != null;
    }

    protected TrieNode getKey(char c) {
        return this.children[c - 'a'];
    }

    protected void setKey(char c, TrieNode t) {
        this.children[c - 'a'] = t;
    }

    protected boolean isEnd() {
        return isEnd;
    }

    protected void setEnd(boolean end) {
        isEnd = end;
    }

    protected TrieNode[] getChildren() {
        return this.children;
    }
}
