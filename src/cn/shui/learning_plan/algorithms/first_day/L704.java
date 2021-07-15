package cn.shui.learning_plan.algorithms.first_day;

/**
 * @author shui.
 * @date 2021/7/15.
 * @time 11:19.
 * 二分查找
 */
public class L704 {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length < 1) {
            return -1;
        }
        int l = 0, r = nums.length - 1;
        int mid;
        while (l <= r) {
            mid = l + (r - l) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid  - 1;
            }
        }
        return -1;
    }
}
