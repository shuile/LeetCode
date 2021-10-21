package cn.shui.learning_plan.offer.twenty_five;

/**
 * @author shui.
 * @date 2021/10/21.
 * @time 14:16.
 */
public class Offer29 {

    public static void main(String[] args) {
        Offer29 test = new Offer29();
        test.spiralOrder(new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12}});
    }

    public int[] spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length < 1 || matrix[0].length < 1) {
            return new int[0];
        }
        int row = matrix.length, column = matrix[0].length;
        int[] ans = new int[row * column];
        int count = 0, r = 0, c = 0, ceng = 0;
        while (count < ans.length) {
            while (c < column - ceng) {
                ans[count++] = matrix[r][c++];
            }
            c--;
            r++;
            if (count >= ans.length) {
                break;
            }
            while (r < row - ceng) {
                ans[count++] = matrix[r++][c];
            }
            r--;
            c--;
            if (count >= ans.length) {
                break;
            }
            while (c >= ceng) {
                ans[count++] = matrix[r][c--];
            }
            c++;
            r--;
            if (count >= ans.length) {
                break;
            }
            while (r > ceng) {
                ans[count++] = matrix[r--][c];
            }
            r++;
            c++;
            ceng++;
        }
        return ans;
    }

    // 模拟
    public int[] spiralOrder2(int[][] matrix) {
        if (matrix == null || matrix.length < 1 || matrix[0].length < 1) {
            return new int[0];
        }
        int rows = matrix.length, columns = matrix[0].length;
        boolean[][] visited = new boolean[rows][columns];
        int total = rows * columns;
        int[] order = new int[total];
        int row = 0, column = 0;
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int directionIndex = 0;
        for (int i = 0; i < total; i++) {
            order[i] = matrix[row][column];
            visited[row][column] = true;
            int nextRow = row + directions[directionIndex][0], nextColumn = column + directions[directionIndex][1];
            if (nextRow < 0 || nextRow >= rows || nextColumn < 0 || nextColumn >= columns || visited[nextRow][nextColumn]) {
                directionIndex = (directionIndex + 1) % 4;
            }
            row += directions[directionIndex][0];
            column += directions[directionIndex][1];
        }
        return order;
    }

    // 按层模拟
    public int[] spiralOrder3(int[][] matrix) {
        if (matrix == null || matrix.length < 1 || matrix[0].length < 1) {
            return new int[0];
        }
        int rows = matrix.length, columns = matrix[0].length;
        int[] order = new int[rows * columns];
        int index = 0;
        int left = 0, right = columns - 1, top = 0, bottom = rows - 1;
        while (left <= right && top <= bottom) {
            for (int column = left; column <= right; column++) {
                order[index++] = matrix[top][column];
            }
            for (int row = top; row <= bottom; row++) {
                order[index++] = matrix[row][right];
            }
            if (left < right && top < bottom) {
                for (int column = right - 1; column > left; column--) {
                    order[index++] = matrix[bottom][column];
                }
                for (int row = bottom; row > top; row--) {
                    order[index++] = matrix[row][left];
                }
            }
            left++;
            right--;
            top++;
            bottom--;
        }
        return order;
    }
}
