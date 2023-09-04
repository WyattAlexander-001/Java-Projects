package csi213.assignment4;

import org.junit.Test;
import static org.junit.Assert.*;

public class TrieTest {
    @Test
    public void testTrie() {
        Trie trie = new Trie(3);

        assertTrue("Insertion of 'abc' should return true", trie.insert("abc"));
        assertFalse("Insertion of existing word 'abc' should return false", trie.insert("abc")); //debug
        assertTrue("Exists check for 'abc' should return true", trie.exists("abc")); //debug
        assertFalse("Exists check for 'abcd' should return false", trie.exists("abcd"));
        assertTrue("Insertion of 'abxy' should return true", trie.insert("abxy"));
        assertTrue("Insertion of 'abcd' should return true", trie.insert("abcd"));
        assertTrue("Exists check for 'abxy' should return true", trie.exists("abxy"));
        assertFalse("Insertion of empty string should return false", trie.insert(""));
        assertFalse("Exists check for 'abcdefgh' should return false", trie.exists("abcdefgh"));
    }
    
    @Test
    public void testNonExistentWord() {
        Trie trie = new Trie(3);

        // Insert some words into the Trie
        trie.insert("cat");
        trie.insert("bat");
        trie.insert("rat");

        // Test non-existent word
        assertFalse(trie.exists("XYCfgjgfdl"));
    }
    
    @Test
    public void testDisplayWord() {
        Trie trie = new Trie(3);

        assertTrue("Insertion of 'display' should return true", trie.insert("display"));
        assertTrue("Exists check for 'display' should return true", trie.exists("display"));
        assertFalse("Insertion of existing word 'display' should return false", trie.insert("display"));
    }

}
