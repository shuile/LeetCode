package cn.shui.learning_plan.offerII;

import java.util.HashMap;
import java.util.Map;

/**
 * @author shui.
 * @date 2021/12/9.
 * @time 17:36.
 * 不含重复字符的最长字符串
 */
public class Offer016 {

    public static void main(String[] args) {
        Offer016 test = new Offer016();
        System.out.println(test.lengthOgLongestSubstring("abba"));
    }

    public int lengthOgLongestSubstring(String s) {
        int len = s.length();
        if (len < 2) {
            return len;
        }
        Map<Character, Integer> map = new HashMap<>();
        int ans = 0, start = 0;
        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);
            if (map.containsKey(ch)) {
                int lastIndex = map.get(ch);
                if (lastIndex + 1 > start) {
                    start = lastIndex + 1;
                }
            }
            map.put(ch, i);
            ans = Math.max(ans, i - start + 1);
        }
        return ans;
    }
}
