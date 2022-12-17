package cn.shui.order;

import java.util.Arrays;

/**
 * Created by chenyiting on 2022/12/17
 * 超级丑数
 */
public class L313 {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] dp = new int[n];
        dp[0] = 1;
        int len = primes.length;
        int[] pointers = new int[len];
        int[] nums = new int[len];
        Arrays.fill(nums, 1);
        for (int i = 1; i < n; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < len; j++) {
                nums[j] = dp[pointers[j]] * primes[j];
                if (nums[j] >= 0) {
                    // 超出int范围的情况
                    min = Math.min(min, nums[j]);
                }
            }
            dp[i] = min;
            for (int j = 0; j < len; j++) {
                if (nums[j] == min) {
                    pointers[j]++;
                }
            }
        }
        return dp[n - 1];
    }
}
