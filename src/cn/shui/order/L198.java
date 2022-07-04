package cn.shui.order;

import java.util.Arrays;

/**
 * Created by chenyiting on 2022/7/4
 * 打家劫舍
 */
public class L198 {
    public int rob(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len + 1];
        Arrays.fill(dp, 0);
        dp[1] = nums[0];
        for (int i = 2; i <= len; i++) {
            if (i == 2) {
                dp[i] = dp[i - 2] + nums[i - 1];
            } else {
                dp[i] = Math.max(dp[i - 2], dp[i - 3]) + nums[i - 1];
            }
        }
        return Math.max(dp[len - 1], dp[len]);
    }

    // 优化空间
    public int rob2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int len = nums.length;
        if (len == 1) {
            return nums[0];
        }
        int first = nums[0], second = Math.max(nums[0], nums[1]);
        for (int i = 2; i < len; i++) {
            int temp = second;
            second = Math.max(first + nums[i], second);
            first = temp;
        }
        return second;
    }
}
