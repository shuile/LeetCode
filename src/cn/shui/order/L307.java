package cn.shui.order;

/**
 * Created by chenyiting on 2022/11/30
 * 区域和检索 - 数组不可变
 */
public class L307 {
    private static class NumArray {
        private int len;
        private int[] nums;
        private int[] sums;

        public NumArray(int[] nums) {
            this.nums = nums;
            len = nums.length;
            sums = new int[len + 1];
            for (int i = 0; i < len; i++) {
                sums[i + 1] = sums[i] = nums[i];
            }
        }

        public void update(int index, int val) {
            if (index < 0 || index >= len) {
                return;
            }
            int diff = val - nums[index];
            nums[index] = val;
            for (int i = index + 1; i <= len; i++) {
                sums[i] += diff;
            }
        }

        public int sumRange(int left, int right) {
            if (left > right || left < 0 || right >= len) {
                return -1;
            }
            return sums[right + 1] - sums[left];
        }
    }
}
