package csi213.assignment4;

import java.util.LinkedList;

public class Trie {
    private TrieNode root;
    private int depth;

    public Trie(int depth) {
        this.root = new TrieNode();
        this.depth = depth;
    }

    public boolean insert(String value) {
        if (value == null || value.isEmpty()) {
            return false;
        }
        value = value.toLowerCase();
        if (root == null) {
            return false;
        }
        return root.insert(value, 0, depth);
    }

    public boolean exists(String value) {
        if (value == null || value.isEmpty()) {
            return false;
        }
        value = value.toLowerCase();
        return root.exists(value, 0, depth);
    }

    private class TrieNode {
        protected TrieNode[] children;
        protected boolean isWord;

        public TrieNode() {
            children = new TrieNode[26];
            isWord = false;
        }

        public boolean insert(String value, int index, int maxDepth) {
            if (index >= maxDepth) {
                return false;
            }

            if (index == value.length()) {
                if (isWord) {
                    return false;
                } else {
                    isWord = true;
                    return true;
                }
            }

            int charIndex = value.charAt(index) - 'a';
            if (children[charIndex] == null) {
                if (index + 1 == maxDepth) {
                    children[charIndex] = new LeafNode();
                } else {
                    children[charIndex] = new TrieNode();
                }
            }

            return children[charIndex].insert(value, index + 1, maxDepth);
        }

        public boolean exists(String value, int index, int maxDepth) {
            if (index == value.length()) {
                return isWord;
            }

            if (index >= maxDepth) {
                return false;
            }

            int charIndex = value.charAt(index) - 'a';
            TrieNode child = children[charIndex];
            if (child == null) {
                return false;
            }
            return child.exists(value, index + 1, maxDepth);
        }
    }

    private class LeafNode extends TrieNode {
        private LinkedList<String> wordParts;

        public LeafNode() {
            super();
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
        public boolean exists(String value, int index, int maxDepth) {
            if (index == value.length()) {
                return isWord;
            }

            return wordParts.contains(value.substring(index));
        }
    }
}
