package cn.shui.learning_plan.datastruct.first_day;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author shui.
 * @date 2021/8/16.
 * @time 09:24.
 */
public class L217 {
    public boolean containsDuplicate1(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return false;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                return true;
            }
        }
        return false;
    }

    public boolean containsDuplicate2(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return false;
        }
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                return true;
            }
            set.add(num);
        }
        return false;
    }
}
