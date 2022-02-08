package cn.shui.learning_plan.offerII;

/**
 * @author shui.
 * @date 2022/1/4.
 * @time 11:39.
 * 粉刷房子
 */
public class Offer091 {
    public int minCost(int[][] costs) {
        int[][] dp = new int[2][3];
        dp[0] = costs[0];
        for (int i = 1; i < costs.length; i++) {
            for (int j = 0; j < 3; j++) {
                int prev1 = dp[(i - 1) % 2][(j + 1) % 3];
                int prev2 = dp[(i - 1) % 2][(j + 2) % 3];
                dp[i % 2][j] = Math.min(prev1, prev2) + costs[i][j];
            }
        }
        int last = (costs.length - 1) % 2;
        return Math.min(Math.min(dp[last][0], dp[last][1]), dp[last][2]);
    }
}
