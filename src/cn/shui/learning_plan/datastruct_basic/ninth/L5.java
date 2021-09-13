package cn.shui.learning_plan.datastruct_basic.ninth;

/**
 * @author shui.
 * @date 2021/9/10.
 * @time 23:41.
 * 最长回文子串
 */
public class L5 {

    public static void main(String[] args) {
        String s = "1234";
        System.out.println(s.substring(0, 0));
        System.out.println(s.substring(0, 1));
        System.out.println(s.substring(0, 4));

        L5 test = new L5();
        System.out.println(test.longestPalindrome1("bb"));
    }

    public String longestPalindrome1(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }
        String ans = "";
        int len = s.length();
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j <= len; j++) {
                StringBuilder sb = new StringBuilder(s.substring(i, j));
                if (sb.reverse().toString().equals(s.substring(i, j)) && ans.length() < sb.length()) {
                    ans = sb.toString();
                }
            }
        }
        return ans;
    }

    // 动态规划
    public String longestPalindrome2(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }
        int maxLen = 1;
        int begin = 0;
        // dp[i][j]表示s[i..j]是否是回文串
        boolean[][] dp = new boolean[len][len];
        // 初始化：所有长度为1的子串都是回文串
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }
        char[] charArray = s.toCharArray();
        // 递推开始
        // 先枚举子串长度
        for (int L = 2; L <= len; L++) {
            // 枚举左边界，左边界的上线设置可以宽松一些
            for (int i = 0; i < len; i++) {
                // 由L和i可以确定有边界，即j-i+1=L得
                int j = L + i - 1;
                // 如果有边界越界，皆可以退出当前循环
                if (j >= len) {
                    break;
                }
                if (charArray[i] != charArray[j]) {
                    dp[i][j] = false;
                } else {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
                // 只要dp[i][L] == true成立，就表示子串s[i..L]是回文，此时记录回文长度和起始位置
                if (dp[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }

    // 中心扩展算法
    public String longestPalindrome3(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len = Math.max(expandAroundCenter(s, i, i), expandAroundCenter(s, i, i + 1));
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }
}
