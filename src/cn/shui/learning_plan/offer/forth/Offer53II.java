package cn.shui.learning_plan.offer.forth;

/**
 * @author shui.
 * @date 2021/9/28.
 * @time 10:02.
 * 0~n-1中缺失的数字
 */
public class Offer53II {
    public int missingNumber(int[] nums) {
        if (nums == null || nums.length < 1) {
            return 0;
        }
        int start = -1;
        for (int num : nums) {
            if (num - start != 1) {
                return start + 1;
            }
            start = num;
        }
        return nums.length;
    }

    // 二分法
    public int missingNumber2(int[] nums) {
        if (nums == null || nums.length < 1) {
            return 0;
        }
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == mid) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }
}
