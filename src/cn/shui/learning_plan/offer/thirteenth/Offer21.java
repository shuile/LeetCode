package cn.shui.learning_plan.offer.thirteenth;

/**
 * @author shui.
 * @date 2021/10/14.
 * @time 14:33.
 */
public class Offer21 {
    public int[] exchange(int[] nums) {
        if (nums == null || nums.length < 1) {
            return nums;
        }
        int l = 0, r = 0;
        while (r < nums.length) {
            if (nums[r] % 2 == 1) {
                int temp = nums[l];
                nums[l] = nums[r];
                nums[r] = temp;
                l++;
            }
            r++;
        }
        return nums;
    }

    // 优化
    public int[] exchange2(int[] nums) {
        int l = 0, r = nums.length - 1, tmp;
        while (l < r) {
            while (l < r && ((nums[l] & 1) == 1)) {
                l++;
            }
            while (l < r && (nums[r] & 1) == 0) {
                r--;
            }
            tmp = nums[l];
            nums[l] = nums[r];
            nums[r] = tmp;
        }
        return nums;
    }
}
