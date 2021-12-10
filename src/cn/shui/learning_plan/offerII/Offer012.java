package cn.shui.learning_plan.offerII;

/**
 * @author shui.
 * @date 2021/12/7.
 * @time 19:29.
 * 左右两边子数组的和相等
 */
public class Offer012 {
    public int pivotIndex(int[] nums) {
        int total = 0;
        for (int num : nums) {
            total += num;
        }
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (2 * sum + nums[i] == total) {
                return i;
            }
            sum += nums[i];
        }
        return -1;
    }
}
