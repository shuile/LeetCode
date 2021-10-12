package cn.shui.learning_plan.offer.ninth;

/**
 * @author shui.
 * @date 2021/10/12.
 * @time 11:04.
 */
public class Offer47 {
    public int maxValue(int[][] grid) {
        if (grid == null || grid.length < 1 || grid[0].length < 1) {
            return 0;
        }
        int row = grid.length, column = grid[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                int temp = 0;
                if (i != 0) {
                    temp = grid[i - 1][j];
                }
                if (j != 0) {
                    temp = Math.max(temp, grid[i][j - 1]);
                }
                grid[i][j] += temp;
            }
        }
        return grid[row - 1][column - 1];
    }

    // 优化
    public int maxValue2(int[][] grid) {
        if (grid == null || grid.length < 1 || grid[0].length < 1) {
            return 0;
        }
        int row = grid.length, column = grid[0].length;
        // 初始化第一列
        for (int i = 1; i < row; i++) {
            grid[i][0] += grid[i - 1][0];
        }
        // 初始化第一行
        for (int j = 1; j < column; j++) {
            grid[0][j] += grid[0][j - 1];
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < column; j++) {
                grid[i][j] += Math.max(grid[i - 1][j], grid[i][j - 1]);
            }
        }
        return grid[row - 1][column - 1];
    }
}
