package cn.shui.learning_plan.datastruct.fifth;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author shui.
 * @date 2021/8/20.
 * @time 11:36.
 * 矩阵置零
 */
public class L73 {
    public void setZeros1(int[][] matrix) {
        Set<Integer> setI = new HashSet<>();
        Set<Integer> setJ = new HashSet<>();
        int row = matrix.length, column = matrix[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (matrix[i][j] == 0) {
                    setI.add(i);
                    setI.add(j);
                }
            }
        }
        for (int i : setI) {
            Arrays.fill(matrix[i], 0);
        }
        for (int j : setJ) {
            for (int i = 0; i < row; i++) {
                matrix[i][j] = 0;
            }
        }
    }

    // 使用标记数组
    public void setZeros2(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        boolean[] row = new boolean[m];
        boolean[] col = new boolean[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = col[j] = true;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (row[i] || col[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    // 使用两个标记变量
    public void setZeros3(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        boolean flagCol0 = false, flagRow0 = false;
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                flagCol0 = true;
            }
        }
        for (int j = 0; j < n; j++) {
            if (matrix[0][j] == 0) {
                flagRow0 = true;
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = matrix[0][j] = 0;
                }
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        if (flagCol0) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
        if (flagRow0) {
            for (int j = 0; j < n; j++) {
                matrix[0][j] = 0;
            }
        }
    }

    // 使用一个标记变量
    private void setZeros4(int[][] matrix) {
        int row = matrix.length, column = matrix[0].length;
        boolean flagCol0 = false;
        for (int i = 0; i < row; i++) {
            if (matrix[i][0] == 0) {
                flagCol0 = true;
            }
            for (int j = 1; j < column; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for (int i = row - 1; i >= 0; i++) {
            for (int j = 1; j < column; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
            if (flagCol0) {
                matrix[i][0] = 0;
            }
        }
    }
}
