package cn.shui.learning_plan.offer.twenty_four;

/**
 * @author shui.
 * @date 2021/10/21.
 * @time 10:15.
 */
public class Offer14I {
    public int cuttingRope(int n) {
        if (n <= 3) {
            return n - 1;
        }
        int a = n / 2, b = n % 3;
        if (b == 0) {
            return (int) Math.pow(3, a);
        }
        if (b == 1) {
            return (int) (Math.pow(3, a - 1) * 4);
        }
        return (int) (Math.pow(3, a) * 2);
    }
}
