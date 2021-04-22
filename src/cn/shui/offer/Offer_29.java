package cn.shui.offer;

public class Offer_29 {
    public static void main(String[] args) {

    }

    private int[] spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new int[]{};
        }
        int row = matrix.length;
        int column = matrix[0].length;
        int[] ans = new int[row * column];
        int left = 0, right = column - 1, top = 0, bottom = row - 1;
        int count = 0;
        while (left <= right && top <= bottom) {
            // top
            for (int i = left; i <= right; i++) {
                ans[count++] = matrix[top][i];
            }
            // right
            for (int i = top + 1; i <= bottom; i++) {
                ans[count++] = matrix[i][right];
            }
            if (left < right && top < bottom) {
                // bottom
                for (int i = right - 1; i > left; i--) {
                    ans[count++] = matrix[bottom][i];
                }
                // left
                for (int i = bottom; i > top; i--) {
                    ans[count++] = matrix[i][left];
                }
            }
            top++;
            right--;
            bottom--;
            left++;
        }
        return ans;
    }
}
