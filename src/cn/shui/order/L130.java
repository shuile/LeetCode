package cn.shui.order;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author shui.
 * @date 2021/11/9.
 * @time 10:05.
 */
public class L130 {
    public void solve(char[][] board) {
        if (board == null || board.length < 1 || board[0].length < 1) {
            return;
        }
        int row = board.length, column = board[0].length;
        if (row * column == 1) {
            return;
        }
        List<int[]> list = new ArrayList<>();
        boolean[][] flag = new boolean[row][column];
        for (int i = 0; i < row; i++) {
            if (board[i][0] == 'O') {
                list.add(new int[]{i, 0});
            }
            if (board[i][column - 1] == 'O') {
                list.add(new int[]{i, column - 1});
            }
        }
        for (int i = 1; i < column - 1; i++) {
            if (board[0][i] == 'O') {
                list.add(new int[]{0, i});
            }
            if (board[row - 1][i] == 'O') {
                list.add(new int[]{row - 1, i});
            }
        }
        if (list.size() > 0) {
            for (int[] nums : list) {
                dfs(nums[0], nums[1], flag, board);
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                board[i][j] = flag[i][j] ? 'O' : 'X';
            }
        }
    }

    private void dfs(int x, int y, boolean[][] flag, char[][] board) {
        if (x < 0 || y < 0 || x >= flag.length || y >= flag[0].length || flag[x][y] || board[x][y] == 'X') {
            return;
        }
        flag[x][y] = true;
        dfs(x + 1, y, flag, board);
        dfs(x - 1, y, flag, board);
        dfs(x, y + 1, flag, board);
        dfs(x, y - 1, flag, board);
    }

    //深度优先搜索
    int n, m;
    public void solve2(char[][] board) {
        n = board.length;
        if (n == 0) {
            return;
        }
        m = board[0].length;
        for (int i = 0; i < n; i++) {
            dfs(board, i, 0);
            dfs(board, i, m - 1);
        }
        for (int i = 1; i < m - 1; i++) {
            dfs(board, 0, i);
            dfs(board, n - 1, i);
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                board[i][j] = board[i][j] == 'A' ? 'O' : 'X';
            }
        }
    }

    private void dfs(char[][] board, int x, int y) {
        if (x < 0 || x >= n || y < 0 || y >= m || board[x][y] != 'O') {
            return;
        }
        board[x][y] = 'A';
        dfs(board, x + 1, y);
        dfs(board, x - 1, y);
        dfs(board, x, y + 1);
        dfs(board, x, y - 1);
    }

    // 广度优先搜索
    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, 1, -1};
    public void solve3(char[][] board) {
        int n = board.length;
        if (n == 0) {
            return;
        }
        int m = board[0].length;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (board[i][0] == 'O') {
                queue.offer(new int[]{i, 0});
                board[i][0] = 'A';
            }
            if (board[i][m - 1] == 'O') {
                queue.offer(new int[]{i, m - 1});
                board[i][m - 1] = 'A';
            }
        }
        for (int i = 1; i < m - 1; i++) {
            if (board[0][i] == 'O') {
                queue.offer(new int[]{0, i});
                board[0][i] = 'A';
            }
            if (board[n - 1][i] == 'O') {
                queue.offer(new int[]{n - 1, i});
                board[n - 1][i] = 'A';
            }
        }
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int x = cell[0], y = cell[1];
            for (int i = 0; i < 4; i++) {
                int mx = x + dx[i], my = y + dy[i];
                if (mx < 0 || my > 0 || mx >= n || my >= m || board[mx][my] != 'O') {
                    continue;
                }
                queue.offer(new int[]{mx, my});
                board[mx][my] = 'A';
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                board[i][j] = board[i][j] == 'A' ? 'O' : 'X';
            }
        }
    }
}
