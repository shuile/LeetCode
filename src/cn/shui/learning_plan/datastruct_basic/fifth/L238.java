package cn.shui.learning_plan.datastruct_basic.fifth;

import java.util.Arrays;

/**
 * @author shui.
 * @date 2021/9/8.
 * @time 22:44.
 * 除自身以外数组的乘积
 */
public class L238 {
    public int[] productExceptSelf1(int[] nums) {
        if (nums == null || nums.length < 1) {
            return null;
        }
        int len = nums.length;
        int[] ans = new int[len];
        Arrays.fill(ans, 1);
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (i != j) {
                    ans[j] *= nums[i];
                }
            }
        }
        return ans;
    }

    // 左右乘积列表
    public int[] productExceptSelf2(int[] nums) {
        if (nums == null || nums.length < 1) {
            return null;
        }
        int len = nums.length;
        int[] ans = new int[len];
        // L 和 R分别表示左右两侧的乘积列表
        int[] L = new int[len];
        int[] R = new int[len];
        // L[i]为索引i左侧所有元素的乘积
        // 对于索引为'0'的元素，因为左侧没有元素，所以L[0] = 1
        L[0] = 1;
        for (int i = 1; i < len; i++) {
            L[i] = nums[i - 1] * L[i - 1];
        }
        // R[i]为索引i右侧所有元素的乘积
        // 对于索引为'len - 1'的元素，因为右侧没有元素，所有R[len - 1] = 1
        R[len - 1] = 1;
        for (int i = len - 2; i >= 0; i--) {
            R[i] = R[i + 1] * nums[i + 1];
        }
        // 对于索引i，除nums[i]之外其余各元素的乘积就是左侧所有元素的乘积乘以右侧所有元素的乘积
        for (int i = 0; i < len; i++) {
            ans[i] = L[i] * R[i];
        }
        return ans;
    }

    // 空间复杂度O(1)的方法
    public int[] productExceptSelf3(int[] nums) {
        if (nums == null || nums.length < 1) {
            return null;
        }
        int len = nums.length;
        int[] ans = new int[len];
        // ans[i]表示索引i左侧所有元素的乘积，因为索引'0'的元素左侧没有元素，所有ans[0] = 1
        ans[0] = 1;
        for (int i = 1; i < len; i++) {
            ans[i] = ans[i - 1] * nums[i - 1];
        }
        // R为右侧所有元素的乘积刚开始右边没有元素，所有R = 1
        int R = 1;
        for (int i = len - 1; i >= 0; i--) {
            // 对于索引i，左边的乘积为ans[i]，右边的乘积为R
            ans[i] *= R;
            // R需要包含右边所有的乘积，所以计算下一个结果时需要将当前值乘到R上
            R *= nums[i];
        }
        return ans;
    }
}
