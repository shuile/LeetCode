package cn.shui.codetop.client;

/**
 * Created by chenyiting on 2022/3/28
 * 缺失的第一个正数
 */
public class L41 {
    public int firstMissingPositive(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 1;
        }
        int len = nums.length;
        int[] sorted = new int[len];
        for (int i = 0; i < len; i++) {
            sorted[i] = i + 1;
        }
        for (int num : nums) {
            if (num > len || num <= 0) {
                continue;
            }
            sorted[num - 1] = 0;
        }
        for (int s : sorted) {
            if (s != 0) {
                return s;
            }
        }
        return len + 1;
    }

    public int firstMissingPositive2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 1;
        }
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (nums[i] <= 0) {
                nums[i] = len + 1;
            }
        }
        for (int i = 0; i < len; i++) {
            int num = Math.abs(nums[i]);
            if (num <= len) {
                nums[num - 1] = -Math.abs(nums[num - 1]);
            }
        }
        for (int i = 0; i < len; i++) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }
        return len + 1;
    }
}
