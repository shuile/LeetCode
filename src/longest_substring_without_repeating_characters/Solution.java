package longest_substring_without_repeating_characters;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        String s = "aabaab!bb";
        System.out.println(lengthOfLongestSubstring(s));

        String s1 = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s1));

        String s2 = "bbbbb";
        System.out.println(lengthOfLongestSubstring(s2));

        String s3 = "pwwkew";
        System.out.println(lengthOfLongestSubstring(s3));

        String s4 = "dvdf";
        System.out.println(lengthOfLongestSubstring(s4));

        String s5 = "aab";
        System.out.println(lengthOfLongestSubstring(s5));
    }

    public static int lengthOfLongestSubstring2(String s) {
        int n = s.length();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j<= n; j++) {
                if (allUnique(s, i, j)) {
                    ans = Math.max(ans, j - i);
                }
            }
        }
        return ans;
    }

    public static boolean allUnique(String s, int start, int end) {
        Set<Character> set = new HashSet<>();
        for (int i = start; i < end; i++) {
            Character ch = s.charAt(i);
            if (set.contains(ch)) {
                return false;
            }
            set.add(ch);
        }
        return true;
    }

    /**
     * 方法1
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        char[] sCh = s.toCharArray();
        String temp = "" + sCh[0];
        int length = 1;
        int max = 1;
        int i = 1;
        while (i < sCh.length) {
            if (!temp.contains("" + sCh[i])) {
                length++;
                if (length > max) {
                    max = length;
                }
                temp += sCh[i];
            } else {
                char[] tempCh = temp.toCharArray();
                int j = 0;
                for ( ; j < tempCh.length; j++) {
                    if (tempCh[j] == sCh[i]) {
                        j++;
                        break;
                    }
                }
                temp = "";
                for ( ; j < tempCh.length; j++) {
                    temp += tempCh[j];
                }
                temp += sCh[i];
                length = temp.length();
            }
            i++;
        }
        return max;
    }
}
