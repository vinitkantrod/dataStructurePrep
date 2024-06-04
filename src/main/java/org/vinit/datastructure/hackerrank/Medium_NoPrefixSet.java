package org.vinit.datastructure.hackerrank;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Medium_NoPrefixSet {
    static class Node {

        char value;
        Map<Character, Node> map;
        int count;
        boolean isEnd;

        public Node (char value) {
            this.value = value;
            map = new HashMap<>();
            count = 0;
            isEnd = false;
        }
    }

    static Node root = new Node('*');

    private static boolean insert(String word) {
        Node current = root;
        for(char c : word.toCharArray()) {
            if(current.map.containsKey(c)){
                current = current.map.get(c);
                if(current.isEnd) return true;
            }
            else {
                Node newNode = new Node(c);
                current.map.put(c, newNode);
                current = newNode;
            }
            current.count++;
        }
        if(current.count > 1) return true;
        current.isEnd = true;
        return false;
    }
    public static void noPrefix(List<String> words) {
        // Write your code here
        for(String word: words) {
            if(insert(word)){
                System.out.println("BAD SET");
                System.out.println(word);
                return;
            }
        }
        System.out.println("GOOD SET");
    }
}
