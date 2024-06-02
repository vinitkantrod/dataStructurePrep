package org.vinit.datastructure.leetcode.leetcode75.tries;

public class Medium_ImplementTries_208 {
    class TrieNode {
        public Character ch;
        public TrieNode[] children;
        public Boolean endString;
        public TrieNode(Character c) {
            ch = c;
            endString = false;
            children = new TrieNode[26];
            for (int i = 0; i < 26; i++) {
                children[i] = null;
            }
        }
    }
    class Trie {
        TrieNode root;
        public Trie() {
            root = new TrieNode('/');
        }

        public void insert(String word) {
            TrieNode node = root;
            for (char ch : word.toCharArray()) {
                int index = ch - 'a';
                if (node.children[index] == null) {
                    TrieNode t = new TrieNode(ch);
                    node.children[index] = t;
                }
                node = node.children[index];
            }
            node.endString = true;
        }

        public boolean search(String word) {
            TrieNode node = root;
            for (char ch : word.toCharArray()) {
                int index = ch - 'a';
                if (node.children[index] == null) {
                    return false;
                }
                node = node.children[index];
            }
            return node.endString;
        }

        public boolean startsWith(String prefix) {
            TrieNode node = root;
            for (char ch : prefix.toCharArray()) {
                int index = ch - 'a';
                if (node.children[index] == null) {
                    return false;
                }
                node = node.children[index];
            }
            return true;
        }
    }
}
