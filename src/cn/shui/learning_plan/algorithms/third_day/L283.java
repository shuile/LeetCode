package cn.shui.learning_plan.algorithms.third_day;

/**
 * @author shui.
 * @date 2021/7/16.
 * @time 09:29.
 * 移动零
 */
public class L283 {
    private void moveZeros1(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        int nonZero = 0, index = 0, len = nums.length;
        while (index < len) {
            if (nums[index] != 0) {
                nums[nonZero++] = nums[index];
            }
            index++;
        }
        while (nonZero < len) {
            nums[nonZero++] = 0;
        }
    }

    private void moveZeros2(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        int left = 0, right = 0, len = nums.length;
        while (right < len) {
            if (nums[right] != 0) {
                swap(nums, left++, right);
            }
            right++;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
