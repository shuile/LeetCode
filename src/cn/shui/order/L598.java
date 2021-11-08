package cn.shui.order;

/**
 * @author shui.
 * @date 2021/11/8.
 * @time 09:17.
 * 范围求和II
 */
public class L598 {
    public int maxCount(int m, int n, int[][] ops) {
        if (ops == null || ops.length < 1) {
            return m * n;
        }
        int a = Integer.MAX_VALUE, b = a;
        for (int[] op : ops) {
            a = Math.min(a, op[0]);
            b = Math.min(b, op[1]);
        }
        return a * b;
    }
}
