package cn.shui.codetop.client;

import java.util.Arrays;

/**
 * Created by chenyiting on 2022/5/6
 * 零钱兑换
 */
public class L322 {
    private int ans = Integer.MAX_VALUE;

    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        help(coins, amount, 0, 0);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    private void help(int[] coins, int amount, int idx, int count) {
        if (amount == 0) {
            ans = Math.min(ans, count);
            return;
        }
        for (int i = idx; i < coins.length; i++) {
            if (coins[i] > amount) {
                break;
            }
            help(coins, amount - coins[i], idx, count + 1);
        }
    }

    // 记忆化搜索
    public int coinChange2(int[] coins, int amount) {
        return help(coins, amount, new int[amount]);
    }

    private int help(int[] coins, int amount, int[] count) {
        if (amount < 0) {
            return -1;
        }
        if (amount == 0) {
            return 0;
        }
        if (count[amount - 1] != 0) {
            return count[amount - 1];
        }
        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            int res = help(coins, amount - coin, count);
            if (res >= 0 && res < min) {
                min = 1 + res;
            }
        }
        count[amount - 1] = min == Integer.MAX_VALUE ? - 1 : min;
        return count[amount - 1];
    }

    // 动态优化
    public int coinChange3(int[] coins, int amount) {
        int len = coins.length;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (coin <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[amount];
    }
}
