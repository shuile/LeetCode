package cn.shui.order;

/**
 * @author shui.
 * @date 2021/11/5.
 * @time 09:15.
 * 买卖股票的最佳时机II
 */
public class L122 {
    // 动态规划
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[n - 1][0];
    }

    // 动态规划 + 优化
    public int maxProfit2(int[] prices) {
        int n = prices.length;
        int dp0 = 0, dp1 = -prices[0];
        for (int i = 1; i < n; i++) {
            dp0 = Math.max(dp0, dp1 + prices[i]);
            dp1 = Math.max(dp1, dp0 - prices[i]);
        }
        return dp0;
    }

    // 贪心
    public int maxProfit3(int[] prices) {
        int ans = 0;
        int n = prices.length;
        for (int i = 1; i < n; i++) {
            ans += Math.max(0, prices[i] - prices[i - 1]);
        }
        return ans;
    }
}
