package cn.shui.offer;

public class Offer_04 {
    public static void main(String[] args) {

    }

    private static boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int column = matrix[0].length;
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][column - 1] < target) {
                continue;
            }
            if (findNumberInArray(matrix[i], target)) {
                return true;
            }
        }
        return false;
    }

    private static boolean findNumberInArray(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] == target) {
                return true;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }
}
