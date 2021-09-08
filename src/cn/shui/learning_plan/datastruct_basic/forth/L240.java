package cn.shui.learning_plan.datastruct_basic.forth;

/**
 * @author shui.
 * @date 2021/9/8.
 * @time 10:36.
 * 搜索二维矩阵II
 */
public class L240 {
    public boolean searchMatrix1(int[][] matrix, int target) {
        if (matrix == null || matrix.length < 1 || matrix[0].length < 1) {
            return false;
        }
        int row = matrix.length, column = matrix[0].length;
        for (int[] ints : matrix) {
            if (target >= ints[0] && target <= ints[column - 1]) {
                boolean flag = findTarget(ints, target);
                if (flag) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean findTarget(int[] matrix, int target) {
        int l = 0, r = matrix.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (matrix[mid] == target) {
                return true;
            }
            if (matrix[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return false;
    }

    // 暴力法
    public boolean searchMatrix2(int[][] matrix, int target) {
        for (int[] ints : matrix) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (ints[j] == target) {
                    return true;
                }
            }
        }
        return false;
    }

    // 二分搜索法
    public boolean searchMatrix3(int[][] matrix, int target) {
        if (matrix == null || matrix.length < 1) {
            return false;
        }
        int shorterDim = Math.min(matrix.length, matrix[0].length);
        for (int i = 0; i < shorterDim; i++) {
            boolean verticalFound = binarySearch(matrix, target, i, true);
            boolean horizontalFound = binarySearch(matrix, target, i, false);
            if (verticalFound || horizontalFound) {
                return true;
            }
        }
        return false;
    }

    private boolean binarySearch(int[][] matrix, int target, int start, boolean vertical) {
        int lo = start;
        int hi = vertical ? matrix[0].length - 1 : matrix.length - 1;
        while (hi >= lo) {
            int mid = lo + (hi - lo) / 2;
            if (vertical) {
                if (matrix[start][mid] == target) {
                    return true;
                }
                if (matrix[start][mid] < target) {
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            } else {
                if (matrix[mid][start] == target) {
                    return true;
                }
                if (matrix[mid][start] < target) {
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }
        }
        return false;
    }

    private int[][] matrix;
    private int target;

    // 搜索空间的缩减
    public boolean searchMatrix4(int[][] matrix, int target) {
        // an empty matrix obviously does not contain 'target'
        if (matrix == null || matrix.length == 0) {
            return false;
        }

        // cache input values in object to avoid passing them unnecessarily to 'searchRec'
        this.matrix = matrix;
        this.target = target;

        return searchRec(0, 0, matrix[0].length - 1, matrix.length - 1);
    }

    private boolean searchRec(int left, int up, int right, int down) {
        // this submatrix has no height or no width
        if (left > right || up > down) {
            return false;
        }
        // 'target' is already larger than the largest element or smaller than the smallest element in this submatrix.
        if (target < matrix[up][left] || target > matrix[down][right]) {
            return false;
        }

        int mid = left + (right - left) / 2;

        // Locate 'row' such that matrix[row - 1][mid] < target < matrix[row][mid]
        int row = up;
        while (row <= down && matrix[row][mid] <= target) {
            if (matrix[row][mid] == target) {
                return true;
            }
            row++;
        }
        return searchRec(left, row, mid - 1, down) || searchRec(mid + 1, up, right, row - 1);
    }

    // 方法四
    public boolean searchMatrix5(int[][] matrix, int target) {
        // start our 'pointer' in the bottom-left
        int row = matrix.length - 1, col = 0;
        while (row >= 0 && col < matrix[0].length) {
            if (matrix[row][col] > target) {
                row--;
            } else if (matrix[row][col] < target) {
                col++;
            } else {
                return true;
            }
        }
        return false;
    }
}
