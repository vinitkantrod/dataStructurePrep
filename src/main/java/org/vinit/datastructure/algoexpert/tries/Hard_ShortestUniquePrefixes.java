package org.vinit.datastructure.algoexpert.tries;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Hard_ShortestUniquePrefixes {

    public static String[] shortestUniquePrefixes(String[] strings) {
        // Write your code here.
        Tries t = new Tries();
        for (String s : strings)
            t.buildTrie(s);

        System.out.println(t.root);
        String[] result = new String[strings.length];
        for (int i = 0; i < strings.length; i++) {
            result[i] = t.getMinPrefix(strings[i]);
        }
        return result;
    }
    static class TrieNode {
        int count;
        Map<Character, TrieNode> children = new HashMap<>();
        public String toString() {
            return """
                    {count: %s, children: %s}""".formatted(count, children);
        }
    }
    static class Tries {
        TrieNode root;

        public Tries() {
            root = new TrieNode();
        }
        public void buildTrie(String str) {
            TrieNode node = root;
            for (int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);
                if (!node.children.containsKey(ch)) node.children.put(ch, new TrieNode());
                node = node.children.get(ch);
                node.count++;
            }
        }
        public String getMinPrefix(String str) {
            TrieNode node = root;
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < str.length(); i++) {
                char letter = str.charAt(i);
                node = node.children.get(letter);
                sb.append(letter);
                if (node.count == 1)
                    break;
            }
            return sb.toString();
        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(shortestUniquePrefixes(new String[]{"algorithm", "algoexpert"})));
    }
}
