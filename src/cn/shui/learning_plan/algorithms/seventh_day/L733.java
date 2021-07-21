package cn.shui.learning_plan.algorithms.seventh_day;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author shui.
 * @date 2021/7/20.
 * @time 09:17.
 * 图像渲染
 */
public class L733 {

    public static void main(String[] args) {
//        int[][] image = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
//        int[][] image = {{0, 0, 0}, {0, 0, 0}};
        int[][] image = {{0, 0, 0}, {0, 1, 1}};
        int[][] ans = floodFill1(image, 1, 1, 1);
        for (int[] an : ans) {
            System.out.println(Arrays.toString(an));
        }
    }

    public static int[][] floodFill1(int[][] image, int sr, int sc, int newColor) {
        if (image == null || image.length < 1 || image[0].length < 1) {
            return image;
        }
        int row = image.length, column = image[0].length;
        int[][] ans = new int[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                ans[i][j] = -1;
            }
        }
        BFS(image, sr, sc, image[sr][sc], newColor, ans);
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (ans[i][j] != -1) {
                    continue;
                }
                ans[i][j] = image[i][j];
            }
        }
        return ans;
    }

    private static void BFS(int[][] image, int sr, int sc, int rootColor, int newColor, int[][] ans) {
        if (sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length || image[sr][sc] != rootColor) {
            return;
        }
        ans[sr][sc] = newColor;
        BFS(image, sr - 1, sc, rootColor, newColor, ans);
        BFS(image, sr + 1, sc, rootColor, newColor, ans);
        BFS(image, sr, sc - 1, rootColor, newColor, ans);
        BFS(image, sr, sc + 1, rootColor, newColor, ans);
    }

    private int[] dx = {1, 0, 0, -1};
    private int[] dy = {0, 1, -1, 0};

    // 广度优先搜索
    private int[][] floodFill2(int[][] image, int sr, int sc, int newColor) {
        int currColor = image[sr][sc];
        if (currColor == newColor) {
            return image;
        }
        int row = image.length, column = image[0].length;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{sr, sc});
        image[sr][sc] = newColor;
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int x = cell[0], y = cell[1];
            for (int i = 0; i < 4; i++) {
                int mx = x + dx[i], my = y + dy[i];
                if (mx >= 0 && mx < row && my >= 0 && my < column && image[mx][my] == currColor) {
                    queue.offer(new int[]{mx, my});
                    image[mx][my] = newColor;
                }
            }
        }
        return image;
    }

    private int[][] floodFill3(int[][] image, int sr, int sc, int newColor) {
        int currColor = image[sr][sc];
        if (currColor != newColor) {
            dfs(image, sr, sc, currColor, newColor);
        }
        return image;
    }

    private void dfs(int[][] image, int x, int y, int color, int newColor) {
        if (image[x][y] == color) {
            image[x][y] = newColor;
            for (int i = 0; i < 4; i++) {
                int mx = x + dx[i], my = y + dy[i];
                if (mx >= 0 && mx < image.length && my >= 0 && my < image[0].length) {
                    dfs(image, mx, my, color, newColor);
                }
            }
        }
    }
}
