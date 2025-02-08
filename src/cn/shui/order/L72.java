package cn.shui.order;

import java.util.Arrays;

/**
 * Created by chenyiting on 2024/1/17
 */
public class L72 {

    // 超时
    public int minDistance(String word1, String word2) {
        if (word1 == null || word2 == null) {
            return 0;
        }
        int len1 = word1.length();
        int len2 = word2.length();
        if (len1 == 0) {
            return len2;
        }
        if (len2 == 0) {
            return len1;
        }
        int ans = Integer.MAX_VALUE;
        char c1 = word1.charAt(0), c2 = word2.charAt(0);

        // insert
        ans = Math.min(ans, minDistance(word1, word2.substring(1)) + 1);
        // delete
        ans = Math.min(ans, minDistance(word1.substring(1), word2) + 1);
        if (c1 == c2) {
            // 不操作
            ans = Math.min(ans, minDistance(word1.substring(1), word2.substring(1)));
        } else {
            // replace
            ans = Math.min(ans, minDistance(word1.substring(1), word2.substring(1)) + 1);
        }

        return ans;
    }

    // 超时
    public int minDistance2(String word1, String word2) {
        if (word1 == null || word2 == null) {
            return 0;
        }
        int len1 = word1.length();
        int len2 = word2.length();
        if (len1 == 0) {
            return len2;
        }
        if (len2 == 0) {
            return len1;
        }
        int ans = Integer.MAX_VALUE;
        char c1 = word1.charAt(0), c2 = word2.charAt(0);
        int diff = len2 - len1;
        if (diff > 0) {
            // insert
            ans = Math.min(ans, minDistance(word1, word2.substring(1)) + 1);
            if (c1 == c2) {
                // 不操作
                ans = Math.min(ans, minDistance(word1.substring(1), word2.substring(1)));
            } else {
                // replace
                ans = Math.min(ans, minDistance(word1.substring(1), word2.substring(1)) + 1);
            }
        } else if (diff == 0) {
            // insert
            ans = Math.min(ans, minDistance(word1, word2.substring(1)) + 1);
            // delete
            ans = Math.min(ans, minDistance(word1.substring(1), word2) + 1);
            if (c1 == c2) {
                // 不操作
                ans = Math.min(ans, minDistance(word1.substring(1), word2.substring(1)));
            } else {
                // replace
                ans = Math.min(ans, minDistance(word1.substring(1), word2.substring(1)) + 1);
            }
        } else {
            // delete
            ans = Math.min(ans, minDistance(word1.substring(1), word2) + 1);
            if (c1 == c2) {
                // 不操作
                ans = Math.min(ans, minDistance(word1.substring(1), word2.substring(1)));
            } else {
                // replace
                ans = Math.min(ans, minDistance(word1.substring(1), word2.substring(1)) + 1);
            }
        }

        return ans;
    }

    // 动态规划
    public int minDistance3(String word1, String word2) {
        int len1 = word1.length(), len2 = word2.length();
        if (len1 * len2 == 0) { // 有空串
            return len1 + len2;
        }

        int[][] dp = new int[len1 + 1][len2 + 1];

        // 边界初始化
        for (int i = 0; i <= len1; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= len2; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                int a = dp[i - 1][j] + 1;
                int b = dp[i][j - 1] + 1;
                int c = dp[i - 1][j - 1];
                if (word1.charAt(i - 1) != word2.charAt(j - 1)) {
                    c++;
                }
                dp[i][j] = Math.min(a, Math.min(b, c));
            }
        }
        return dp[len1][len2];
    }
}
