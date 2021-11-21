package cn.shui.order;

/**
 * @author shui.
 * @date 2021/11/21.
 * @time 20:53.
 * 寻找峰值
 */
public class L162 {
    public int findPeakElement(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            if (isPeak(nums, l)) {
                return l;
            }
            if (isPeak(nums, r)) {
                return r;
            }
            l++;
            r--;
        }
        return 0;
    }

    private boolean isPeak(int[] nums, int index) {
        if (index == 0) {
            return nums[index] > nums[index + 1];
        }
        if (index == nums.length - 1) {
            return nums[index] > nums[index - 1];
        }
        return nums[index] > nums[index - 1] && nums[index] > nums[index + 1];
    }

    // 贪心二分
    public int findPeakElement2(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] < nums[mid + 1]) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }
}
