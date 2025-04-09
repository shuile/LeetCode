package cn.shui.order;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by chenyiting on 2025/4/9
 */
public class L3375 {
    public int minOperations(int[] nums, int k) {
        if (nums == null || nums.length < 1) {
            return -1;
        }
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (num < k) {
                return -1;
            }
            if (num > k) {
                set.add(num);
            }
        }
        return set.size();
    }
}
