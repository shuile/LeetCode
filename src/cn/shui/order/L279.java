package cn.shui.order;

/**
 * Created by chenyiting on 2022/10/25
 * 完全平方数
 * 不会
 */
public class L279 {

    private int ans = Integer.MAX_VALUE;

    // 超时
    public int numSquares(int n) {
        if (n == 1) {
            return 1;
        }
        int max = 100;
        dfs(Math.min(max, n), n, 0);
        return ans;
    }

    private void dfs(int index, int num, int count) {
        if (num < 0 || index <= 0) {
            return;
        }
        if (num == 0) {
            ans = Math.min(ans, count);
            return;
        }
        int temp = index * index;
        if (num >= temp) {
            dfs(index, num - temp, count + 1);
        }
        dfs(index - 1, num, count);
    }

    // 动态规划
    public int numSquares2(int n) {
        int[] f = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++) {
                min = Math.min(min, f[i - j * j]);
            }
            f[i] = min + 1;
        }
        return f[n];
    }

    public static void main(String[] args) {
        L279 test = new L279();
        System.out.println(test.numSquares(12));
    }
}
