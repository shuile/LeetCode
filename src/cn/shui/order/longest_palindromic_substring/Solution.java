package cn.shui.order.longest_palindromic_substring;

public class Solution {
    public static void main(String[] args) {
        String s1 = "ccc";
        System.out.println(longestPalindrome2(s1));

        String s2 = "ac";
        System.out.println(longestPalindrome2(s2));
    }

    public static String longestPalindrome2(String s) {
        if (s == null || s.length() < 1)
            return "";
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private static int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }

    /**
     * 方法1
     * @param s
     * @return
     */
    public static String longestPalindrome(String s) {
        String ans = "";
        if (s == null || s.length() == 0) {
            return ans;
        }
        for (int i = 0; i < s.length() - 1; i++) {
            for (int j = i + 1; j < s.length(); j++) {
                String temp = findTheLongest(s, i, j);
                if (temp.length() > ans.length()) {
                    ans = temp;
                }
            }
        }
        if (ans.length() == 0) {
            ans = s.substring(0, 1);
        }
        return ans;
    }

    public static String findTheLongest(String s, int start, int end) {
        int count = (end - start) / 2;
        while (count >= 0) {
            if (s.charAt(start + count) != s.charAt(end - count)) {
                break;
            }
            count--;
        }
        if (count < 0) {
            return s.substring(start, end + 1);
        }
        return "";
    }
}
