package cn.shui.offer;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Offer_50 {
    public static void main(String[] args) {

    }

    private char firstUniqChar(String s) {
        if (s == null || s.length() == 0) {
            return ' ';
        }
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (map.containsKey(ch)) {
                map.put(ch, -1);
            } else {
                map.put(ch, i);
            }
        }
        Map.Entry<Character, Integer> ans = null;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() == -1) {
                continue;
            }
            if (ans == null) {
                ans = entry;
                continue;
            }
            if (ans.getValue() > entry.getValue()) {
                ans = entry;
            }
        }
        return ans == null ? ' ' : ans.getKey();
    }

    private char firstUniqChar2(String s) {
        if (s == null || s.length() == 0) {
            return ' ';
        }
        Map<Character, Boolean> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, !map.containsKey(c));
        }
        for (char c : s.toCharArray()) {
            if (map.get(c)) {
                return c;
            }
        }
        return ' ';
    }

    private char firstUniqChar3(String s) {
        if (s == null || s.length() == 0) {
            return ' ';
        }
        Map<Character, Boolean> map = new LinkedHashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, !map.containsKey(c));
        }
        for (Map.Entry<Character, Boolean> entry : map.entrySet()) {
            if (entry.getValue()) {
                return entry.getKey();
            }
        }
        return ' ';
    }
}
