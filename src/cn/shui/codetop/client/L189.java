package cn.shui.codetop.client;

/**
 * Created by chenyiting on 2022/4/11
 * 轮转数组
 */
public class L189 {
    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length < 2) {
            return;
        }
        int len = nums.length;
        k %= len;
        int[] temp = new int[k];
        System.arraycopy(nums, len - k, temp, 0, k);
        System.arraycopy(nums, 0, nums, k, len - k);
        System.arraycopy(temp, 0, nums, 0, k);
    }

    public void rotate2(int[] nums, int k) {
        if (nums == null || nums.length < 2) {
            return;
        }
        int len = nums.length;
        k %= len;
        reverse(nums, 0, len - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, len - 1);
    }

    private void reverse(int[] nums, int i, int j) {
        while (i < j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }
}
