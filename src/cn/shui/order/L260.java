package cn.shui.order;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by chenyiting on 2022/10/20
 * 只出现一次的数字III
 */
public class L260 {
    public int[] singleNumber(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        int[] ans = new int[2];
        int index = 0;
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            if (entry.getValue() == 1) {
                ans[index++] = entry.getKey();
            }
        }
        return ans;
    }

    public int[] singleNumber2(int[] nums) {
        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }
        int lsb = xor == Integer.MIN_VALUE ? xor : xor & -xor;
        int type1 = 0, type2 = 0;
        for (int num : nums) {
            if ((num & lsb) == 0) {
                type1 ^= num;
            } else {
                type2 ^= num;
            }
        }
        return new int[]{type1, type2};
    }
}
