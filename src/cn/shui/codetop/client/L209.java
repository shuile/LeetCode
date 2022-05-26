package cn.shui.codetop.client;

import java.util.Arrays;

/**
 * Created by chenyiting on 2022/4/14
 * 长度最小的数组
 */
public class L209 {
    public int minSubArrayLen(int target, int[] nums) {
        int len = nums.length;
        int ans = Integer.MAX_VALUE, sum = 0, count = 0;
        for (int i = 0; i < len; i++) {
            sum += nums[i];
            count++;
            while ((sum - nums[i - count + 1]) >= target) {
                sum -= nums[i - count + 1];
                count--;
            }
            if (sum >= target) {
                ans = Math.min(ans, count);
            }
        }
        return ans;
    }

    // 暴力解法
    public int minSubArrayLen2(int target, int[] nums) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int sum = nums[i];
            if (sum >= target) {
                return 1;
            }
            for (int j = i + 1; j < nums.length; j++) {
                sum += nums[j];
                if (sum >= target) {
                    min = Math.min(min, j - i + 1);
                    break;
                }
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }

    // 二分查找
    public int minSubArrayLen3(int target, int[] nums) {
        int len = nums.length;
        int min = Integer.MAX_VALUE;
        int[] sums = new int[len + 1];
        for (int i = 1; i <= len; i++) {
            sums[i] = nums[i -1] + sums[i - 1];
        }
        for (int i = 0; i <= len; i++) {
            int s = target + sums[i];
            int index = Arrays.binarySearch(sums, s);
            if (index < 0) {
                index = ~index;
            }
            if (index <= len) {
                min = Math.min(min, index - i);
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }

    // 滑动窗口
    public int minSubArrayLen4(int target, int[] nums) {
        int l = 1, r = nums.length, min = 0;
        while (l <= r) {
            int mid = l + ((r - l) >> 1);
            if (windowExist(nums, mid, target)) {
                r = mid - 1;
                min = mid;
            } else {
                l = mid + 1;
            }
        }
        return min;
    }

    private boolean windowExist(int[] nums, int size, int target) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i >= size) {
                sum -= nums[i - size];
            }
            sum += nums[i];
            if (sum >= target) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        L209 test = new L209();
        test.minSubArrayLen4(11, new int[]{1,1,1,1,1,1,1,1,1});
    }
}
