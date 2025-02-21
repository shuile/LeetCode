package cn.shui.order;

/**
 * Created by chenyiting on 2025/2/21
 * 判断子序列
 */
public class L392 {
    public boolean isSubsequence(String s, String t) {
        if (s == null || t == null || s.length() > t.length()) {
            return false;
        }
        int sLen = s.length();
        int tLen = t.length();
        int pos = 0;
        for (int i = 0; i < tLen; i++) {
            if (pos >= sLen) {
                break;
            }
            if (s.charAt(pos) == t.charAt(i)) {
                pos++;
            }
        }
        return pos >= sLen;
    }

    /**
     * 动态规划
     */
    public boolean isSubsequence2(String s, String t) {
        int n = s.length(), m = t.length();
        int[][] f = new int[m + 1][26];
        for (int i = 0; i < 26; i++) {
            f[m][i] = m;
        }
        for (int i = m - 1; i >= 0; i--) {
            for (int j = 0; j < 26; j++) {
                if (t.charAt(i) == j + 'a') {
                    f[i][j] = i;
                } else {
                    f[i][j] = f[i + 1][j];
                }
            }
        }
        int add = 0;
        for (int i = 0; i < n; i++) {
            if (f[add][s.charAt(i) - 'a'] == m) {
                return false;
            }
            add = f[add][s.charAt(i) - 'a'] + 1;
        }
        return true;
    }

    public static void main(String[] args) {
        L392 test = new L392();
        test.isSubsequence2("abc", "ahbgdc");
    }
}
