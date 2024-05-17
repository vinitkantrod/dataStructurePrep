package org.vinit.datastructure.algoexpert.tries;

import java.util.HashMap;
import java.util.Map;

public class SuffixTreeConstruction {

    // Do not edit the class below except for the
    // populateSuffixTrieFrom and contains methods.
    // Feel free to add new properties and methods
    // to the class.
    static class TrieNode {
        Map<Character, TrieNode> children = new HashMap<Character, TrieNode>();
    }

    static class SuffixTrie {
        TrieNode root = new TrieNode();
        char endSymbol = '*';

        public SuffixTrie(String str) {
            populateSuffixTrieFrom(str);
        }

        public void populateSuffixTrieFrom(String str) {
            // Write your code here.
            for (int i = 0; i < str.length(); i++) {
                insertNodeIntoRootTree(i, str);
            }
        }
            // TC: O(n^2) | SC: O(n^2)
        private void insertNodeIntoRootTree(int i, String str) {
            TrieNode node = root;
            for (int j = i; j < str.length(); j++) {
                char letter = str.charAt(j);
                if (!node.children.containsKey(letter)) {
                    node.children.put(letter, new TrieNode());
                }
                node = node.children.get(letter);
            }
            node.children.put(endSymbol, null);
        }

        // TC: O(m) - m is length of the string | SC: O(1)
        public boolean contains(String str) {
            // Write your code here.
            TrieNode node = root;
            for (int i = 0; i < str.length(); i++) {
                char letter = str.charAt(i);
                if (!node.children.containsKey(letter)) return false;
                node = node.children.get(letter);
            }
            return node.children.containsKey(endSymbol);
        }
    }
}
