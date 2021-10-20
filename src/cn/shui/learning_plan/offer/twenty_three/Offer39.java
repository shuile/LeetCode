package cn.shui.learning_plan.offer.twenty_three;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author shui.
 * @date 2021/10/20.
 * @time 15:17.
 */
public class Offer39 {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int half = nums.length / 2 + 1;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() >= half) {
                return entry.getKey();
            }
        }
        return -1;
    }

    // 排序
    public int majorityElement2(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    // 摩尔投票法
    public int majorityElement3(int[] nums) {
        int x = 0, votes = 0;
        for (int num : nums) {
            if (votes == 0) {
                x = num;
            }
            votes += num == x ? 1 : -1;
        }
        return x;
    }
}
