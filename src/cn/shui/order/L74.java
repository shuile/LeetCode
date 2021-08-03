package cn.shui.order;

/**
 * @author shui.
 * @date 2021/8/3.
 * @time 23:39.
 * 搜索二维矩阵
 */
public class L74 {
    private boolean searchMatrix1(int[][] matrix, int target) {
        if (matrix == null || matrix.length < 1 || matrix[0].length < 1) {
            return false;
        }
        int row = matrix.length, column = matrix[0].length, l = 0, r = column - 1, mid;
        for (int i = 0; i < row; i++) {
            if (target > matrix[i][column - 1]) {
                continue;
            }
            while (l <= r) {
                mid = l + (r - l) / 2;
                if (target == matrix[i][mid]) {
                    return true;
                }
                if (target < matrix[i][mid]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
            return false;
        }
        return false;
    }

    // 两次二分查找
    private boolean searchMatrix2(int[][] matrix, int target) {
        int rowIndex = binarySearchFirstColumn(matrix, target);
        if (rowIndex < 0) {
            return false;
        }
        return binarySearchRow(matrix[rowIndex], target);
    }

    private int binarySearchFirstColumn(int[][] matrix, int target) {
        int low = -1, high = matrix.length - 1;
        while (low < high) {
            int mid = low + (high - low + 1) / 2;
            if (matrix[mid][0] <= target) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    private boolean binarySearchRow(int[] row, int target) {
        int low = 0, high = row.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (row[mid] == target) {
                return true;
            }
            if (row[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return false;
    }

    private boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int low = 0, high = m * n - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int x = matrix[mid / n][mid % n];
            if (x == target) {
                return true;
            }
            if (x < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return false;
    }
}
