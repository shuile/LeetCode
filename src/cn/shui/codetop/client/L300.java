package cn.shui.codetop.client;

/**
 * Created by chenyiting on 2022/3/24
 */
public class L300 {
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int res = 0;
        for (int t : dp) {
            res = Math.max(t, res);
        }
        return res;
    }
}
