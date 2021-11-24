package cn.shui.learning_plan.offer.twenty_nine;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author shui.
 * @date 2021/11/23.
 * @time 11:15.
 * n个骰子的点数
 */
public class Offer60 {

    private Map<Integer, Integer> map = new HashMap<>();

    // 超时
    public double[] dicesProbability(int n) {
        double total = Math.pow(6, n);
        help(0, n, 0);
        double[] ans = new double[map.size()];
        Integer[] keys = map.keySet().toArray(new Integer[0]);
        Arrays.sort(keys);
        for (int i = 0; i < keys.length; i++) {
            ans[i] = map.get(keys[i]) / total;
        }
        return ans;
    }

    private void help(int curr, int n, int sum) {
        if (curr >= n) {
            map.put(sum, map.getOrDefault(sum, 0) + 1);
            return;
        }
        for (int i = 1; i <= 6; i++) {
            help(curr + 1, n, sum + i);
        }
    }

    // 动态规划
    public double[] dicesProbability2(int n) {
        double[] dp = new double[6];
        Arrays.fill(dp, 1.0 / 6.0);
        for (int i = 2; i <= n; i++) {
            double[] tmp = new double[5 * i + 1];
            for (int j = 0; j < dp.length; j++) {
                for (int k = 0; k < 6; k++) {
                    tmp[j + k] += dp[j] / 6.0;
                }
            }
            dp = tmp;
        }
        return dp;
    }
}
