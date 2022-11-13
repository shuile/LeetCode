package cn.shui.order;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by chenyiting on 2022/11/13
 * 自定义字符串排序
 */
public class L791 {
    public String customSortString(String order, String s) {
        if (order == null || order.length() < 1 || s == null || s.length() < 2) {
            return s;
        }
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < order.length(); i++) {
            map.put(order.charAt(i), i);
        }
        char[] chars = s.toCharArray();
        StringBuilder ans = new StringBuilder();
        for (char c : chars) {
            int index = map.getOrDefault(c, -1);
            if (index == -1) {
                ans.append(c);
            } else {
                int i = 0;
                for (; i < ans.length(); i++) {
                    int curr = map.getOrDefault(ans.charAt(i), -1);
                    if (curr >= index) {
                        ans.insert(i, c);
                        break;
                    }
                }
                if (i >= ans.length()) {
                    ans.append(c);
                }
            }
        }
        return ans.toString();
    }

    // 自定义排序
    public String customSortString2(String order, String s) {
        int[] val = new int[26];
        for (int i = 0; i < order.length(); i++) {
            val[order.charAt(i) - 'a'] = i + 1;
        }
        Character[] arr = new Character[s.length()];
        for (int i = 0; i < s.length(); i++) {
            arr[i] = s.charAt(i);
        }
        Arrays.sort(arr, Comparator.comparingInt(c -> val[c - 'a']));
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            ans.append(arr[i]);
        }
        return ans.toString();
    }

    // 计数排序
    public String customSortString3(String order, String s) {
        int[] freq = new int[26];
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < order.length(); i++) {
            char ch = order.charAt(i);
            while (freq[ch - 'a'] > 0) {
                ans.append(ch);
                freq[ch - 'a'] --;
            }
        }
        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0) {
                ans.append('a' + i);
                freq[i]--;
            }
        }
        return ans.toString();
    }
}
