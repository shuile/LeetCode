package cn.shui.learning_plan.offer.twenty_one;

/**
 * @author shui.
 * @date 2021/10/20.
 * @time 10:21.
 */
public class Offer15 {
    public int hammingWeight(int n) {
        int ans = 0;
        for (int i = 0; i < 32 && n != 0; i++) {
            if ((n & 1) == 1) {
                ans++;
            }
            n >>= 1;
        }
        return ans;
    }

    // 位运算优化
    public int hammingWeight2(int n) {
        int ans = 0;
        while (n != 0) {
            n &= n - 1;
            ans++;
        }
        return ans;
    }
}
