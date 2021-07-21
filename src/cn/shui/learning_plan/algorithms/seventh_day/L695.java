package cn.shui.learning_plan.algorithms.seventh_day;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author shui.
 * @date 2021/7/20.
 * @time 15:10.
 * 岛屿的最大面积
 */
public class L695 {
    // 深度优先搜索
    public int maxAreaOfIsland1(int[][] grid) {
        if (grid == null || grid.length < 1 || grid[0].length < 1) {
            return 0;
        }
        int ans = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                ans = Math.max(ans, dfs(grid, i, j));
            }
        }
        return ans;
    }

    private int[] dx = {0, 0, 1, -1};
    private int[] dy = {1, -1, 0, 0};

    private int dfs(int[][] grid, int x, int y) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] != 1) {
            return 0;
        }
        grid[x][y] = 0;
        int ans = 1;
        for (int i = 0; i < 4; i++) {
            int mx = x + dx[i], my = y + dy[i];
            ans += dfs(grid, mx, my);
        }
        return ans;
    }

    private int[] di = {0, 0, 1, -1};
    private int[] dj = {1, -1, 0, 0};

    // 深度优先搜索+栈
    public int maxAreaOfIsland2(int[][] grid) {
        if (grid == null || grid.length < 1 || grid[0].length < 1) {
            return 0;
        }
        int ans = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                int cur = 0;
                Deque<Integer> stacki = new LinkedList<>();
                Deque<Integer> stackj = new LinkedList<>();
                stacki.push(i);
                stackj.push(j);
                while (!stacki.isEmpty()) {
                    int cur_i = stacki.pop(), cur_j = stackj.pop();
                    if (cur_i < 0 || cur_i >= grid.length || cur_j < 0 || cur_j >= grid[0].length || grid[cur_i][cur_j] != 1) {
                        continue;
                    }
                    cur++;
                    grid[cur_i][cur_j] = 0;
                    for (int index = 0; index < 4; index++) {
                        int next_i = cur_i + di[index], next_j = cur_j + dj[index];
                        stacki.push(next_i);
                        stackj.push(next_j);
                    }
                }
                ans = Math.max(ans, cur);
            }
        }
        return ans;
    }

    // 广度优先搜索
    public int maxAreaOfIsland3(int[][] grid) {
        if (grid == null || grid.length < 1 || grid[0].length < 1) {
            return 0;
        }
        int ans = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                int cur = 0;
                Queue<Integer> queuei = new LinkedList<>();
                Queue<Integer> queuej = new LinkedList<>();
                queuei.offer(i);
                queuej.offer(j);
                while (!queuei.isEmpty()) {
                    int cur_i = queuei.poll(), cur_j = queuej.poll();
                    if (cur_i <0 || cur_i >= grid.length || cur_j < 0 || cur_j >= grid[0].length || grid[cur_i][cur_j] != 1) {
                        continue;
                    }
                    cur++;
                    grid[cur_i][cur_j] = 0;
                    for (int index = 0; index < 4; index++) {
                        int next_i = cur_i + di[index], next_j = cur_j + dj[index];
                        queuei.offer(next_i);
                        queuej.offer(next_j);
                    }
                }
                ans = Math.max(ans, cur);
            }
        }
        return ans;
    }
    }