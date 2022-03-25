package cn.shui.codetop.client;

import java.util.Arrays;

/**
 * Created by chenyiting on 2022/3/25
 * 岛屿数量
 */
public class L200 {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int rows = grid.length, columns = grid[0].length;
        boolean[][] visited = new boolean[rows][columns];
        for (int i = 0; i < rows; i++) {
            Arrays.fill(visited[i], false);
        }
        int ans = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (visited[i][j]) {
                    continue;
                }
                if (grid[i][j] == '0') {
                    visited[i][j] = true;
                } else {
                    help(grid, visited, i, j);
                    ans++;
                }
            }
        }
        return ans;
    }

    private void help(char[][] grid, boolean[][] visited, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || visited[i][j]) {
            return;
        }
        visited[i][j] = true;
        if (grid[i][j] == '0') {
            return;
        }
        help(grid, visited, i + 1, j);
        help(grid, visited, i - 1, j);
        help(grid, visited, i, j + 1);
        help(grid, visited, i, j - 1);
    }
}
