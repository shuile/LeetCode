package cn.shui.learning_plan.offerII;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author shui.
 * @date 2021/12/2.
 * @time 17:06.
 * 单词长度的最大乘积
 */
public class Offer005 {
    public int maxProduct(String[] words) {
        int max = 0;
        for (int i = 0; i < words.length - 1; i++) {
            Set<Character> set = new HashSet<>();
            for (char c : words[i].toCharArray()) {
                set.add(c);
            }
            for (int j = i + 1; j < words.length; j++) {
                if (!isRepeat(set, words[j])) {
                    max = Math.max(max, words[i].length() * words[j].length());
                }
            }
        }
        return max;
    }

    private boolean isRepeat(Set<Character> set, String s) {
        for (char c : s.toCharArray()) {
            if (set.contains(c)) {
                return true;
            }
        }
        return false;
    }

    // 位运算优化
    public int maxProduct2(String[] words) {
        Map<Integer, Integer> map = new HashMap<>();
        int len = words.length;
        for (int i = 0; i < len; i++) {
            int bitMask = 0;
            for (char c : words[i].toCharArray()) {
                bitMask |= (1 << (c - 'a'));
            }
            map.put(bitMask, Math.max(map.getOrDefault(bitMask, 0), words[i].length()));
        }
        int ans = 0;
        for (int x : map.keySet()) {
            for (int y : map.keySet()) {
                if ((x & y) == 0) {
                    ans = Math.max(ans, map.get(x) * map.get(y));
                }
            }
        }
        return ans;
    }
}
