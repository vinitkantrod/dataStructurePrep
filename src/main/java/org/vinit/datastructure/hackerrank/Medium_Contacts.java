package org.vinit.datastructure.hackerrank;

import java.util.ArrayList;
import java.util.List;

public class Medium_Contacts {

    static class TrieNode {
        int count;
        char c;
        TrieNode[] children;
        public TrieNode() {}
        public TrieNode(char ch) {
            this.c = ch;
            this.count = 0;
            this.children = new TrieNode[26];
            for (int i = 0; i < 26; i++) {
                this.children[i] = null;
            }
        }
    }
    static class Tries {
        TrieNode root;
        public Tries() {
            root = new TrieNode('/');
        }
        public void add(String word) {
            TrieNode curr = root;
            for (char ch : word.toCharArray()) {
                int charIdx = ch - 'a';
                if (curr.children[charIdx] == null) {
                    TrieNode t = new TrieNode(ch);
                    t.count++;
                    curr.children[charIdx] = t;
                } else {
                    TrieNode t = curr.children[charIdx];
                    t.count++;
                }
                curr = curr.children[charIdx];
            }
        }
        public int find(String word) {
            TrieNode curr = root;
            int count = 0;
            for (char ch : word.toCharArray()) {
                int charIdx = ch - 'a';
                if (curr.children[charIdx] == null) return 0;
                TrieNode t = curr.children[charIdx];
                count = t.count;
                curr = t;
            }
            return count;
        }
    }
    public static List<Integer> contacts(List<List<String>> queries) {
        // Write your code here
        Tries t = new Tries();
        List<Integer> response = new ArrayList<>();
        for (List<String> ops : queries) {
            if (ops.get(0).equals("add")) {
                t.add(ops.get(1));
            } else {
                int count = t.find(ops.get(1));
                response.add(count);
            }
        }
        return response;
    }
}
