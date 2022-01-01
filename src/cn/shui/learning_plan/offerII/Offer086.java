package cn.shui.learning_plan.offerII;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shui.
 * @date 2021/12/30.
 * @time 11:40.
 * 分割回文字符串
 */
public class Offer086 {
    public String[][] partition(String s) {
        int n = s.length();
        char[] arr = s.toCharArray();
        // 预处理
        boolean[][] dp = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][i] = true;
            }
        }
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                dp[i][j] = (arr[i] == arr[j]) && dp[i + 1][j - 1];
            }
        }
        List<List<String>> res = new ArrayList<>();
        List<String> path = new ArrayList<>();
        dfs(res, path, s, n, dp, 0);
        // List<List<String>>转String[][]
        String[][] ans = new String[res.size()][];
        for (int i = 0; i < res.size(); i++) {
            ans[i] = new String[res.get(i).size()];
            for (int j = 0; j < ans[i].length; j++) {
                ans[i][j] = res.get(i).get(j);
            }
        }
        return ans;
    }

    private void dfs(List<List<String>> res, List<String> path, String s, int n, boolean[][] dp, int pos) {
        if (pos == n) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = pos; i < n; i++) {
            // s[pos:i] （闭区间）是一个回文，所以递归搜索s[i+1, s.length() - 1]
            if (dp[pos][i]) {
                path.add(s.substring(pos, i + 1));
                dfs(res, path, s, n, dp, i + 1);
                path.remove(path.size() - 1);
            }
        }
    }
}
