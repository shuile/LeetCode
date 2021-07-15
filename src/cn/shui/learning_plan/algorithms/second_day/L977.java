package cn.shui.learning_plan.algorithms.second_day;

/**
 * @author shui.
 * @date 2021/7/15.
 * @time 11:48.
 * 有序数组的平方
 */
public class L977 {
    public int[] sortedSquares(int[] nums) {
        if (nums == null || nums.length < 1) {
            return nums;
        }
        int l = 0, r = nums.length - 1, pos = r;
        int[] ans = new int[nums.length];
        while (l <= r) {
            if (nums[l] * nums[l] <= nums[r] * nums[r]) {
                ans[pos] = nums[r] * nums[r];
                r--;
            } else {
                ans[pos] = nums[l] * nums[l];
                l++;
            }
            pos--;
        }
        return ans;
    }
}
