package cn.shui.order;

import java.util.HashMap;
import java.util.Map;

/**
 * @author shui.
 * @date 2021/11/5.
 * @time 08:54.
 * 最长定差子序列
 */
public class L1218 {

    // 超出时间限制
    public int longestSubsequence(int[] arr, int difference) {
        if (arr == null || arr.length < 1) {
            return 0;
        }
        int ans = 1, len = arr.length;
        boolean[] flag = new boolean[len];
        for (int i = 0; i < len; i++) {
            if (flag[i]) {
                continue;
            }
            flag[i] = true;
            int count = 1, start = arr[i];
            for (int j = i + 1; j < len; j++) {
                if (arr[j] == (start + difference)) {
                    flag[j] = true;
                    count++;
                    start = arr[j];
                }
            }
            ans = Math.max(ans, count);
        }
        return ans;
    }

    // 动态规划
    public int longestSubsequence2(int[] arr, int difference) {
        int ans = 0;
        Map<Integer, Integer> dp = new HashMap<>();
        for (int v : arr) {
            dp.put(v, dp.getOrDefault(v - difference, 0) + 1);
            ans = Math.max(ans, dp.get(v));
        }
        return ans;
    }
}
