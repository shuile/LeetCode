package cn.shui.learning_plan.offerII;

import java.util.Arrays;

/**
 * @author shui.
 * @date 2021/12/8.
 * @time 15:20.
 * 字符串中的变位词
 */
public class Offer014 {

    public static void main(String[] args) {
        Offer014 test = new Offer014();
        System.out.println(test.checkInclusion2("ab", "eidbaooo"));
    }

    // 滑动窗口
    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length(), m  =s2.length();
        if (n > m) {
            return false;
        }
        int[] cnt1 = new int[26];
        int[] cnt2 = new int[26];
        for (int i = 0; i < n; i++) {
            cnt1[s1.charAt(i) - 'a']++;
            cnt2[s2.charAt(i) - 'a']++;
        }
        if (Arrays.equals(cnt1, cnt2)) {
            return true;
        }
        for (int i = n; i < m; i++) {
            cnt2[s2.charAt(i) - 'a']++;
            cnt2[s2.charAt(i - n) - 'a']--;
            if (Arrays.equals(cnt1, cnt2)) {
                return true;
            }
        }
        return false;
    }

    // 优化滑动窗口
    public boolean checkInclusion2(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        if (n > m) {
            return false;
        }
        int[] cnt = new int[26];
        for (int i = 0; i < n; i++) {
            cnt[s1.charAt(i) - 'a']--;
            cnt[s2.charAt(i) - 'a']++;
        }
        int diff = 0;
        for (int c : cnt) {
            if (c != 0) {
                diff++;
            }
        }
        if (diff == 0) {
            return true;
        }
        for (int i = n; i < m; i++) {
            int x = s2.charAt(i) - 'a', y = s2.charAt(i - n) - 'a';
            if (x == y) {
                continue;
            }
            if (cnt[x] == 0) {
                diff++;
            }
            cnt[x]++;
            if (cnt[x] == 0) {
                diff--;
            }
            if (cnt[y] == 0) {
                diff++;
            }
            cnt[y]--;
            if (cnt[y] == 0) {
                diff--;
            }
            if (diff == 0) {
                return true;
            }
        }
        return false;
    }

    // 双指针
    public boolean checkInclusion3(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        if (n > m) {
            return false;
        }
        int[] cnt = new int[26];
        for (int i = 0; i < n; i++) {
            cnt[s1.charAt(i) - 'a']--;
        }
        int left = 0;
        for (int right = 0; right < m; right++) {
            int x = s2.charAt(right) - 'a';
            cnt[x]++;
            while (cnt[x] > 0) {
                cnt[s2.charAt(left) - 'a']--;
                left++;
            }
            if (right - left + 1 == n) {
                return true;
            }
        }
        return false;
    }
}
