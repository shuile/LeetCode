package cn.shui.order;

/**
 * Created by chenyiting on 2025/2/12
 * Find The Difference
 */
public class L389 {
    public char findTheDifference(String s, String t) {
        if (s.length() == 0) {
            return t.charAt(0);
        }
        int[] chs = new int[26];
        int len = s.length();
        for (int i = 0; i < len; i++) {
            chs[s.charAt(i) - 'a']++;
            chs[t.charAt(i) - 'a']--;
        }
        chs[t.charAt(len) - 'a']--;
        char ans = 'a';
        for (int i = 0; i < chs.length; i++) {
            if (chs[i] < 0) {
                ans += i;
                break;
            }
        }
        return ans;
    }

    /**
     * 计数
     * @param s
     * @param t
     * @return
     */
    public char findTheDifference2(String s, String t) {
        int[] cnt = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            cnt[ch - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            cnt[ch - 'a']--;
            if (cnt[ch - 'a'] < 0) {
                return ch;
            }
        }
        return ' ';
    }

    /**
     * 求和
     */
    public char findTheDifference3(String s, String t) {
        int as = 0, at = 0;
        for (int i = 0; i < s.length(); i++) {
            as += s.charAt(i);
        }
        for (int i = 0; i < t.length(); i++) {
            at += t.charAt(i);
        }
        return (char) (at - as);
    }

    /**
     * 位运算
     */
    public char findTheDifference4(String s, String t) {
        int ret = 0;
        for (char ch : s.toCharArray()) {
            ret ^= ch;
        }
        for (char ch : t.toCharArray()) {
            ret ^= ch;
        }
        return (char) ret;
    }
}
