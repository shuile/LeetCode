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
        int l = 0, r = nums.length - 1;
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

    // 优化
    public int[] searchRange2(int[] nums, int target) {
        int start = find(nums, target, false);
        int end = find(nums, target, true);
        return new int[]{start, end};
    }

    private int find(int[] nums, int target, boolean isEnd) {
        int len = nums.length;
        int l = 0, r = len - 1;
        while (l <= r) {
            int mid = (r - l) / 2 + l;
            if (nums[mid] == target) {
                if (isEnd) {
                    if (mid == len - 1 || nums[mid] != nums[mid + 1]) {
                        return mid;
                    }
                    l = mid + 1;
                } else {
                    if (mid == 0 || nums[mid] != nums[mid - 1]) {
                        return mid;
                    }
                    r = mid - 1;
                }
                continue;
            }
            if (nums[target] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return -1;
    }

    // 代码优化
    public int[] searchRange3(int[] nums, int target) {
        int left = binarySearch(nums, target, true);
        int right = binarySearch(nums, target, false) - 1;
        if (left <= right && right < nums.length && nums[left] == target && nums[right] == target) {
            return new int[]{left, right};
        }
        return new int[]{-1, -1};
    }

    private int binarySearch(int[] nums, int target, boolean lower) {
        int l = 0, r = nums.length - 1, ans = nums.length;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] > target || (lower && nums[mid] >= target)) {
                r = mid - 1;
                ans = mid;
            } else {
                l = mid + 1;
            }
        }
        return ans;
    }
}
