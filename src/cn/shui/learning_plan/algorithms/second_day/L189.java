package cn.shui.learning_plan.algorithms.second_day;

import java.util.Arrays;

/**
 * @author shui.
 * @date 2021/7/15.
 * @time 11:52.
 * 旋转数组
 */
public class L189 {

    public static void main(String[] args) {
        rotate2(new int[]{-1, -100, 3, 99}, 2);
    }

    // 超时
    public void rotate1(int[] nums, int k) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        int len = nums.length;
        int temp;
        while (k > 0) {
            temp = nums[len - 1];
            for (int i = len - 1; i > 0; i--) {
                nums[i] = nums[i - 1];
            }
            nums[0] = temp;
            k--;
        }
    }

    public static void rotate2(int[] nums, int k) {
        if (nums == null || nums.length < 1) {
            return;
        }
        int len = nums.length;
        k = k % len;
        int[] ans = new int[len];
        System.arraycopy(nums, 0, ans, len - k, k);
        System.arraycopy(nums, k, ans, 0, len - k);
        System.arraycopy(ans, 0, nums, 0, len);
    }

    public void rotate3(int[] nums, int k) {
        if (nums == null || nums.length < 1) {
            return;
        }
        int len = nums.length;
        k = k % len;
        int[] ans = new int[len];
        for (int i = len - k; i < len; i++) {
            ans[i + k - len] = nums[i];
        }
        for (int i = 0; i < len -k; i++) {
            ans[i + k] = nums[i];
        }
        for (int i = 0; i < len; i++) {
            nums[i] = ans[i];
        }
    }

    // 使用额外的数组
    private void rotate4(int[] nums, int k) {
        if (nums == null || nums.length < 1) {
            return;
        }
        int len = nums.length;
        int[] ans = new int[len];
        for (int i = 0; i < len; i++) {
            ans[(i + k) % len] = nums[i];
        }
        System.arraycopy(ans, 0, nums, 0, len);
    }

    // 环状替换
    private void rotate5(int[] nums, int k) {
        int len = nums.length;
        k = k % len;
        int count = gcd(k, len);
        for (int start = 0; start < count; start++) {
            int current = start;
            int prev = nums[start];
            do {
                int next = (current + k) % len;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                current = next;
            } while (start != current);
        }
    }

    private int gcd(int x, int y) {
        return y > 0 ? gcd(y, x % y) : x;
    }

    private void rotate6(int[] nums, int k) {
        if (nums == null || nums.length < 1) {
            return;
        }
        int len = nums.length;
        k = k % len;
        reverse(nums, 0, len - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, len - 1);

    }
    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
