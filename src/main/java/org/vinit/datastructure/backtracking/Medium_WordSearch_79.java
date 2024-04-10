package org.vinit.datastructure.backtracking;

public class Medium_WordSearch_79 {

    public static boolean exist(char[][] board, String word) {
        char startChar = word.charAt(0);
        if (word.isEmpty()) return true;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == startChar) {
                    Boolean wordExists = searchWord(board, i, j, 0, word);
                    if (wordExists) return true;
                }
            }
        }
        return false;
    }

    private static Boolean searchWord(char[][] board, int i, int j, int wordIndex, String word) {
        if (wordIndex == word.length()) return true;
        if (i < 0 || i >= board.length ||
                j < 0 || j >= board[0].length ||
                board[i][j] != word.charAt(wordIndex))
            return false;

        char tempStore = board[i][j];
        board[i][j] = '/';
        int[][] dirs = new int[][] {{1,0}, {0,1}, {-1,0}, {0, -1}};
        for (int[] dir : dirs) {
            Boolean res = searchWord(board, i + dir[0], j + dir[1], wordIndex + 1, word);
            if (res) return true;
        }
        board[i][j] = tempStore;
        return false;
    }

    public static void main(String[] args) {
        char[][] b = new char[][]{{'a','z'},{'t','e'}};
        System.out.println(exist(b, "ae"));
    }
}
