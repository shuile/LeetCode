package cn.shui.offer;

public class Offer_53I {
    public static void main(String[] args) {

    }

    private int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int l = 0, r = nums.length - 1;
        int ans = 0;
        while (l < r) {
            if (nums[l] == target) {
                ans++;
            }
            if (nums[r] == target) {
                ans++;
            }
            l++;
            r--;
        }
        if (l == r && nums[l] == target) {
            ans++;
        }
        return ans;
    }

    private int search2(int[] nums, int target) {
        // 搜索右边界
        int i = 0, j = nums.length - 1;
        while (i <= j) {
            int m = (i + j) / 2;
            if (nums[m] <= target) {
                i = m + 1;
            } else {
                j = m - 1;
            }
        }
        int right = i;
        if (j >= 0 && nums[j] != target) {
            return 0;
        }
        i = 0;
        j = nums.length - 1;
        while (i <= j) {
            int m = (i + j) / 2;
            if (nums[m] < target) {
                i = m + 1;
            } else {
                j = m - 1;
            }
        }
        int left = j;
        return right - left - 1;
    }

    private int search3(int[] nums, int target) {
        return helper(nums, target) - helper(nums, target - 1);
    }

    private int helper(int[] nums, int target) {
        int i = 0, j = nums.length - 1;
        while (i <= j) {
            int m = (i + j) / 2;
            if (nums[m] <= target) {
                i = m + 1;
            } else {
                j = m - 1;
            }
        }
        return i;
    }
}
