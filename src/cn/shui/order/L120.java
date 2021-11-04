package cn.shui.order;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shui.
 * @date 2021/11/4.
 * @time 10:05.
 * 三角形最小路径和
 */
public class L120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() < 1) {
            return 0;
        }
        List<Integer> temp;
        int size = triangle.size();
        for (int i = 1; i < size; i++) {
            temp = triangle.get(i);
            for (int j = 0; j < temp.size(); j++) {
                int a = 0;
                if (j == 0) {
                    a = triangle.get(i - 1).get(j) + temp.get(j);
                } else if (j == temp.size() - 1) {
                    a = triangle.get(i - 1).get(j - 1) + temp.get(j);
                } else {
                    a = Math.min(triangle.get(i - 1).get(j - 1), triangle.get(i - 1).get(j)) + temp.get(j);
                }
                temp.set(j, a);
            }
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < triangle.get(size - 1).size(); i++) {
            ans = Math.min(ans, triangle.get(size - 1).get(i));
        }
        return ans;
    }

    // 动态规划 + 空间优化  O(n^2) + O(2*n)
    public int minimumTotal2(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] f = new int[2][n];
        f[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < n; i++) {
            int curr = i % 2;
            int prev = 1 - curr;
            f[curr][0] = f[prev][0] + triangle.get(i).get(0);
            for (int j = 1; j < i; j++) {
                f[curr][j] = Math.min(f[prev][j - 1], f[prev][j]) + triangle.get(i).get(j);
            }
            f[curr][i] = f[prev][i - 1] + triangle.get(i).get(i);
        }
        int minTotal = f[(n - 1) % 2][0];
        for (int i = 1; i < n; i++) {
            minTotal = Math.min(minTotal, f[(n - 1) % 2][i]);
        }
        return minTotal;
    }

    // 动态规划 + 空间优化  O(n^2) + O(n)
    public int minimumTotal3(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] f = new int[n];
        f[0] = triangle.get(0).get(0);
        for (int i = 1; i < n; i++) {
            f[i] = f[i - 1] + triangle.get(i).get(i);
            for (int j = i - 1; j > 0; j--) {
                f[j] = Math.min(f[j - 1], f[j]) + triangle.get(i).get(j);
            }
            f[0] += triangle.get(i).get(0);
        }
        int minTotal = f[0];
        for (int i = 1; i < n; i++) {
            minTotal = Math.min(minTotal, f[i]);
        }
        return minTotal;
    }
}
