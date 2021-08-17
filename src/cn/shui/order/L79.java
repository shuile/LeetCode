package cn.shui.order;

/**
 * @author shui.
 * @date 2021/8/17.
 * @time 13:04.
 * 单词搜索
 */
public class L79 {

    public static void main(String[] args) {
        int[][] a = {{1, 2, 3}, {4, 5, 6}, {7,8, 9}};
        int[][] b = new int[a.length][a[0].length];
        copyArray(a, b);
        System.out.println(a[0][0]);
        System.out.println(b[0][0]);

        System.out.println();

        b[0][0] = 100;

        System.out.println(a[0][0]);
        System.out.println(b[0][0]);

        System.out.println();

    }

    private static void copyArray(int[][] source, int[][] dest) {
        int column = source[0].length;
        for (int i = 0; i < source.length; i++) {
            System.arraycopy(source[i], 0, dest[i], 0, column);
        }
    }

    public boolean exist1(char[][] board, String word) {
        char[] wordsChs = word.toCharArray();
        int row = board.length, column = board[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (board[i][j] != wordsChs[0]) {
                    continue;
                }
                boolean res = dfs(board, word, "", i, j);
                if (res) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, String cutStr, int curI, int curJ) {
        if (curI < 0 || curJ < 0 || curI >= board.length || curJ >= board[0].length || board[curI][curJ] == ' ') {
            return false;
        }
        char ch = board[curI][curJ];
        String temp = cutStr + ch;
        int len = temp.length();
        if (len > word.length()) {
            return false;
        }
        if (len == word.length()) {
            return temp.equals(word);
        }
        if (!word.startsWith(temp)) {
            return false;
        }
        board[curI][curJ] = ' ';
        boolean res = dfs(board, word, temp, curI + 1, curJ) || dfs(board, word, temp, curI - 1, curJ)
                || dfs(board, word, temp, curI, curJ + 1) || dfs(board, word, temp, curI, curJ - 1);
        if (res) {
            return true;
        }
        board[curI][curJ] = ch;
        return false;
    }

    // 回溯
    public boolean exist2(char[][] board, String word) {
        int h = board.length, w = board[0].length;
        boolean[][] visited = new boolean[h][w];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                boolean flag = check(board, visited,i, j, word, 0);
                if (flag) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean check(char[][] board, boolean[][] visited, int i, int j, String s, int k) {
        if (board[i][j] != s.charAt(k)) {
            return false;
        }
        if (k == s.length() - 1) {
            return true;
        }
        visited[i][j] = true;
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        boolean result = false;
        for (int[] dir : directions) {
            int newi = i + dir[0], newj = j + dir[1];
            if (newi >= 0 && newi < board.length && newj >= 0 && newj < board[0].length) {
                if (!visited[newi][newj]) {
                    boolean flag = check(board, visited, newi, newj, s, k + 1);
                    if (flag) {
                        result = true;
                        break;
                    }
                }
            }
        }
        visited[i][j] = false;
        return result;
    }
}
