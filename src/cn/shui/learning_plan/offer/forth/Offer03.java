package cn.shui.learning_plan.offer.forth;

import java.util.HashSet;
import java.util.Set;

/**
 * @author shui.
 * @date 2021/9/28.
 * @time 09:30.
 * 数组中重复的数字
 */
public class Offer03 {
    public int findRepeatNumber(int[] nums) {
        if (nums == null || nums.length < 2) {
            return -1;
        }
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                return num;
            }
            set.add(num);
        }
        return -1;
    }
}
