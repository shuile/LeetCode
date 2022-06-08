package cn.shui.labuladong;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by chenyiting on 2022/6/8
 * 连续的子数组和
 */
public class L523 {
    public boolean checkSubarraySum(int[] nums, int k) {
        int len = nums.length;
        int[] preSum = new int[len + 1];
        for (int i = 1; i < preSum.length; i++) {
            preSum[i] = preSum[i - 1] + nums[i - 1];
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < preSum.length; i++) {
            int val = preSum[i] % k;
            if (!map.containsKey(val)) {
                map.put(val, i);
            }
        }
        for (int i = 1; i < preSum.length; i++) {
            int val = preSum[i] % k;
            if (map.containsKey(val) && (i - map.get(val)) >= 2) {
                return true;
            }
        }
        return false;
    }

    public boolean checkSubarraySum2(int[] nums, int k) {
        int len = nums.length;
        if (len < 2) {
            return false;
        }
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int val = 0;
        for (int i = 0; i < len; i++) {
            val = (val + nums[i]) % k;
            if (map.containsKey(val)) {
                if (i - map.get(val) >= 2) {
                    return true;
                }
            } else {
                map.put(val, i);
            }
        }
        return false;
    }
}
