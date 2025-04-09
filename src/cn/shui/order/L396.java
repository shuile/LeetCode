package cn.shui.order;

/**
 * Created by chenyiting on 2025/3/31
 * Rotate function
 */
public class L396 {
    // 超时
    public int maxRotateFunction(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        int sum = 0, ans = Integer.MIN_VALUE;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            sum = 0;
            for (int j = 0; j < len; j++) {
                sum += nums[j] * ((j - i + len) % len);
            }
            ans = Math.max(ans, sum);
        }
        return ans;
    }

    // 迭代
    public int maxRotateFunction2(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        int len = nums.length;
        int sum = 0, preSum = 0;
        for (int i = 0; i < len; i++) {
            sum += nums[i];
            preSum += i * nums[i];
        }
        int ans = preSum;
        for (int i = 1; i < len; i++) {
            preSum += sum - len * nums[len - i];
            ans = Math.max(ans, preSum);
        }
        return ans;
    }

    public static void main(String[] args) {
        L396 test = new L396();
        test.maxRotateFunction(new int[]{4, 3, 2, 6});
    }
}
