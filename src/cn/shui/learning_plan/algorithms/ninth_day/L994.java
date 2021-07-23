package cn.shui.learning_plan.algorithms.ninth_day;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

/**
 * @author shui.
 * @date 2021/7/22.
 * @time 22:24.
 * 腐烂的橘子
 */
public class L994 {
    private int[] dr = {-1, 0, 1, 0};
    private int[] dc = {0, -1, 0, 1};

    private int orangesRotting(int[][] grid) {
        if (grid == null || grid.length < 1 || grid[0].length < 1) {
            return -1;
        }
        int R = grid.length, C = grid[0].length;
        Queue<Integer> queue = new ArrayDeque<>();
        Map<Integer, Integer> depth = new HashMap<>();
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (grid[r][c] == 2) {
                    int code = r * C + c;
                    queue.add(code);
                    depth.put(code, 0);
                }
            }
        }
        int ans = 0;
        while (!queue.isEmpty()) {
            int code = queue.remove();
            int r = code / C, c = code % C;
            for (int k = 0; k < 4; k++) {
                int nr = r + dr[k], nc = c + dc[k];
                if (nr >= 0 && nr < R && nc >=0 && nc < C && grid[nr][nc] == 1) {
                    grid[nr][nc] = 2;
                    int ncode = nr * C + nc;
                    queue.add(ncode);
                    depth.put(ncode, depth.get(code) + 1);
                    ans = depth.get(ncode);
                }
            }
        }
        for (int[] row : grid) {
            for (int v : row) {
                if (v == 1) {
                    return -1;
                }
            }
        }
        return ans;
    }

}
