package cn.shui.order;

/**
 * Created by chenyiting on 2025/4/2
 * Maximum Value Of an Ordered Triplet I
 */
public class L2873 {
    public long maximumTripletValue(int[] nums) {
        if (nums == null || nums.length < 3) {
            return 0;
        }
        int len = nums.length;
        long ans = 0;
        for (int k = 2; k < len; k++) {
            for (int j = 1; j < k; j++) {
                for (int i = 0; i < j; i++) {
                    ans = Math.max(ans, (long) (nums[i] - nums[j]) * nums[k]);
                }
            }
        }
        return ans;
    }

    // 贪心
    public long maximumTripletValue2(int[] nums) {
        if (nums == null || nums.length < 3) {
            return 0;
        }
        int len = nums.length;
        long ans = 0;
        for (int k = 2; k < len; k++) {
            int m = nums[0];
            for (int j = 1; j < k; j++) {
                ans = Math.max(ans, (long) (m - nums[j]) * nums[k]);
                m = Math.max(m, nums[j]);
            }
        }
        return ans;
    }

    // 贪心 + 前后缀数组
    public long maximumTripletValue3(int[] nums) {
        if (nums == null || nums.length < 3) {
            return 0;
        }
        int len = nums.length;
        int[] leftMax = new int[len];
        int[] rightMax = new int[len];
        for (int i = 1; i < len; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], nums[i - 1]);
            rightMax[len - 1 - i] = Math.max(rightMax[len - i], nums[len - i]);
        }
        long ans = 0;
        for (int j = 1; j < len - 1; j++) {
            ans = Math.max(ans, (long) (leftMax[j] - nums[j]) * rightMax[j]);
        }
        return ans;
    }

    // 贪心
    public long maximumTripletValue4(int[] nums) {
        if (nums == null || nums.length < 3) {
            return 0;
        }
        int len = nums.length;
        long ans = 0, iMax = 0, dMax = 0;
        for (int k = 0; k < len; k++) {
            ans = Math.max(ans, dMax * nums[k]);
            dMax = Math.max(dMax, iMax - nums[k]);
            iMax = Math.max(iMax, nums[k]);
        }
        return ans;
    }
}
