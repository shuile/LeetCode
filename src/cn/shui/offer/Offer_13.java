package cn.shui.offer;

import java.util.Deque;
import java.util.LinkedList;

public class Offer_13 {
    public static void main(String[] args) {
        int m = 3, n = 2, k = 17;
        Offer_13 test = new Offer_13();
        System.out.println(test.movingCount(m, n, k));
    }

    public int movingCount(int m, int n, int k) {
        return dfs(new boolean[m][n], k, 0, 0);
    }

    private int dfs(boolean[][] dp, int k, int i, int j) {
        if (i < 0 || i >= dp.length || j < 0 || j >= dp[0].length) {
            return 0;
        }
        int sum = 0, tI = i, tJ = j;
        while (tI != 0 || tJ != 0) {
            sum += tI == 0 ? 0 : tI % 10;
            sum += tJ == 0 ? 0 : tJ % 10;
            tI /= 10;
            tJ /= 10;
        }
        if (sum > k) {
            return 0;
        }
        dp[i][j] = true;
        int count = 1;
        if (i - 1 >= 0 && !dp[i - 1][j]) {
            count += dfs(dp, k, i - 1, j);
        }
        if (i < dp.length - 1 && !dp[i + 1][j]) {
            count += dfs(dp, k, i + 1, j);
        }
        if (j - 1 >= 0 && !dp[i][j - 1]) {
            count += dfs(dp, k, i, j - 1);
        }
        if (j < dp[0].length - 1 && !dp[i][j + 1]) {
            count += dfs(dp, k, i, j + 1);
        }
        return count;
    }

    private int movingCount1(int m, int n, int k) {
        if (k == 0) {
            return 1;
        }
        Deque<int[]> queue = new LinkedList<>();
        int[] dx = {0, 1};
        int[] dy = {1, 0};
        boolean[][] valid = new boolean[m][n];
        queue.offer(new int[]{0, 0});
        valid[0][0] = true;
        int ans = 1;
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int x = cell[0], y = cell[1];
            for (int i = 0; i < 2; i++) {
                int tx = dx[i] + x;
                int ty = dy[i] + y;
                if (tx < 0 || tx >= m || ty < 0 || ty >= n || valid[tx][ty] || get(tx) + get(ty) > k) {
                    continue;
                }
                queue.offer(new int[]{tx, ty});
                ans++;
                valid[tx][ty] = true;
            }
        }
        return ans;
    }

    private int get(int num) {
        int sum = 0;
        while (num != 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }

    private int movingCount2(int m, int n, int k) {
        if (k == 0) {
            return 1;
        }
        boolean[][] valid = new boolean[m][n];
        int ans = 1;
        valid[0][0] = true;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if ((i == 0 && j == 0) || get(i) + get(j) > k) {
                    continue;
                }
                if (i - 1 >= 0) {
                    valid[i][j] |= valid[i - 1][j];
                }
                if (j - 1 >= 0) {
                    valid[i][j] |= valid[i][j - 1];
                }
                ans += valid[i][j] ? 1 : 0;
            }
        }
        return ans;
    }
}
