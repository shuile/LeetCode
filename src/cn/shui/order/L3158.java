package cn.shui.order;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by chenyiting on 2024/10/12
 */
public class L3158 {
    public int duplicateNumbersXOR(int[] nums) {
        int ans = 0;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                ans ^= num;
            } else {
                set.add(num);
            }
        }
        return ans;
    }
}
