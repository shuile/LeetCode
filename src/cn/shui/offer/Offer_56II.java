package cn.shui.offer;

import java.util.Arrays;

public class Offer_56II {
    public static void main(String[] args) {

    }

    private int singleNumber(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int len = nums.length;
        if ((len - 1) % 3 != 0) {
            return len;
        }
        Arrays.sort(nums);
        if (nums[0] != nums[1]) {
            return nums[0];
        }
        for (int i = 1; i < len - 1; i++) {
            if (nums[i] != nums[i - 1] && nums[i] != nums[i + 1]) {
                return nums[i];
            }
        }
        if (nums[len - 1] != nums[len - 2]) {
            return nums[len - 1];
        }
        return len;
    }

    private int singleNumber2(int[] nums) {
        int[] count = new int[32];
        for (int num : nums) {
            for (int i = 0; i < 32; i++) {
                count[i] += num & 1;
                num >>>= 1;
            }
        }
        int res = 0, m = 3;
        for (int i = 0; i < 32; i++) {
            res <<= 1;
            res |= count[31 - i] % m;
        }
        return res;
    }

    /**
     * 不太理解
     */
    private int singleNumber3(int[] nums) {
        int ones = 0, twos = 0;
        for (int num : nums) {
            ones = ones ^ num & ~twos;
            twos  = twos ^ num & ~ones;
        }
        return ones;
    }
}
