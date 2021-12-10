package cn.shui.learning_plan.offerII;

import java.util.HashMap;
import java.util.Map;

/**
 * @author shui.
 * @date 2021/12/6.
 * @time 16:38.
 * 和为k的子数组
 */
public class Offer010 {
    public int subarraySum(int[] nums, int k) {
        int pre_sum = 0;
        int ret = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i : nums) {
            pre_sum += i;
            ret += map.getOrDefault(pre_sum - k, 0);
            map.put(pre_sum, map.getOrDefault(pre_sum, 0) + 1);
        }
        return ret;
    }
}
