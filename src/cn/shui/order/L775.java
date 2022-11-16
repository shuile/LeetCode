package cn.shui.order;

/**
 * Created by chenyiting on 2022/11/16
 * 全局倒置与局部倒置
 */
public class L775 {
    // 超时
    public boolean isIdealPermutation(int[] nums) {
        int global = 0, local = 0;
        int len = nums.length;
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] > nums[i]) {
                    global++;
                }
            }
        }
        for (int i = 0; i < len - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                local++;
            }
        }
        return global == local;
    }

    // 维护后缀最小值
    public boolean isIdealPermutation2(int[] nums) {
        int n = nums.length, minSuf = nums[n - 1];
        for (int i = n - 3; i >= 0; i--) {
            if (nums[i] > minSuf) {
                return false;
            }
            minSuf = Math.min(minSuf, nums[i + 1]);
        }
        return true;
    }
}
