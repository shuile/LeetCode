package cn.shui.order;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author shui.
 * @date 2021/11/10.
 * @time 10:01.
 * 分割回文串
 */
public class L131 {
    // 回溯 + 动态规划预处理
    boolean[][] f;
    List<List<String>> ret = new ArrayList<>();
    List<String> ans = new ArrayList<>();
    int n;

    public List<List<String>> partition(String s) {
        n = s.length();
        f = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(f[i], true);
        }

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                f[i][j] = (s.charAt(i) == s.charAt(j)) && f[i + 1][j - 1];
            }
        }

        dfs(s, 0);
        return ret;
    }

    public void dfs(String s, int i) {
        if (i == n) {
            ret.add(new ArrayList<>(ans));
            return;
        }
        for (int j = i; j < n; j++) {
            if (f[i][j]) {
                ans.add(s.substring(i, j + 1));
                dfs(s, j + 1);
                ans.remove(ans.size() - 1);
            }
        }
    }

    // 回溯 + 记忆化搜索
    int[][] f2;
    List<List<String>> ret2 = new ArrayList<>();
    List<String> ans2 = new ArrayList<>();

    public List<List<String>> partition2(String s) {
        n = s.length();
        f2 = new int[n][n];
        dfs2(s, 0);
        return ret;
    }

    private void dfs2(String s, int i) {
        if (i == n) {
            ret.add(new ArrayList<>(ans));
            return;
        }
        for (int j = i; j < n; j++) {
            if (isPalindrome(s, i, j) == 1) {
                ans.add(s.substring(i, j + 1));
                dfs(s, j + 1);
                ans.remove(ans.size() - 1);
            }
        }
    }

    // 记忆化搜索中，f[i][j] = 0 表示未搜索，1表示是回文串，-1表示不是回文串
    private int isPalindrome(String s, int i, int j) {
        if (f2[i][j] != 0) {
            return f2[i][j];
        }
        if (i >= j) {
            f2[i][j] = 1;
        } else if (s.charAt(i) == s.charAt(j)) {
            f2[i][j] = isPalindrome(s, i + 1, j - 1);
        } else {
            f2[i][j] = -1;
        }
        return f2[i][j];
    }
}
