package cn.shui.codetop.client;

/**
 * Created by chenyiting on 2022/3/26
 * 在排序数组中查找元素的第一个和最后一个位置
 */
public class L34 {
    public int[] searchRange(int[] nums, int target) {
        int start = findStart(nums, target);
        int end = findEnd(nums, target);
        return new int[]{start, end};
    }

    private int findStart(int[] nums, int target) {
        int l =0, r = nums.length - 1;
        while (l <= r) {
            int mid = (r - l) / 2 + l;
            if (nums[mid] == target) {
                if (mid > 0) {
                    if (nums[mid] != nums[mid - 1]) {
                        return mid;
                    } else {
                        r = mid - 1;
                        continue;
                    }
                } else {
                    return mid;
                }
            }
            if (nums[mid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return -1;
    }

    private int findEnd(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = (r - l) / 2 + l;
            if (nums[mid] == target) {
                if (mid < nums.length - 1) {
                    if (nums[mid] != nums[mid + 1]) {
                        return mid;
                    } else {
                        l = mid + 1;
                        continue;
                    }
                } else {
                    return mid;
                }
            }
            if (nums[mid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return -1;
    }
}
