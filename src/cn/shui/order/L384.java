package cn.shui.order;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * @author shui.
 * @date 2021/11/22.
 * @time 14:57.
 * 打乱数组
 */
public class L384 {

    // 暴力法
    private class Solution {
        private int[] nums;
        private int[] original;

        public Solution(int[] nums) {
            this.nums = nums;
            this.original = new int[nums.length];
            System.arraycopy(nums, 0, original, 0, nums.length);
        }

        public int[] reset() {
            System.arraycopy(original, 0, nums, 0, nums.length);
            return nums;
        }

        public int[] shuffle() {
            int[] shuffled = new int[nums.length];
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                list.add(nums[i]);
            }
            Random random = new Random();
            for (int i = 0; i < nums.length; i++) {
                int j = random.nextInt(list.size());
                shuffled[i] = list.remove(j);
            }
            System.arraycopy(shuffled, 0, nums, 0, nums.length);
            return nums;
        }
    }

    private class Solution2 {
        private int[] nums;
        private int[] original;

        public Solution2(int[] nums) {
            this.nums = nums;
            this.original = new int[nums.length];
            System.arraycopy(nums, 0, original, 0, nums.length);
        }

        public int[] reset() {
            System.arraycopy(original, 0, nums, 0, nums.length);
            return nums;
        }

        public int[] shuffle() {
            Random random = new Random();
            for (int i = 0; i < nums.length; i++) {
                int j = i + random.nextInt(nums.length - i);
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
            }
            return nums;
        }
    }
}
