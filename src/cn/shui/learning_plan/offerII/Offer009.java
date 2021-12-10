package cn.shui.learning_plan.offerII;

/**
 * @author shui.
 * @date 2021/12/5.
 * @time 16:57.
 * 乘积小于k的子数组
 */
public class Offer009 {
    // 滑动窗口
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k == 0 || k == 1) {
            return 0;
        }
        int left = 0, ret = 0, total = 1;
        for (int right = 0; right < nums.length; right++) {
            total *= nums[right];
            while (left <= right && total >= k) {
                total /= nums[left++];
            }
            if (left <= right) {
                ret += right - left + 1;
            }
        }
        return ret;
    }
}
