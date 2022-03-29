package cn.shui.codetop.client;

/**
 * Created by chenyiting on 2022/3/28
 * 最长回文串
 */
public class L5 {
    public String longestPalindrome(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }
        int len = s.length();
        String ans = "";
        for (int i = 0; i < len - 1; i++) {
            String temp = help(s, i, true);
            if (ans.length() < temp.length()) {
                ans = temp;
            }
            temp = help(s, i, false);
            if (ans.length() < temp.length()) {
                ans = temp;
            }
        }
        return ans;
    }

    private String help(String s, int start, boolean isSingleCenter) {
        int len = s.length();
        int end = start;
        if (!isSingleCenter) {
            end++;
            if (end >= len || s.charAt(start) != s.charAt(end)) {
                return "";
            }
        }
        while (start > 0 && end < len - 1) {
            if (s.charAt(start - 1) != s.charAt(end + 1)) {
                break;
            }
            start--;
            end++;
        }
        return s.substring(start, end + 1);
    }
}
