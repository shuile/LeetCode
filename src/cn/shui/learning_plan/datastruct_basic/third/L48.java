package cn.shui.learning_plan.datastruct_basic.third;

/**
 * @author shui.
 * @date 2021/9/6.
 * @time 15:28.
 * 旋转图像
 */
public class L48 {
    public void rotate1(int[][] matrix) {
        if (matrix == null || matrix.length < 1 || matrix[0].length < 1) {
            return;
        }
        // 上下翻转
        int row = matrix.length, column = matrix[0].length;
        for (int i = 0; i < column; i++) {
            int l = 0, h = row - 1;
            while (l < h) {
                int temp = matrix[l][i];
                matrix[l][i] = matrix[h][i];
                matrix[h][i] = temp;
                l++;
                h--;
            }
        }
        // 主对角线翻转
        for (int i = 0; i < row; i++) {
            for (int j = i + 1; j < column; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

    public void rotate2(int[][] matrix) {
        int n = matrix.length;
        int[][] matrix_new = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix_new[j][n - i - 1] = matrix[i][j];
            }
        }
        for (int i = 0; i < n; i++) {
            System.arraycopy(matrix_new[i], 0, matrix[i], 0, n);
        }
    }

    public void rotate3(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < (n + 1) / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - j - 1][i];
                matrix[n - j - 1][i] = matrix[n - i - 1][n - j - 1];
                matrix[n - i - 1][n -j - 1] = matrix[j][n - i - 1];
                matrix[j][n - i - 1] = temp;
            }
        }
    }
}
