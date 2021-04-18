package cn.shui.order.rotate_image;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[][] matrix = new int[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                matrix[i][j] = i * 3 + j + 1;
            }
        }
        System.out.println("matrix is\n");
        for (int i = 0; i < 3; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }

        rotate(matrix);

        System.out.println("matrix is\n");
        for (int i = 0; i < 3; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
    }

    private static void rotate(int[][] matrix) {
        if (matrix == null) {
            return;
        }
        int row = matrix.length;
        int column = matrix[0].length;
        int[][] result = new int[column][row];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                result[j][column - 1 -i] = matrix[i][j];
            }
        }

        String s = "";

        System.out.println("result is\n");
        for (int i = 0; i < 3; i++) {
            System.out.println(Arrays.toString(result[i]));
        }

        matrix = result;
    }
}
