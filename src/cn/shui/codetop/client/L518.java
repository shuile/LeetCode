package cn.shui.codetop.client;

/**
 * Created by chenyiting on 2022/5/6
 * 零钱兑换II
 */
public class L518 {
    public int change(int amount, int[] coins) {
        return help(coins, amount, 0);
    }

    private int help(int[] coins, int amount, int idx) {
        if (amount == 0) {
            return 1;
        }
        if (amount < 0) {
            return 0;
        }
        int ans = 0;
        for (int i = idx; i < coins.length; i++) {
            if (i > idx && coins[i] == coins[i - 1]) {
                continue;
            }
            ans += help(coins, amount - coins[i], i);
        }
        return ans;
    }

    // 动态规划
    public int change2(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] += dp[i - coin];
            }
        }
        return dp[amount];
    }
}
