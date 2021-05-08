package cn.shui.offer;

import java.util.HashMap;
import java.util.Map;

public class Offer_48 {
    public static void main(String[] args) {

    }

    private int lengthOfLongestSubString(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int start = 0;
        int max = 1;
        for (int i = 1; i < s.length(); i++) {
            String sub1 = s.substring(start, i);
            String sub2 = s.substring(i, i + 1);
            if (sub1.contains(sub2)) {
                char ch = s.charAt(i);
                for (int j = 0; j < sub1.length(); j++) {
                    if (sub1.charAt(j) == ch) {
                        start += j + 1;
                        break;
                    }
                }
            }
            sub1 = s.substring(start, i + 1);
            max = Math.max(max, sub1.length());
        }
        return max;
    }

    /**
     * 动态规划+哈希表
     */
    private int lengthOfLongestSubString2(String s) {
        if (s == null  || s.length() == 0) {
            return 0;
        }
        Map<Character, Integer> dic = new HashMap<>();
        int res = 0, tmp = 0;
        for (int j = 0; j < s.length(); j++) {
            int i = dic.getOrDefault(s.charAt(j), - 1);
            dic.put(s.charAt(j), j);
            tmp = tmp < j - i ? tmp + 1 : j - i;
            res = Math.max(res, tmp);
        }
        return res;
    }

    /**
     * 动态规划+线性遍历
     */
    private int lengthOfLongestSubString3(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int res = 0, tmp = 0;
        for (int j = 0; j < s.length(); j++) {
            int i = j - 1;
            while (i >= 0 && s.charAt(i) != s.charAt(j)) {
                i--;
            }
            tmp = tmp > j - i ? tmp + 1 : j - i;
            res = Math.max(res, tmp);
        }
        return res;
    }

    /**
     * 双指针+哈希表
     */
    private int lengthOfLongestSubString4(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        Map<Character, Integer> dic = new HashMap<>();
        int i = -1, res = 0;
        for (int j = 0; j < s.length(); j++) {
            if (dic.containsKey(s.charAt(j))) {
                i = Math.max(i, dic.get(s.charAt(j)));
            }
            dic.put(s.charAt(j), j);
            res = Math.max(res, j - i);
        }
        return res;
    }
}
