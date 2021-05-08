package cn.shui.offer;

public class Offer_47 {
    public static void main(String[] args) {

    }

    private int maxValue(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return -1;
        }
        int row = grid.length;
        int column = grid[0].length;
        int[][] dp = new int[row][column];
        dp[0][0] = grid[0][0];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
//                if (i == 0) {
//                    dp[i][j] = dp[i][j - 1] + grid[i][j];
//                    continue;
//                }
//                if (j == 0) {
//                    dp[i][j] = dp[i - 1][j] + grid[i][j];
//                    continue;
//                }
//                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
                int last;
                if (i == 0) {
                    last = dp[i][j - 1];
                } else if (j == 0) {
                    last = dp[i - 1][j];
                } else {
                    last = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
                dp[i][j] = last + grid[i][j];
            }
        }
        return dp[row - 1][column - 1];
    }

    private int maxValue2(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return -1;
        }
        int row = grid.length;
        int column = grid[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                int last;
                if (i == 0) {
                    last = grid[i][j - 1];
                } else if (j == 0) {
                    last = grid[i - 1][j];
                } else {
                    last = Math.max(grid[i - 1][j], grid[i][j - 1]);
                }
                grid[i][j] += last;
            }
        }
        return grid[row - 1][column - 1];
    }

    private int maxValue3(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return -1;
        }
        int row = grid.length;
        int column = grid[0].length;
        for (int i = 1; i < row; i++) {
            grid[i][0] += grid[i - 1][0];
        }
        for (int j = 1; j < column; j++) {
            grid[0][j] += grid[0][j - 1];
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < column; j++) {
                grid[i][j] += Math.max(grid[i - 1][j], grid[i][j - 1]);
            }
        }
        return grid[row - 1][column - 1];
    }
}
