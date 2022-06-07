package cn.shui.labuladong;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by chenyiting on 2022/6/7
 * 和为K的子数组
 */
public class L560 {
    public int subarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int len = nums.length;
        int[] preSum = new int[len + 1];
        for (int i = 1; i <= len; i++) {
            preSum[i] = preSum[i - 1] + nums[i - 1];
        }
        int ans = 0;
        for (int i = 1; i <= len; i++) {
            for (int j = 0; j < i; j++) {
                int diff = preSum[i] - preSum[j];
                if (diff == k) {
                    ans++;
                }
            }
        }
        return ans;
    }

    public int subarraySum2(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int len = nums.length;
        int[] preSum = new int[len + 1];
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int ans = 0;
        for (int i = 1; i <= len; i++) {
            preSum[i] = preSum[i - 1] + nums[i - 1];
            int temp = preSum[i] - k;
            ans += map.getOrDefault(temp, 0);
            map.put(preSum[i], map.getOrDefault(preSum[i], 0) + 1);
        }
        return ans;
    }

    public int subarraySum3(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int len = nums.length;
        int preSum = 0, ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 1; i <= len; i++) {
            preSum += nums[i - 1];
            int temp = preSum - k;
            ans += map.getOrDefault(temp, 0);
            map.put(preSum, map.getOrDefault(preSum, 0) + 1);
        }
        return ans;
    }
}
