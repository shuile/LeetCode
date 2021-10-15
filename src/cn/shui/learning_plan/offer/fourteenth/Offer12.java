package cn.shui.learning_plan.offer.fourteenth;

/**
 * @author shui.
 * @date 2021/10/15.
 * @time 09:42.
 */
public class Offer12 {
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length < 1 || board[0].length < 1) {
            return false;
        }
        char[] wordChs = word.toCharArray();
        int row = board.length, column = board[0].length;
        boolean[][] flag = new boolean[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (board[i][j] == wordChs[0]) {
                    flag[i][j] = true;
                    if (help(board, wordChs, i, j, 1, flag)) {
                        return true;
                    }
                    flag[i][j] = false;
                }
            }
        }
        return false;
    }

    private boolean help(char[][] board, char[] wordChs, int i, int j, int index, boolean[][] flag) {
        if (index >= wordChs.length) {
            return true;
        }
        if (i - 1 >= 0 && !flag[i - 1][j] && board[i - 1][j] == wordChs[index]) {
            flag[i - 1][j] = true;
            if (help(board, wordChs, i - 1, j, index + 1, flag)) {
                return true;
            }
            flag[i - 1][j] = false;
        }
        if (i + 1 < wordChs.length && !flag[i + 1][j] && board[i + 1][j] == wordChs[index]) {
            flag[i + 1][j] = true;
            if (help(board, wordChs, i + 1, j, index + 1, flag)) {
                return true;
            }
            flag[i + 1][j] = false;
        }
        if (j - 1 >= 0 && !flag[i][j - 1] && board[i][j - 1] == wordChs[index]) {
            flag[i][j - 1] = true;
            if (help(board, wordChs, i, j - 1, index + 1, flag)) {
                return true;
            }
            flag[i][j - 1] = false;
        }
        if (j + 1 < board[0].length && !flag[i][j + 1] && board[i][j + 1] == wordChs[index]) {
            flag[i][j + 1] = true;
            if (help(board, wordChs, i, j + 1, index + 1, flag)) {
                return true;
            }
            flag[i][j + 1] = false;
        }
        return false;
    }

    // 深度优先搜索
    public boolean exist2(char[][] board, String word) {
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
        if (i >= board.length || i < 0 || j >= board[0].length || j < 0 || board[i][j] != word[k]) {
            return false;
        }
        if (k == word.length - 1) {
            return true;
        }
        board[i][j] = '\0';
        boolean res = dfs(board, word, i + 1, j, k + 1) || dfs(board, word, i - 1, j, k + 1)
                || dfs(board, word, i, j + 1, k + 1) || dfs(board, word, i, j - 1, k + 1);
        board[i][j] = word[k];
        return res;
    }
}
