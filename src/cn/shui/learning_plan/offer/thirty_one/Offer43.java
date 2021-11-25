package cn.shui.learning_plan.offer.thirty_one;

/**
 * @author shui.
 * @date 2021/11/25.
 * @time 10:07.
 * 1~n整数中1出现的次数
 */
public class Offer43 {
    // 超时
    public int countDigitOne(int n) {
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            int temp = i;
            while (temp != 0) {
                if (temp % 10 == 1) {
                    ans++;
                }
                temp /= 10;
            }
        }
        return ans;
    }

    public int countDigitOne2(int n ){
        int digit = 1, res = 0;
        int high = n / 10, cur = n % 10, low = 0;
        while (high != 0 || cur != 0) {
            if (cur == 0) {
                res += high * digit;
            } else if (cur == 1) {
                res += high * digit + low + 1;
            } else {
                res += (high + 1) * digit;
            }
            low += cur * digit;
            cur = high % 10;
            high /= 10;
            digit *= 10;
        }
        return res;
    }
}
