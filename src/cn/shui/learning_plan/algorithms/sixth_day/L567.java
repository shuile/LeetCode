package cn.shui.learning_plan.algorithms.sixth_day;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author shui.
 * @date 2021/7/19.
 * @time 16:01.
 * 字符串的排列
 */
public class L567 {
    public boolean checkInclusion1(String s1, String s2) {
        if (s1 == null || s1.length() < 1) {
            return true;
        }
        int len1 = s1.length(), len2 = s2.length();
        if (len1 > len2) {
            return false;
        }
        Map<Character, Integer> map1 = getMap(s1);
        for (int i = 0; i < len2 - len1; i++) {
            if (map1.equals(getMap(s2.substring(i, i + len1)))) {
                return true;
            }
        }
        return false;
    }

    private Map<Character, Integer> getMap(String s) {
        if (s == null || s.length() < 1) {
            return null;
        }
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        return map;
    }

    // 滑动窗口
    private boolean clearInclusion2(String s1, String s2) {
        if (s1 == null || s2.length() < 1) {
            return true;
        }
        int len1 = s1.length(), len2 = s2.length();
        if (len1 > len2) {
            return false;
        }
        int[] arr1 = new int[26];
        int[] arr2 = new int[26];
        for (int i = 0; i < len1; i++) {
            arr1[s1.charAt(i) - 'a']++;
            arr2[s2.charAt(i) - 'a']++;
        }
        if (Arrays.equals(arr1, arr2)) {
            return true;
        }
        for (int i = len1; i < len2; i++) {
            arr2[s2.charAt(i) - 'a']++;
            arr2[s2.charAt(i - len1) - 'a']--;
            if (Arrays.equals(arr1, arr2)) {
                return true;
            }
        }
        return false;
    }

    // 滑动窗口优化
    public boolean checkInclusion3(String s1, String s2) {
        if (s1 == null || s1.length() < 1) {
            return true;
        }
        int len1 = s1.length(), len2 = s2.length();
        if (len1 > len2) {
            return false;
        }
        int[] arr = new int[26];
        for (int i = 0; i < len1; i++) {
            arr[s1.charAt(i) - 'a']--;
            arr[s2.charAt(i) - 'a']++;
        }
        int diff = 0;
        for (int i : arr) {
            if (i != 0) {
                diff++;
            }
        }
        if (diff == 0) {
            return true;
        }
        for (int i = len1; i < len2; i++) {
            int x = s2.charAt(i) - 'a', y = s2.charAt(i - len1) - 'a';
            if (x == y) {
                continue;
            }
            if (arr[x] == 0) {
                diff++;
            }
            arr[x]++;
            if (arr[x] == 0) {
                diff--;
            }
            if (arr[y] == 0) {
                diff++;
            }
            arr[y]--;
            if (arr[y] == 0) {
                diff--;
            }
            if (diff == 0) {
                return true;
            }
        }
        return false;
    }

    private boolean checkInclusion4(String s1, String s2) {
        if (s1 == null || s2.length() < 1) {
            return true;
        }
        int len1 = s1.length(), len2 = s2.length();
        if (len1 > len2) {
            return false;
        }
        int [] arr = new int[26];
        for (int i = 0; i < len1; i++) {
            arr[s1.charAt(i) - 'a']--;
        }
        int left = 0;
        for (int right = 0; right < len2; right++) {
            int x = s2.charAt(right) - 'a';
            arr[x]++;
            while (arr[x] > 0) {
                arr[s2.charAt(left) - 'a']--;
                left++;
            }
            if (right - left + 1 == len1) {
                return true;
            }
        }
        return false;
    }
}
