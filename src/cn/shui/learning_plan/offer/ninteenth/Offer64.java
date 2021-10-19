package cn.shui.learning_plan.offer.ninteenth;

/**
 * @author shui.
 * @date 2021/10/19.
 * @time 11:17.
 */
public class Offer64 {
    public int sumNums(int n) {
        boolean flag = n > 0 && (n += sumNums(n - 1)) > 0;
        return n;
    }
}
