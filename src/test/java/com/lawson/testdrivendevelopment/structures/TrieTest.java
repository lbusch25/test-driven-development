package com.lawson.testdrivendevelopment.structures;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class TrieTest {

    @Test
    public void Trie_When_Initialized_Expect_rootNotNull() {
        Trie t = new Trie();
        assertNotNull(t);
    }

    @Test
    public void insert_When_baseInsert_Expect_rootContainsKey() {
        Trie t = new Trie();
        t.insert("a");
        assertTrue(t.root.containsKey('a'));
    }

    @Test
    public void insert_When_baseInsert_Expect_isEnd() {
        Trie t = new Trie();
        t.insert("a");
        TrieNode test = t.root.getKey('a');
        assertTrue(test.isEnd());
        assertFalse(t.root.isEnd());
    }

    @Test
    public void insert_When_baseInsert_Expect_nullIfWrongKey() {
        Trie t = new Trie();
        t.insert("a");
        TrieNode test = t.root.getKey('b');
        assertNull(test);
    }

    @Test
    public void insert_When_called_Expect_searchIsTrue() {
        Trie t = new Trie();
        t.insert("apple");
        assertTrue(t.search("apple"));
    }

    @Test
    public void search_When_Empty_Expect_False() {
        Trie t = new Trie();
        assertFalse(t.search("apple"));
    }

    @Test
    public void search_When_Prefix_Expect_False() {
        Trie t = new Trie();
        t.insert("apple");
        assertFalse(t.search("app"));
    }

    @Test
    public void search_When_PrefixAndFullWord_Expect_BothTrue() {
        Trie t = new Trie();
        t.insert("apple");
        t.insert("app");
        assertTrue(t.search("app"));
        assertTrue(t.search("apple"));
    }

    @Test
    public void search_When_PrefixExists_Expect_True() {
        Trie t = new Trie();
        t.insert("apple");
        assertTrue(t.startsWith("app"));
    }

    @Test
    public void search_When_PrefixDoeNotExists_Expect_False() {
        Trie t = new Trie();
        t.insert("apple");
        assertFalse(t.startsWith("apl"));
    }
}
