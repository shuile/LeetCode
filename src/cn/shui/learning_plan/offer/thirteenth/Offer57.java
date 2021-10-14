package cn.shui.learning_plan.offer.thirteenth;

/**
 * @author shui.
 * @date 2021/10/14.
 * @time 14:46.
 */
public class Offer57 {
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return new int[2];
        }
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int sum = nums[l] + nums[r];
            if (sum == target) {
                return new int[]{nums[l], nums[r]};
            }
            if (sum < target) {
                l++;
            } else {
                r--;
            }
        }
        return new int[2];
    }
}
