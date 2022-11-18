package cn.shui.order;

/**
 * Created by chenyiting on 2022/11/18
 * 二位区域和检索 - 矩阵不可变
 */
public class L304 {
    private static class NumMatrix {

        private int[][] matrix;

        public NumMatrix(int[][] matrix) {
            this.matrix = matrix;
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            int ans = 0;
            for (int i = row1; i <= row2; i++) {
                for (int j = col1; j <= col2; j++) {
                    ans += matrix[i][j];
                }
            }
            return ans;
        }
    }

    // 一维前缀和
    private static class NumMatrix2 {
        private int[][] sums;
        public NumMatrix2(int[][] matrix) {
            if (matrix == null || matrix.length < 1 || matrix[0] == null || matrix[0].length < 1) {
                return;
            }
            int row = matrix.length, col = matrix[0].length;
            sums = new int[row][col + 1];
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    sums[i][j + 1] = sums[i][j] + matrix[i][j];
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            if (sums == null) {
                return -1;
            }
            int ans = 0;
            for (int i = row1; i <= row2; i++) {
                ans += sums[i][col2 + 1] - sums[i][col1];
            }
            return ans;
        }
    }

    // 二位前缀和
    private static class NumMatrix3 {

        private int[][] sums;

        public NumMatrix3(int[][] matrix) {
            if (matrix == null || matrix.length < 1 || matrix[0] == null || matrix[0].length < 1) {
                return;
            }
            int row = matrix.length, col = matrix[0].length;
            sums = new int[row + 1][col + 1];
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    sums[i + 1][j + 1] = sums[i + 1][j] + sums[i][j + 1] - sums[i][j] + matrix[i][j];
                }
            }
        }

        public int subRegion(int row1, int col1, int row2, int col2) {
            return sums[row2 + 1][col2 + 1] - sums[row1][col2 + 1] - sums[row2 + 1][col1] + sums[row1][col1];
        }
    }
}
