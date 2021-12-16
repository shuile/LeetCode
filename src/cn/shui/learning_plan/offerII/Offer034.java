package cn.shui.learning_plan.offerII;

import java.util.HashMap;
import java.util.Map;

/**
 * @author shui.
 * @date 2021/12/16.
 * @time 15:35.
 * 外星语言是否排序
 */
public class Offer034 {
    private Map<Character, Integer> map = new HashMap<>();

    public boolean isAlienSorted(String[] words, String order) {
        for (int i = 0; i < order.length(); i++) {
            map.put(order.charAt(i), i);
        }
        int len = words.length;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (!isSorted(words[i], words[j])) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isSorted(String s, String t) {
        if (s.equals(t)) {
            return true;
        }
        int len = Math.min(s.length(), t.length());
        for (int i = 0; i < len; i++) {
            int index1 = map.get(s.charAt(i)), index2 = map.get(t.charAt(i));
            if (index1 == index2) {
                continue;
            }
            return index1 < index2;
        }
        return s.length() < t.length();
    }

    // 非HashMap
    public boolean isAlienSorted2(String[] words, String order) {
        for (int i = 0; i < words.length - 1; i++) {
            if (!compare(words[i], words[i + 1], order)) {
                return false;
            }
        }
        return true;
    }

    private boolean compare(String f, String l, String order) {
        if (f.equals(l)) {
            return true;
        }
        int len = Math.min(f.length(), l.length());
        for (int i = 0; i < len; i++) {
            if (f.charAt(i) == l.charAt(i)) {
                continue;
            }
            for (int j = 0; j < order.length(); j++) {
                if (order.charAt(j) == f.charAt(i) || order.charAt(j) == l.charAt(i)) {
                    return f.charAt(i) == order.charAt(j);
                }
            }
        }
        return f.length() < l.length();
    }
}
