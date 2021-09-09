package cn.shui.learning_plan.datastruct_basic.seventh;

import java.util.HashMap;
import java.util.Map;

/**
 * @author shui.
 * @date 2021/9/9.
 * @time 10:25.
 * 单词规律
 */
public class L290 {
    public boolean wordPattern(String pattern, String s) {
        if (pattern == null || pattern.length() < 1 || s == null || s.length() < 1) {
            return false;
        }
        String[] split = s.split("//s+");
        int len = pattern.length();
        if (len != split.length) {
            return false;
        }
        Map<Character, String> map1 = new HashMap<>();
        Map<String, Character> map2 = new HashMap<>();
        for (int i = 0; i < len; i++) {
            char ch = pattern.charAt(i);
            if (map1.containsKey(ch) && !map1.get(ch).equals(split[i])) {
                return false;
            }
            if (map2.containsKey(split[i])) {
                if (map2.get(split[i]) == ch) {
                    continue;
                } else {
                    return false;
                }
            }
            map1.put(ch, split[i]);
            map2.put(split[i], ch);
        }
        return true;
    }
}
