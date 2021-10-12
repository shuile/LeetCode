package cn.shui.learning_plan.offer.eighth;

/**
 * @author shui.
 * @date 2021/10/12.
 * @time 10:09.
 */
public class Offer10II {
    public int numWays(int n) {
        int a = 1, b = 1, sum;
        for (int i = 0; i < n; i++) {
            sum = (a + b) % 1000000007;
            a = b;
            b = sum;
        }
        return a;
    }
}
