package cn.shui.codetop.client;

import java.util.Arrays;

/**
 * Created by chenyiting on 2022/4/11
 * 不同路径
 */
public class L62 {
    // 超时
    public int uniquePaths(int m, int n) {
        return help(1, 1, m, n);
    }

    private int help(int startM, int startN, int m, int n) {
        if (startM == m || startN == n) {
            return 1;
        }
        return help(startM + 1, startN, m, n) + help(startM, startN + 1, m, n);
    }

    // 动态规划
    public int uniquePaths2(int m, int n) {
        int[][] dp = new int[m][n];
        Arrays.fill(dp[0], 1);
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (j == 0) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
                }
            }
        }
        return dp[m - 1][n - 1];
    }

    // 组合数学
    public int uniquePaths3(int m, int n) {
        long ans = 1;
        for (int x = n, y = 1; y < m; x++, y++) {
            ans = ans * x / y;
        }
        return (int) ans;
    }
}
