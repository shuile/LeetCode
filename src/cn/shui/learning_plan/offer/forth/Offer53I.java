package cn.shui.learning_plan.offer.forth;

/**
 * @author shui.
 * @date 2021/9/28.
 * @time 09:35.
 * 在排序数组中查找数字I
 */
public class Offer53I {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length < 1) {
            return 0;
        }
        int l = 0, r = nums.length - 1;
        if (nums[l] > target || nums[r] < target) {
            return 0;
        }
        while (l <= r) {
            if (nums[l] < target) {
                l++;
            }
            if (nums[r] > target) {
                r--;
            }
            if (nums[l] == target && nums[r] == target) {
                return r - l + 1;
            }
        }
        return 0;
    }

    // 二分查找
    public int search2(int[] nums, int target) {
        int leftIndex = binarySearch(nums, target, true);
        int rightIndex = binarySearch(nums, target, false);
        if (leftIndex <= rightIndex && rightIndex < nums.length && nums[leftIndex] == target && nums[rightIndex] == target) {
            return rightIndex - leftIndex + 1;
        }
        return 0;
    }

    private int binarySearch(int[] nums, int target, boolean lower) {
        int left = 0, right = nums.length - 1, ans = nums.length;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > target || (lower && nums[mid] >= target)) {
                right = mid - 1;
                ans = mid;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }
}
