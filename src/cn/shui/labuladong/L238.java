package cn.shui.labuladong;

/**
 * Created by chenyiting on 2022/6/8
 * 除自身以外的数组的乘积
 */
public class L238 {
    public int[] productExceptSelf(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        int len = nums.length;
        int[] left = new int[len];
        int[] right = new int[len];
        left[0] = right[len - 1] = 1;
        for (int i = 0; i < len - 1; i++) {
            left[i + 1] = left[i] * nums[i];
        }
        for (int i = len - 1; i > 0; i--) {
            right[i - 1] = right[i] * nums[i];
        }
        int[] ans = new int[len];
        for (int i = 0; i < len; i++) {
            ans[i] = left[i] * right[i];
        }
        return ans;
    }

    // 优化空间复杂度为O(1)
    public int[] productExceptSelf2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        int len = nums.length;
        int[] ans = new int[len];
        ans[0] = 1;
        for (int i = 0; i < len - 1; i++) {
            ans[i + 1] = ans[i] * nums[i];
        }
        int r = 1;
        for (int i = len - 1; i >= 0; i--) {
            ans[i] *= r;
            r *= nums[i];
        }
        return ans;
    }
}
