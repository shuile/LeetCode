package cn.shui.order;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author shui.
 * @date 2021/11/20.
 * @time 20:15.
 * 最长和谐子序列
 */
public class L594 {
    // 枚举
    public int findLHS(int[] nums) {
        Arrays.sort(nums);
        int begin = 0;
        int res = 0;
        for (int end = 0; end < nums.length; end++) {
            while (nums[end] - nums[begin] > 1) {
                begin++;
            }
            if (nums[end] - nums[begin] == 1) {
                res = Math.max(res, end - begin + 1);
            }
        }
        return res;
    }

    // 哈希表
    public int findLHS2(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (int key : map.keySet()) {
            if (map.containsKey(key + 1)) {
                res = Math.max(res, map.get(key) + map.get(key + 1));
            }
        }
        return res;
    }
}
