package unique_paths;

public class Solution {

    private static int[][] dp;

    public static void main(String[] args) {
        System.out.println(uniquePaths(51, 9));
    }

    private static int uniquePaths(int m, int n) {
        dp = new int[m + 1][n + 1];
        return rec(m, n, m, n);
    }

    private static int rec(int m, int n, int i, int j) {
        if (i == 1 && j == 1)  //左上角
            return 1;
        if (dp[i][j] != 0) { // 已经计算过
            return dp[i][j];
        }
        if (i == 1) { //第一行
            dp[i][j] = rec(m, n, i, j - 1);
        } else if (j == 1) { //第一列
            dp[i][j] = rec(m, n, i - 1, j);
        } else {
            dp[i][j] = rec(m, n, i - 1, j) + rec(m, n, i, j - 1);
        }
        return dp[i][j];
    }
}
