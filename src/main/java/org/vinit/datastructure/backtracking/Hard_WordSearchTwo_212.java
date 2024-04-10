package org.vinit.datastructure.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Hard_WordSearchTwo_212 {

    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = buildTrie(words);
        List<String> res = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, root, i, j, res);
            }
        }
        return res;
    }

    private void dfs(char[][] board, TrieNode root, int i, int j, List<String> res) {
        char c = board[i][j];
        if (c == '#' || root.next[c - 'a'] == null) return;
        root = root.next[c - 'a'];
        if (root.word != null) {
            res.add(root.word);
            root.word = null;
        }
        board[i][j] = '#';
        if (i > 0) dfs(board, root, i - 1, j, res);
        if (i < board.length - 1) dfs(board, root, i + 1, j, res);
        if (j > 0) dfs(board, root, i, j - 1, res);
        if (j < board[0].length - 1) dfs(board, root, i, j + 1, res);
        board[i][j] = c;
    }

    public TrieNode buildTrie(String[] word) {
        TrieNode root = new TrieNode();
        for (String w : word) {
            TrieNode p = root;
            for (char c : w.toCharArray()) {
                int i = c - 'a';
                if (p.next[i] == null) p.next[i] = new TrieNode();
                p = p.next[i];
            }
            p.word = w;
        }
        return root;
    }

    class TrieNode {
        TrieNode[] next = new TrieNode[26];
        String word;
    }

}
