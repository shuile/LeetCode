package cn.shui.codetop.client;

import java.util.Stack;

/**
 * Created by chenyiting on 2022/6/9
 * 最长有效括号
 */
public class L32 {
    public int longestValidParentheses(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        int len = s.length();
        int[] dp = new int[len + 1];
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
                dp[i + 1] = 0;
            } else {
                if (stack.isEmpty()) {
                    dp[i + 1] = 0;
                } else {
                    int leftIndex = stack.pop();
                    dp[i + 1] = 1 + i - leftIndex + dp[leftIndex];
                }
            }
        }
        int ans = 0;
        for (int i = 0; i <= len; i++) {
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}
