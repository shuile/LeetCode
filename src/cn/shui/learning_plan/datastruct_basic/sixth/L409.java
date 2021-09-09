package cn.shui.learning_plan.datastruct_basic.sixth;

import java.util.HashMap;
import java.util.Map;

/**
 * @author shui.
 * @date 2021/9/9.
 * @time 10:12.
 * 最长回文串
 */
public class L409 {
    public int longestPalindrome1(String s) {
        if (s == null || s.length() < 1) {
            return 0;
        }
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        boolean hasSingle = false;
        int ans = 0;
        for (int v : map.values()) {
            if (v % 2 == 1) {
                if (hasSingle) {
                    v--;
                } else {
                    hasSingle = true;
                }
            }
            ans += v;
        }
        return ans;
    }

    // 贪心
    public int longestPalindrome2(String s) {
        int[] count = new int[128];
        int len = s.length();
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            count[c]++;
        }
        int ans = 0;
        for (int v : count) {
            ans += v / 2 * 2;
            if (v % 2 == 1 && ans % 2 == 0) {
                ans++;
            }
        }
        return ans;
    }
}
