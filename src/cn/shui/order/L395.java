package cn.shui.order;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by chenyiting on 2025/3/4
 * Longest Substring with At Least K Repeating Characters
 */
public class L395 {
//    public int longestSubstring(String s, int k) {
//        if (s == null || s.length() < k) {
//            return 0;
//        }
//        int len = s.length();
//        int[] words = new int[26];
//        char ch;
//        Set<Character> set = new HashSet<>();
//        for (int i = 0; i < len; i++) {
//            ch = s.charAt(i);
//            words[ch - 'a']++;
//            if (words[ch - 'a'] >= k) {
//                set.add(ch);
//            }
//        }
//        int subLen = 0;
//        int curLen = 0;
//        for (int i = 0; i < len; i++) {
//            ch = s.charAt(i);
//            if (set.contains(ch)) {
//                curLen++;
//            } else {
//                subLen = Math.max(subLen, curLen);
//                curLen = 0;
//            }
//        }
//        return Math.max(subLen, curLen);
//    }

    /**
     * 分治
     *
     * @param s
     * @param k
     * @return
     */
    public int longestSubstring(String s, int k) {
        if (s == null || s.length() < k) {
            return 0;
        }
        return dfs(s, 0, s.length() - 1, k);
    }

    private int dfs(String s, int l, int r, int k) {
        int[] cnt = new int[26];
        for (int i = l; i <= r; i++) {
            cnt[s.charAt(i) - 'a']++;
        }
        char split = 0;
        for (int i = 0; i < 26; i++) {
            if (cnt[i] > 0 && cnt[i] < k) {
                split = (char) (i + 'a');
                break;
            }
        }
        if (split == 0) {
            return r - l + 1;
        }
        int i = l;
        int ret = 0;
        while (i <= r) {
            while (i <= r && s.charAt(i) == split) {
                i++;
            }
            if (i > r) {
                break;
            }
            int start = i;
            while (i <= r && s.charAt(i) != split) {
                i++;
            }

            ret = Math.max(ret, dfs(s, start, i - 1, k));
        }
        return ret;
    }

    public static void main(String[] args) {
        L395 test = new L395();
        test.longestSubstring("ababacb", 3);
    }
}
