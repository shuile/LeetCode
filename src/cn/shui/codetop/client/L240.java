package cn.shui.codetop.client;

/**
 * Created by chenyiting on 2022/4/11
 * 搜索二维矩阵
 */
public class L240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length, columns = matrix[0].length;
        int row = 0, column = columns - 1;
        while (row < rows && column >= 0) {
            if (target == matrix[row][column]) {
                return true;
            }
            if (target < matrix[row][column]) {
                column--;
            } else {
                row++;
            }
        }
        return false;
    }
}
