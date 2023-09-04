package csi213.assignment4;

import java.util.LinkedList;

public class LinkedListTrie {
    private TrieNode root;

    public LinkedListTrie() {
        root = new TrieNode('\0', false);
    }

    public boolean insert(String value) {
        if (value == null || value.isEmpty()) {
            return false;
        }
        return root.insert(value, 0);
    }

    public boolean exists(String value) {
        if (value == null || value.isEmpty()) {
            return false;
        }
        return root.exists(value, 0);
    

    private class TrieNode {
        private char character;
        protected boolean isWord;
        private TrieNode next;
        private TrieNode child;

        public TrieNode(char character, boolean isWord) {
            this.character = character;
            this.isWord = isWord;
            this.next = null;
            this.child = null;
        }

        public boolean insert(String value, int index, int maxDepth) {
            if (index == value.length()) {
                if (isWord) {
                    return false;
                } else {
                    isWord = true;
                    return true;
                }
            }

            if (index >= maxDepth - 1) {
                if (child == null) {
                    child = new LeafNode();
                }
                return child.insert(value.substring(index), 0, maxDepth);
            }

            char c = value.charAt(index);
            if (child == null) {
                child = new TrieNode(c, false);
                return child.insert(value, index + 1, maxDepth);
            }

            TrieNode current = child;
            while (current.next != null && current.character != c) {
                current = current.next;
            }

            if (current.character == c) {
                return current.insert(value, index + 1, maxDepth);
            } else {
                current.next = new TrieNode(c, false);
                return current.next.insert(value, index + 1, maxDepth);
            }
        }

        public boolean exists(String value, int index) {
            if (index == value.length()) {
                return isWord;
            }

            char c = value.charAt(index);
            TrieNode current = child;
            while (current != null && current.character != c) {
                current = current.next;
            }

            if (current == null) {
                return false;
            }
            return current.exists(value, index + 1);
        }
    }

    private class LeafNode extends TrieNode {
        private LinkedList<String> wordParts;

        public LeafNode() {
            super('\0', false);
            wordParts = new LinkedList<>();
        }

        @Override
        public boolean insert(String value, int index, int maxDepth) {
            if (index == value.length()) {
                if (isWord) {
                    return false;
                } else {
                    isWord = true;
                    return true;
                }
            }

            if (wordParts.contains(value.substring(index))) {
                return false;
            } else {
                wordParts.add(value.substring(index));
                return true;
            }
        }

        @Override
        public boolean exists(String value, int index) {
            if (index == value.length()) {
                return isWord;
            }

            return wordParts.contains(value.substring(index));
        }
    }
}

