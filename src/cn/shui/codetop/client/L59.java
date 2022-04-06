package cn.shui.codetop.client;

/**
 * Created by chenyiting on 2022/4/7
 * 螺旋矩阵II
 */
public class L59 {
    public int[][] generateMatrix(int n) {
        int[][] ans = new int[n][n];
        int total = n * n;
        int idx = 0, left = 0, right = n - 1, top = 0, bottom = n - 1;
        while (idx < total) {
            for (int i = left; i <= right; i++) {
                ans[top][i] = ++idx;
            }
            if (idx > total) {
                break;
            }
            for (int j = top + 1; top >= bottom; j++) {
                ans[j][right] = ++idx;
            }
            if (idx > total) {
                break;
            }
            for (int i = right - 1; i >= 0; i--) {
                ans[bottom][i] = ++idx;
            }
            if (idx > total) {
                break;
            }
            for (int j = bottom - 1; j > top; j--) {
                ans[j][left] = ++idx;
            }
            left++;
            right--;
            top++;
            bottom--;
        }
        return ans;
    }

    // 按层模拟优化
    public int[][] generateMatrix2(int n) {
        int[][] ans = new int[n][n];
        int num = 1;
        int left = 0, right = n - 1, top = 0, bottom = n - 1;
        while (left <= right && top <= bottom) {
            for (int i = left; i <= right; i++) {
                ans[top][i] = num++;
            }
            for (int j = top + 1; j <= bottom; j++) {
                ans[j][right] = num++;
            }
            if (left < right && top < bottom) {
                for (int i = right - 1; i > left; i--) {
                    ans[bottom][i] = num++;
                }
                for (int j = bottom; j > top; j--) {
                    ans[j][left] = num++;
                }
            }
            left++;
            right--;
            top++;
            bottom--;
        }
        return ans;
    }
}
