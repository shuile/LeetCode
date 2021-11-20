package cn.shui.order;

/**
 * @author shui.
 * @date 2021/11/20.
 * @time 21:39.
 * 寻找旋转排序数组中的最小值
 */
public class L153 {
    public int findMin(int[] nums) {
        int ans = nums[0];
        for (int num : nums) {
            ans = Math.min(ans, num);
        }
        return ans;
    }

    // 二分查找
    public int findMin2(int[] nums) {
        int l = 0, h = nums.length - 1;
        while (l < h) {
            int pivot = l + (h - l) / 2;
            if (nums[pivot] < nums[h]) {
                h = pivot;
            } else {
                l = pivot + 1;
            }
        }
        return nums[l];
    }
}
