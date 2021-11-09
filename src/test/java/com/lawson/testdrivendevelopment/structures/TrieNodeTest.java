package com.lawson.testdrivendevelopment.structures;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TrieNodeTest {
    @Test
    public void TrieNode_When_Intitialized_Expect_ChildrenAndIsEnd() {
        TrieNode testNode = new TrieNode();
        assertNotNull(testNode.getChildren());
        assertTrue(testNode.isEnd());
    }

    @Test
    public void setKey_When_Called_Expect_CorrectIndexSet() {
        TrieNode testNode = new TrieNode();
        testNode.setKey('a', new TrieNode());
        assertNotNull(testNode.getChildren()[0]);
    }

    @Test
    public void getKey_When_Present_Expect_TreeNodeReturned() {
        TrieNode testNode = new TrieNode();
        testNode.setKey('a', new TrieNode());
        assertNotNull(testNode.getKey('a'));
    }

    @Test
    public void getKey_When_NotPresent_Expect_Null() {
        TrieNode testNode = new TrieNode();
        testNode.setKey('a', new TrieNode());
        assertNull(testNode.getKey('b'));
    }

    @Test
    public void containsKey_When_Empty_Expect_False() {
        TrieNode testNode = new TrieNode();
        testNode.setKey('a', new TrieNode());
        assertFalse(testNode.containsKey('b'));
    }

    @Test
    public void containsKey_When_Present_Expect_True() {
        TrieNode testNode = new TrieNode();
        testNode.setKey('a', new TrieNode());
        assertTrue(testNode.containsKey('a'));
    }
}
