package cn.shui.learning_plan.datastruct_basic.fifth;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author shui.
 * @date 2021/9/9.
 * @time 09:30.
 * 和为K的子数组
 */
public class L560 {

    public static void main(String[] args) {
        L560 test = new L560();
        System.out.println(test.subarraySum1(new int[]{1, -1, 0}, 0));
    }

    public int subarraySum1(int[] nums, int k) {
        if (nums == null || nums.length < 1) {
            return 0;
        }
        int len = nums.length;
        int ans = 0;
        for (int i = 0; i < len; i++) {
            int index = i + 1, sum = nums[i];
            while (index <= len) {
                if (sum == k) {
                    ans++;
                }
                if (index < len) {
                    sum += nums[index];
                }
                index++;
            }
        }
        return ans;
    }

    // 枚举
    public int subarraySum2(int[] nums, int k) {
        int count = 0;
        for (int start = 0; start < nums.length; start++) {
            int sum = 0;
            for (int end = start; end >= start; end--) {
                sum += nums[end];
                if (sum == k) {
                    count++;
                }
            }
        }
        return count;
    }

    // 前缀和+哈希表优化
    public int subarraySum3(int[] nums, int k) {
        int count = 0, pre = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            pre += nums[i];
            if (map.containsKey(pre - k)) {
                count += map.get(pre - k);
            }
            map.put(pre, map.getOrDefault(pre, 0) + 1);
        }
        return count;
    }
}
