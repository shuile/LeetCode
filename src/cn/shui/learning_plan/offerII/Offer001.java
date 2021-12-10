package cn.shui.learning_plan.offerII;

/**
 * @author shui.
 * @date 2021/11/29.
 * @time 10:23.
 * 整数除法
 */
public class Offer001 {
    public int divide(int a, int b) {
        if (a == Integer.MIN_VALUE && b == -1) {
            return Integer.MAX_VALUE;
        }
        int sign = (a > 0) ^ (b > 0) ? -1 : 1;
        if (a > 0) {
            a = -a;
        }
        if (b > 0) {
            b = -b;
        }
        int res = 0;
        while (a <= b) {
            a -= b;
            res++;
        }
        return sign == 1 ? res : -res;
    }

    // 优化1
    public int divide2(int a, int b) {
        if (a == Integer.MIN_VALUE && b == -1) {
            return Integer.MAX_VALUE;
        }
        int sign = (a > 0) ^ (b > 0) ? -1 : 1;
        if (a > 0) {
            a = -a;
        }
        if (b > 0) {
            b = -b;
        }
        int res = 0;
        while (a <= b) {
            int value = b;
            int k = 1;
            while (value >= 0xc0000000 && a <= value + value) {
                value += value;
                k += k;
            }
            a -= value;
            res += k;
        }
        return sign == 1 ? res : -res;
    }

    // 优化2
    public int divide3(int a, int b) {
        if (a == Integer.MIN_VALUE && b == -1) {
            return Integer.MAX_VALUE;
        }
        int sign = (a > 0) ^ (b > 0) ? -1 : 1;
        a = Math.abs(a);
        b = Math.abs(b);
        int res = 0;
        for (int i = 31; i >= 0; i--) {
            if ((a >>> i) - b >= 0) {
                a -= (b << i);
                res += (1 << i);
            }
        }
        return sign == 1 ? res : -res;
    }
}
