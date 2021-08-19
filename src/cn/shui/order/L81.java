package cn.shui.order;

import java.util.Arrays;

/**
 * @author shui.
 * @date 2021/8/19.
 * @time 10:35.
 * 搜索旋转排序数组II
 */
public class L81 {
    public boolean search1(int[] nums, int target) {
        Arrays.sort(nums);
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target) {
                return true;
            }
            if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return false;
    }

    public boolean search2(int[] nums, int target) {
        int len = nums.length;
        if (len == 0) {
            return false;
        }
        if (len == 1) {
            return nums[0] == target;
        }
        int l = 0, r = len - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target) {
                return true;
            }
            if (nums[l] == nums[mid] && nums[mid] == nums[r]) {
                l++;
                r--;
            } else if (nums[l] <= nums[mid]) {
                if (nums[l] <= target && target < nums[mid]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[len - 1]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }
        return false;
    }
}
