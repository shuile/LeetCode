package cn.shui.order;

import java.util.Arrays;

/**
 * @author shui.
 * @date 2022/2/11.
 * @time 11:25.
 * 学生分数的最小差值
 */
public class L1984 {
    public int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i + k - 1 < nums.length; i++) {
            min = Math.min(min, nums[i + k - 1] - nums[i]);
        }
        return min;
    }
}
