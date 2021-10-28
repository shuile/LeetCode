package cn.shui.order;

/**
 * @author shui.
 * @date 2021/10/28.
 * @time 07:33.
 * 不同的二叉搜索树
 */
public class L96 {
    // 动态规划
    public int numTrees(int n) {
        int[] ans = new int[n + 1];
        ans[0] = 1;
        ans[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                ans[i] += ans[j - 1] * ans[i - j];
            }
        }
        return ans[n];
    }

    public int numTrees2(int n) {
        long C = 1;
        for (long i = 0; i < n; i++) {
            C = C * 2 * (2 * i + 1) / (i + 2);
        }
        return (int) C;
    }
}
