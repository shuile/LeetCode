package cn.shui.codetop.client;

import java.util.Arrays;

/**
 * Created by chenyiting on 2022/4/6
 * 最接近的三数之和
 */
public class L16 {
    public int threeSumClosest(int[] nums, int target) {
        int len = nums.length;
        long ans = Integer.MAX_VALUE;
        Arrays.sort(nums);
        int l, r, diff, sum;
        for (int i = 0; i < len - 2; i++) {
            l = i + 1;
            r = len - 1;
            diff = target - nums[i];
            while (l < r) {
                sum = nums[l] + nums[r];
                if (sum == diff) {
                    return target;
                }
                if (sum < target) {
                    l++;
                } else {
                    r--;
                }
                if (Math.abs(ans - target) > Math.abs(nums[i] + sum - target)) {
                    ans = nums[i] + sum;
                }
            }
        }
        return (int) ans;
    }
}
