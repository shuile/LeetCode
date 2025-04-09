package cn.shui.order;

/**
 * Created by chenyiting on 2025/4/3
 * Maximum Value Of an ordered Triplet II
 */
public class L2874 {
    public long maximumTripletValue(int[] nums) {
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
