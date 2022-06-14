package cn.shui.codetop.client;

import java.util.Arrays;
import java.util.List;

/**
 * Created by chenyiting on 2022/6/9
 * 三角形最小路径和
 */
public class L120 {

    private int ans = Integer.MAX_VALUE;
    private List<List<Integer>> triangle;

    // 超时
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) {
            return 0;
        }
        this.triangle = triangle;
        travers(0, 0, Integer.MAX_VALUE);
        return ans;
    }

    private void travers(int level, int parentPosition, int curr) {
        if (level >= triangle.size()) {
            ans = Math.min(ans, curr);
            return;
        }
        if (curr == Integer.MAX_VALUE) {
            curr = 0;
        }
        curr += triangle.get(level).get(parentPosition);
        level++;
        travers(level, parentPosition, curr);
        travers(level, parentPosition + 1, curr);
    }

    // 动态规划
    public int minimumTotal2(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) {
            return 0;
        }
        int size = triangle.size();
        int[][] dp = new int[size][size];
        for (int i = 0; i < size; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        dp[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < size; i++) {
            List<Integer> row = triangle.get(i);
            for (int j = 0; j < row.size(); j++) {
                if (j == 0) {
                    dp[i][j] = dp[i - 1][j] + row.get(j);
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j - 1]) + row.get(j);
                }
            }
        }
        int ans = Integer.MAX_VALUE;
        for (int j = 0; j < size; j++) {
            ans = Math.min(ans, dp[size - 1][j]);
        }
        return ans;
    }
}
