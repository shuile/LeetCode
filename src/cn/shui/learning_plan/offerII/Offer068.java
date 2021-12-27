package cn.shui.learning_plan.offerII;

/**
 * @author shui.
 * @date 2021/12/27.
 * @time 23:05.
 * 查找插入位置
 */
public class Offer068 {
    public int searchInsert(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}
