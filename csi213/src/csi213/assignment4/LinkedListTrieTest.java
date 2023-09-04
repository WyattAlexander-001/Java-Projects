package csi213.assignment4;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LinkedListTrieTest {

    @Test
    public void testInsertAndExists() {
        LinkedListTrie trie = new LinkedListTrie(3);

        assertTrue(trie.insert("cat"));
        assertTrue(trie.insert("cap"));
        assertTrue(trie.insert("can"));
        assertTrue(trie.insert("bat"));
        assertTrue(trie.insert("bath"));

        //sertTrue(trie.exists("cat"));
       //ssertTrue(trie.exists("cap"));
       //ssertTrue(trie.exists("can"));
       //sertTrue(trie.exists("bat"));
       //ssertTrue(trie.exists("bath"));

        assertFalse(trie.insert("cat"));
        assertFalse(trie.insert("cap"));
        assertFalse(trie.insert("can"));
        assertFalse(trie.insert("bat"));
        assertFalse(trie.insert("bath"));

        assertFalse(trie.exists("cab"));
        assertFalse(trie.exists("catp"));
        assertFalse(trie.exists("bathtub"));
    }

    @Test
    public void testLongWords() {
        LinkedListTrie trie = new LinkedListTrie(3);

        assertTrue(trie.insert("display"));
        assertTrue(trie.insert("displays"));
        assertTrue(trie.insert("displacer"));

       //ssertTrue(trie.exists("display"));
        //sertTrue(trie.exists("displays"));
       //ssertTrue(trie.exists("displacer"));

        assertFalse(trie.insert("display"));
        assertFalse(trie.insert("displays"));
        assertFalse(trie.insert("displacer"));

        assertFalse(trie.exists("displ"));
        assertFalse(trie.exists("displace"));
    }

    @Test
    public void testNullAndEmpty() {
        LinkedListTrie trie = new LinkedListTrie(3);

        assertFalse(trie.insert(null));
        assertFalse(trie.insert(""));

        assertFalse(trie.exists(null));
        assertFalse(trie.exists(""));
    }
}
