package cn.shui.learning_plan.offerII;

/**
 * @author shui.
 * @date 2022/1/4.
 * @time 13:29.
 * 翻转字符
 */
public class Offer092 {
    // 空间复杂度O(n)
    public int minFlipsMonoIncr(String s) {
        int n = s.length();
        int[] zero = new int[n];
        int[] one = new int[n];
        zero[0] = s.charAt(0) == '0' ? 0 : 1;
        one[1] = s.charAt(0) == '0' ? 1 : 0;
        for (int i = 1; i < n; i++) {
            if (s.charAt(i) == '0') {
                zero[i] = zero[i - 1];
                one[i] = Math.min(zero[i - 1], one[i - 1]) + 1;
            } else {
                zero[i] = zero[i - 1] + 1;
                one[i] = Math.min(zero[i - 1], one[i - 1]);
            }
        }
        return Math.min(zero[n - 1], one[n - 1]);
    }

    // 空间复杂度O(1)
    public int minFlipsMonoIncr2(String s) {
        int n = s.length();
        int[][] dp = new int[2][2];
        dp[0][0] = s.charAt(0) == '0' ? 0 : 1;
        dp[0][1] = s.charAt(0) == '0' ? 1 : 0;
        for (int i = 1; i < n; i++) {
            dp[0][i % 2] = s.charAt(i) == '0' ? dp[0][(i - 1) % 2] : dp[0][(i - 1) % 2] + 1;
            dp[1][i % 2] = s.charAt(i) == '1' ? Math.min(dp[1][(i - 1) % 2], dp[0][(i - 1) % 2]) : Math.min(dp[1][(i - 1) % 2], dp[0][(i - 1) % 2]) + 1;
        }
        int last = (s.length() - 1) % 2;
        return Math.min(dp[0][last], dp[1][last]);
    }

    // 空间复杂度O(1)
    public int minFlipsMonoIncr3(String s) {
        int n = s.length();
        int one = 0, zero = 0;
        for (char c : s.toCharArray()) {
            if (c == '0') {
                one = Math.min(zero, one) + 1;
            } else {
                one = Math.min(zero, one);
                zero++;
            }
        }
        return Math.min(zero, one);
    }
}
