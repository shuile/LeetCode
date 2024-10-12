package cn.shui.order;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by chenyiting on 2024/10/11
 */
public class L3164 {
    // 超时
    public long numberOfPairs(int[] nums1, int[] nums2, int k) {
        long ans = 0;
        for (int n : nums1) {
            for (int m : nums2) {
                if (n % (m * k) == 0) {
                    ans++;
                }
            }
        }
        return ans;
    }

    public long numberOfPairs2(int[] nums1, int[] nums2, int k) {
        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();
        int max1 = 0;
        for (int n : nums1) {
            map1.put(n, map1.getOrDefault(n, 0) + 1);
            max1 = Math.max(max1, n);
        }
        for (int m : nums2) {
            map2.put(m, map2.getOrDefault(m, 0) + 1);
        }
        long ans = 0;
        for (int m : map2.keySet()) {
            for (int n = m * k; n <= max1; n += m * k) {
                if (map1.containsKey(n)) {
                    ans += 1L * map1.get(n) * map2.get(m);
                }
            }
        }
        return ans;
    }
}
