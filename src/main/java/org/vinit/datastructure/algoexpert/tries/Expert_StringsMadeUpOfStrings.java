package org.vinit.datastructure.algoexpert.tries;

import java.util.*;

public class Expert_StringsMadeUpOfStrings {

    public static String[] stringsMadeUpOfStrings(
            String[] strings, String[] substrings
    ) {
        Trie t = new Trie();
        ArrayList<String> res = new ArrayList<>();
        for (String str : substrings) t.insert(str);
        for (String str : strings) if (checkIfWordCanBeMade(str, t)) res.add(str);
        return res.toArray(new String[res.size()]);

    }

    public static boolean checkIfWordCanBeMade(String word, Trie root) {
        if (word.length() == 0) return true;
        Trie currNode = root;
        int i;

        for (i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (!currNode.children.containsKey(ch)) {
                if (!currNode.isEndOfWord) return false;
                return checkIfWordCanBeMade(word.substring(i), root);
            }
            currNode = currNode.children.get(ch);
        }
        return i == word.length() && currNode.isEndOfWord;
    }

    static class Trie {
        HashMap<Character, Trie> children = new HashMap<>();
        boolean isEndOfWord = false;

        public void insert(String word) {
            Trie node = this;
            for (char ch : word.toCharArray()) {
                if (!node.children.containsKey(ch)) node.children.put(ch, new Trie());
                node = node.children.get(ch);
            }
            node.isEndOfWord = true;
        }
    }

    public static void main(String[] args) {
//        System.out.println(Arrays.toString(stringsMadeUpOfStrings(new String[]{"bar","are"}, new String[]{"b","a","r","ba","ar","bar"})));
        System.out.println(Arrays.toString(stringsMadeUpOfStrings(new String[]{"foobar"}, new String[]{"bar","foo"})));
    }
}
