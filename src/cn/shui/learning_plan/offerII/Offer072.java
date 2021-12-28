package cn.shui.learning_plan.offerII;

/**
 * @author shui.
 * @date 2021/12/28.
 * @time 10:18.
 * 求平方根
 */
public class Offer072 {
    public int mySqrt(int x) {
        int l = 1, r = x;
        while (l <= r) {
            int mid = l + ((r - l) >> 1);
            if (mid <= x / mid) {
                if (mid + 1 > x / (mid + 1)) {
                    return mid;
                }
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return 0;
    }
}
