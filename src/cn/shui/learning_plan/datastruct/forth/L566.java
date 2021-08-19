package cn.shui.learning_plan.datastruct.forth;

/**
 * @author shui.
 * @date 2021/8/19.
 * @time 09:05.
 * 重塑矩阵
 */
public class L566 {

    public static void main(String[] args) {
        matrixReshape1(new int[][]{{1, 2, 3, 4}}, 2, 2);
    }

    public static int[][] matrixReshape1(int[][] mat, int r, int c) {
        if (mat == null || mat.length < 1 || mat[0].length < 1) {
            return mat;
        }
        int row = mat.length, column = mat[0].length;
        if (row * column != r * c) {
            return mat;
        }
        int[][] ans = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                int location = i * c + j;
                ans[i][j] = mat[location / column][location % column];
            }
        }
        return ans;
    }

    // 二维数组的一维表示
    public int[][] matrixReshape2(int[][] mat, int r, int c) {
        int m = mat.length;
        int n = mat[0].length;
        if (m * n != r * c) {
            return mat;
        }
        int[][] ans = new int[r][c];
        for (int i = 0; i < m * n; i++) {
            ans[i / c][i % c] = mat[i / n][i % n];
        }
        return ans;
    }
}
