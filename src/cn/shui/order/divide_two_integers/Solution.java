package cn.shui.order.divide_two_integers;

public class Solution {
    public static void main(String[] args) {
        int d1 = 1;
        int d2 = 1;
        System.out.println(divide(d1, d2));
    }

    private static int divide(int dividend, int divisor) {
        long m = dividend;
        long n = divisor;
        long res = 0;
        m = m < 0 ? -m : m;
        n = n < 0 ? -n : n;
        if (m < n) {
            return (int) res;
        }
        while (m >= n) {
            long t = n;
            long p = 1;
            while (m > (t << 1)) {
                t <<= 1;
                p <<= 1;
            }
            res += p;
            m -= t;
        }
        if ((dividend < 0) ^ (divisor < 0)) {
            res = -res;
        }
        return (int) (res > Integer.MAX_VALUE ? Integer.MAX_VALUE : res);
    }
}
