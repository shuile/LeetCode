package cn.shui.codetop.client;

/**
 * Created by chenyiting on 2022/4/20
 * 乘积最大子数组
 */
public class L152 {

    // 动态规划
    public int maxProduct(int[] nums) {
        int len = nums.length;
        int[] maxF = new int[len];
        int[] minF = new int[len];
        System.arraycopy(nums, 0, maxF, 0, len);
        System.arraycopy(nums, 0, minF, 0, len);
        for (int i = 1; i < len; i++) {
            maxF[i] = Math.max(maxF[i - 1] * nums[i], Math.max(nums[i], minF[i - 1] * nums[i]));
            minF[i] = Math.min(minF[i - 1] * nums[i], Math.max(nums[i], maxF[i - 1] * nums[i]));
        }
        int ans = maxF[0];
        for (int f : maxF) {
            if (f > ans) {
                ans = f;
            }
        }
        return ans;
    }

    // 动态规划优化
    public int maxProduct2(int[] nums) {
        int len = nums.length;
        int maxF = nums[0], minF = nums[0], ans = nums[0];
        for (int i = 1; i < len; i++) {
            int mx = maxF, mn = minF;
            maxF = Math.max(mx * nums[i], Math.max(nums[i], mn * nums[i]));
            minF = Math.min(mn * nums[i], Math.min(nums[i], mx * nums[i]));
            ans = Math.max(ans, maxF);
        }
        return ans;
    }
}
