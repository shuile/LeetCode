package cn.shui.learning_plan.datastruct.second_day;

import java.util.HashMap;
import java.util.Map;

/**
 * @author shui.
 * @date 2021/8/17.
 * @time 09:14.
 * 两数之和
 */
public class L1 {
    public int[] twoSum1(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return new int[]{-1, -1};
        }
        Map<Integer, Integer> map = new HashMap<>();
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (map.containsKey(nums[i])) {
                return new int[]{map.get(nums[i]), i};
            }
            map.put(target - nums[i], i);
        }
        return new int[]{-1, -1};
    }

    // 暴力枚举
    public int[] twoSum2(int[] nums, int target) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (target - nums[i] == nums[j]) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{-1, -1};
    }
}
