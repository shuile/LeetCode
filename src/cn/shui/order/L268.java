package cn.shui.order;

import java.util.Arrays;

/**
 * Created by chenyiting on 2022/10/22
 * 丢失的数字
 */
public class L268 {
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i != nums[i]) {
                return i;
            }
        }
        return nums.length;
    }

    // 数学，异或
    public int missingNumber2(int[] nums) {
        int xor = 0;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            xor ^= nums[i] ^ i;
        }
        xor ^= len;
        return xor;
    }

    // 数学
    public int missingNumber3(int[] nums) {
        int len = nums.length;
        int total = len * (len + 1) / 2;
        for (int num : nums) {
            total -= num;
        }
        return total;
    }
}
