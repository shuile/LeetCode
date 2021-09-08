package cn.shui.learning_plan.datastruct_basic.third;

/**
 * @author shui.
 * @date 2021/9/8.
 * @time 10:02.
 * 螺旋矩阵
 */
public class L59 {

    public static void main(String[] args) {
        L59 test = new L59();
        test.generateMatrix1(3);
    }

    public int[][] generateMatrix1(int n) {
        if (n < 1) {
            return null;
        }
        int[][] ans = new int[n][n];
        // 方向 0：水平向右；1：竖直向下；2：水平向左；3：竖直向上
        int direction = 0;
        int row = 0, column = 0;
        int count = 1;
        while (count <= n) {
            switch (direction) {
                case 0:
                    if (column < n && ans[row][column] == 0) {
                        ans[row][column] = count;
                        count++;
                        column++;
                    } else {
                        column--;
                        row++;
                        direction = 1;
                    }
                    break;
                case 1:
                    if (row < n && ans[row][column] == 0) {
                        ans[row][column] = count;
                        count++;
                        row++;
                    } else {
                        row--;
                        column--;
                        direction = 2;
                    }
                    break;
                case 2:
                    if (column >= 0 && ans[row][column] == 0) {
                        ans[row][column] = count;
                        count++;
                        column--;
                    } else {
                        column++;
                        row--;
                        direction = 3;
                    }
                    break;
                case 3:
                    if (row >= 0 && ans[row][column] == 0) {
                        ans[row][column] = count;
                        count++;
                        row--;
                    } else {
                        row++;
                        column++;
                        direction = 0;
                    }
                    break;
            }
        }
        return ans;
    }

    // 模拟
    public int[][] generateMatrix2(int n) {
        int maxNum = n * n;
        int curNum = 1;
        int[][] matrix = new int[n][n];
        int row = 0, column = 0;
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; // 右下左上
        int directionIndex = 0;
        while (curNum < maxNum) {
            matrix[row][column] = curNum;
            curNum++;
            int nextRow = row + directions[directionIndex][0], nextColumn = column + directions[directionIndex][1];
            if (nextRow < 0 || nextRow >= n || nextColumn < 0 || nextColumn >= n || matrix[nextRow][nextColumn] != 0) {
                directionIndex = (directionIndex + 1) % 4; // 顺时针旋转至下一个方向
            }
            row = row + directions[directionIndex][0];
            column = column + directions[directionIndex][1];
        }
        return matrix;
    }

    // 按层模拟
    public int[][] generateMatrix3(int n) {
        int num = 1;
        int[][] matrix = new int[n][n];
        int left = 0, right = n - 1, top = 0, bottom = n - 1;
        while (left <= right && top <= bottom) {
            for (int column = left; column <= right; column++) {
                matrix[top][column] = num;
                num++;
            }
            for (int row = top + 1; row <= bottom; row++) {
                matrix[row][right] = num;
                num++;
            }
            if (left < right && top < bottom) {
                for (int column = right - 1; column > left; column--) {
                    matrix[bottom][column] = num;
                    num++;
                }
                for (int row = bottom; row > top; row--) {
                    matrix[row][left] = num;
                    num++;
                }
            }
            left++;
            top++;
            right--;
            bottom--;
        }
        return matrix;
    }
}
