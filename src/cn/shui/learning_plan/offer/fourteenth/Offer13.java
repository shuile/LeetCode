package cn.shui.learning_plan.offer.fourteenth;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author shui.
 * @date 2021/10/15.
 * @time 10:55.
 */
public class Offer13 {

    public static void main(String[] args) {
        Offer13 test = new Offer13();
        test.movingCount(11, 8, 16);
    }

    public int movingCount(int m, int n, int k) {
        int[][] flag = new int[m][n];
        return help(flag, 0, 0, k);
    }

    private int help(int[][] flag, int i, int j, int k) {
        if (i < 0 || i > flag.length || j < 0 || j > flag[0].length || flag[i][j] == 1 || flag[i][j] == 2) {
            return 0;
        }
        int sum = 0, ti = i, tj = j;
        while (ti != 0) {
            sum += ti % 10;
            ti /= 10;
        }
        while (tj != 0) {
            sum += tj % 10;
            tj /= 10;
        }
        if (sum <= k) {
            flag[i][j] = 1;
            return 1 + help(flag, i - 1, j, k) + help(flag, i + 1, j, k) + help(flag, i, j - 1, k)
                    + help(flag, i, j + 1, k);
        } else {
            flag[i][j] = 2;
            return 0;
        }
    }

    // 深度优先搜索
    int m, n, k;
    boolean[][] visited;
    public int movingCount2(int m, int n, int k) {
        this.m = m;
        this.n = n;
        this.k = k;
        this.visited = new boolean[m][n];
        return dfs(0, 0, 0, 0);
    }

    private int dfs(int i, int j, int si, int sj) {
        if (i >= m || j >= n || k < si + sj || visited[i][j]) {
            return 0;
        }
        visited[i][j] = true;
        return 1 + dfs(i + 1, j, (i + 1) % 10 != 0 ? si + 1 : si - 8, sj) + dfs(i, j + 1, si, (j + 1) % 10 != 0 ? sj + 1 : sj - 8);
    }

    // 广度优先搜索
    public int movingCount3(int m, int n, int k) {
        boolean[][] visited = new boolean[m][n];
        int res = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0, 0, 0});
        while (queue.size() > 0) {
            int[] x = queue.poll();
            int i = x[0], j = x[1], si = x[2], sj = x[3];
            if (i >= m || j >= n || k < si + sj || visited[i][j]) {
                continue;
            }
            visited[i][j] = true;
            res++;
            queue.add(new int[]{i + 1, j, (i + 1) % 10 != 0 ? si + 1 : si - 8, sj});
            queue.add(new int[]{i, j + 1, si, (j + 1) % 10 != 0 ? sj + 1 : sj - 8});
        }
        return res;
    }
}
