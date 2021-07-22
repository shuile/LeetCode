package cn.shui.learning_plan.algorithms.ninth;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author shui.
 * @date 2021/7/22.
 * @time 09:25.
 * 01矩阵
 */
public class L542 {

    static int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    // 广度优先搜索
    private static int[][] updateMatrix1(int[][] mat) {
        if (mat == null || mat.length < 1 || mat[0].length < 1) {
            return mat;
        }
        int row = mat.length, column = mat[0].length;
        int[][] dist = new int[row][column];
        boolean[][] seen = new boolean[row][column];
        Queue<int[]> queue = new LinkedList<>();
        // 将所有的0天假进初始队列中
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (mat[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                    seen[i][j] = true;
                }
            }
        }

        // 广度优先搜索
        while (!queue.isEmpty()) {
            int[] cel = queue.poll();
            int i = cel[0], j = cel[1];
            for (int d = 0; d < 4; d++) {
                int ni = i + dirs[d][0];
                int nj = j + dirs[d][1];
                if (ni >= 0 && ni < row && nj >= 0 && nj < column && !seen[ni][nj]) {
                    dist[ni][nj] = dist[i][j] + 1;
                    queue.offer(new int[]{ni, nj});
                    seen[ni][nj] = true;
                }
            }
        }
        return dist;
    }

    // 动态规划
    private int[][] updateMatrix2(int[][] mat) {
        if (mat == null || mat.length < 1 || mat[0].length < 1) {
            return mat;
        }
        int row = mat.length, column = mat[0].length;
        // 初始化动态规划的数组，所有的距离值都设置为一个很大数
        int[][] dist = new int[row][column];
        for (int i = 0; i < row; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE / 2);
        }
        // 如果（i， j）的元素为0，那么距离为0
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (mat[i][j] == 0) {
                    dist[i][j] = 0;
                }
            }
        }
        // 只有水平向左移动和竖直向上移动，注意动态规划的计算顺序
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (i - 1 >= 0) {
                    dist[i][j] = Math.min(dist[i][j], dist[i - 1][j] + 1);
                }
                if (j - 1 >= 0) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][j - 1] + 1);
                }
            }
        }
        // 只有水平向左移动和竖直向下移动，注意动态规划的计算顺序
        for (int i = row - 1; i >= 0; i--) {
            for (int j = 0; j < column; j++) {
                if (i + 1 < row) {
                    dist[i][j] = Math.min(dist[i][j], dist[i + 1][j] + 1);
                }
                if (j - 1 >= 0) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][j - 1] + 1);
                }
            }
        }
        // 只有水平向右和竖直向上移动，注意动态规划的计算顺序
        for (int i = 0; i < row; i++) {
            for (int j = column - 1; j >= 0; j--) {
                if (i - 1 >= 0) {
                    dist[i][j] = Math.min(dist[i][j], dist[i - 1][j] + 1);
                }
                if (j + 1 < column) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][j + 1] + 1);
                }
            }
        }
        // 只有水平向右和竖直向下移动，注意动态规划的计算顺序
        for (int i = row - 1; i >= 0; i--) {
            for (int j = column - 1; j >= 0; j--) {
                if (i + 1 < row) {
                    dist[i][j] = Math.min(dist[i][j], dist[i + 1][j] + 1);
                }
                if (j + 1 < column) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][j + 1] + 1);
                }
            }
        }
        return dist;
    }

    // 动态规划的常数优化
    // 保留水平向左竖直向上、水平向右竖直向下移动
    private int[][] updateMatrix3(int[][] mat) {
        if (mat == null || mat.length < 1 || mat[0].length < 1) {
            return mat;
        }
        int row = mat.length, column = mat[0].length;
        // 初始化动态规划的数组，所有的距离值都设置为一个很大数
        int[][] dist = new int[row][column];
        for (int i = 0; i < row; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE / 2);
        }
        // 如果（i， j）的元素为0，那么距离为0
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (mat[i][j] == 0) {
                    dist[i][j] = 0;
                }
            }
        }
        // 只有水平向左移动和竖直向上移动，注意动态规划的计算顺序
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (i - 1 >= 0) {
                    dist[i][j] = Math.min(dist[i][j], dist[i - 1][j] + 1);
                }
                if (j - 1 >= 0) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][j - 1] + 1);
                }
            }
        }
        // 只有水平向右和竖直向下移动，注意动态规划的计算顺序
        for (int i = row - 1; i >= 0; i--) {
            for (int j = column - 1; j >= 0; j--) {
                if (i + 1 < row) {
                    dist[i][j] = Math.min(dist[i][j], dist[i + 1][j] + 1);
                }
                if (j + 1 < column) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][j + 1] + 1);
                }
            }
        }
        return dist;
    }
}
