package cn.shui.offer;

public class Offer_12 {
    public static void main(String[] args) {

    }

    private boolean exist(char[][] board, String word) {
        if (board == null || board.length < 1 || board[0].length < 1 || word == null || word.length() < 1) {
            return false;
        }
        char[] words = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, words, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, char[] word, int i, int j, int k) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word[k]) {
            return false;
        }
        if (k == word.length - 1) {
            return true;
        }
        board[i][j] = '\0';
        boolean ans = dfs(board, word, i - 1, j, k + 1) || dfs(board, word, i + 1, j, k + 1)
                || dfs(board, word, i, j - 1, k + 1) || dfs(board, word, i, j + 1, k + 1);
        board[i][j] = word[k];
        return ans;
    }
}
