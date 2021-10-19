package cn.shui.learning_plan.offer.twentieth;

/**
 * @author shui.
 * @date 2021/10/19.
 * @time 15:02.
 */
public class Offer16 {

    // 二分法
    public double myPow(double x, int n) {
        if (x == 0 || x == 1) {
            return x;
        }
        long b = n;
        double res = 1.0;
        if (b < 0) {
            x = 1 / x;
            b = -b;
        }
        while (b > 0) {
            if ((b & 1) == 1) {
                res *= x;
            }
            x *= x;
            b >>= 1;
        }
        return res;
    }
}
