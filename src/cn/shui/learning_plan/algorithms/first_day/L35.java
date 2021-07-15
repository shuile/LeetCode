package cn.shui.learning_plan.algorithms.first_day;

/**
 * @author shui.
 * @date 2021/7/15.
 * @time 11:45.
 * 搜索插入位置
 */
public class L35 {
    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length < 1) {
            return 0;
        }
        int l = 0, r = nums.length - 1, ans = nums.length;
        int mid;
        while (l <= r) {
            mid = l + (r - l) / 2;
            if (nums[mid] >= target) {
                ans = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return ans;
    }
}
