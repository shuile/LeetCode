package cn.shui.order;

/**
 * Created by chenyiting on 2022/10/9
 * 最大正方形
 */
public class L221 {
    // 动态规划
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int row = matrix.length, column = matrix[0].length;
        int[][] dp = new int[row][column];
        for (int i = 0; i < row; i++) {
            dp[i][0] = matrix[i][0] - '0';
        }
        for (int j = 0; j < column; j++) {
            dp[0][j] = matrix[0][j] - '0';
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < column; j++) {
                if (matrix[i][j] == '0') {
                    continue;
                }
                dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
            }
        }
        int len = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                len = Math.max(len, dp[i][j]);
            }
        }
        return len * len;
    }
}
