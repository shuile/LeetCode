package cn.shui.order;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author shui.
 * @date 2022/2/9.
 * @time 10:59.
 */
public class L2006 {
    public int countKDifference(int[] nums, int k) {
        Arrays.sort(nums);
        int ans = 0;
        int len = nums.length;
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                int diff = nums[j] - nums[i];
                if (diff > k) {
                    break;
                }
                if (diff == k) {
                    ans++;
                }
            }
        }
        return ans;
    }

    // 哈希表 + 一次遍历
    public int countKDifference2(int[] nums, int k) {
        int res = 0, n = nums.length;
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int num : nums) {
            res += cnt.getOrDefault(num - k, 0) + cnt.getOrDefault(num + k, 0);
            cnt.put(num, cnt.getOrDefault(num, 0) + 1);
        }
        return res;
    }
}
