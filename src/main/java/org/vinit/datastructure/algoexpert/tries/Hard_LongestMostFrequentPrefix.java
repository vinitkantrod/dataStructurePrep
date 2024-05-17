package org.vinit.datastructure.algoexpert.tries;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Hard_LongestMostFrequentPrefix {

    public static String longestMostFrequentPrefix(String[] strings) {
        // Write your code here.
        Tries t = new Tries();
        for (String s : strings) {
            t.buildTries(s);
            System.out.println(t.root);
        }

        return t.maxPrefixFullString.substring(0, t.maxPrefixLength);
    }
    static class TrieNode {
        int count;
        Map<Character, TrieNode> children;
        public TrieNode() {
            children = new HashMap<>();
            count = 0;
        }
        public String toString() {
            return """
                    {count: %s, children: %s}""".formatted(count, children);
        }
    }
    static class Tries {
        TrieNode root;
        char endSymbol = '*';
        int maxPrefixCount = 0;
        int maxPrefixLength = 0;
        String maxPrefixFullString = "";
        public Tries() {
            root = new TrieNode();
        }
        public void buildTries(String str) {
            TrieNode node = root;
            for (int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);
                if (!node.children.containsKey(ch)) node.children.put(ch, new TrieNode());
                node = node.children.get(ch);
                node.count++;
                if (node.count > maxPrefixCount) {
                    maxPrefixCount = node.count;
                    maxPrefixLength = i + 1;
                    maxPrefixFullString = str;
                } else if (node.count == maxPrefixCount && i + 1 > maxPrefixLength) {
                    maxPrefixLength = i + 1;
                    maxPrefixFullString = str;
                }
            }
        }
    }

    public static void main(String[] args) {
//        System.out.println(longestMostFrequentPrefix(new String[]{"hello", "hell"}));
        System.out.println(longestMostFrequentPrefix(new String[]{"algoexpert", "algorithm", "foo", "food"}));
    }
}
