package cn.shui.learning_plan.offer.fifth;

/**
 * @author shui.
 * @date 2021/9/29.
 * @time 09:11.
 * 二维数组中的查找
 */
public class Offer04 {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix[0].length < 1 || matrix[0].length < 1) {
            return false;
        }
        int row = matrix.length, column = matrix[0].length;
        // 找到第一个i，使得matrix[i][column - 1] > target
        int l = 0, h = row - 1;
        while (l < h) {
            int mid = l + (h - l) / 2;
            if (matrix[mid][column - 1] < target) {
                l = mid + 1;
            } else {
                h = mid;
            }
        }
        // 在找到的行索引基础上，按行顺序遍历，对每行一维数组的遍历过程采用二分查找
        int r =  column - 1;
        for (int i = l; i < row; i++) {
            l = 0;
            r = column - 1;
            while (l <= r) {
                int mid = l + (r - l) / 2;
                if (matrix[i][mid] == target) {
                    return true;
                }
                if (matrix[i][mid] < target) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }
        return false;
    }

    // 线性查找
    public boolean findNumberIn2DArray2(int[][] matrix, int target) {
        if (matrix == null || matrix.length < 1 || matrix[0].length < 1) {
            return false;
        }
        int rows = matrix.length, columns = matrix[0].length;
        int row = 0, column = columns - 1;
        while (row < rows && column >= 0) {
            int num = matrix[row][column];
            if (num == target) {
                return true;
            }
            if (num < target) {
                row++;
            } else {
                column--;
            }
        }
        return false;
    }
}
