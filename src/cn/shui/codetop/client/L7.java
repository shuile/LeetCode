package cn.shui.codetop.client;

/**
 * Created by chenyiting on 2023/8/19
 * 整数反装
 */
public class L7 {

    private static final double TWO_31 = Math.pow(2, 31);

    public int reverse(int x) {
        long tmp = x;
        int flag = 1;
        if (tmp < 0) {
            tmp = -tmp;
            flag = -1;
        }
        long ans = 0;
        while (tmp != 0) {
            ans = ans * 10 + tmp % 10;
            tmp /= 10;
        }
        ans *= flag;
        if (ans > Integer.MAX_VALUE || ans < Integer.MIN_VALUE) {
            return 0;
        }
        return (int) ans;
    }

    public int reverse2(int x) {
        int ans = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if ((ans > Integer.MAX_VALUE / 10) || (ans == Integer.MAX_VALUE / 10 && pop > 7)) {
                return 0;
            }
            if ((ans < Integer.MIN_VALUE / 10) || (ans == Integer.MIN_VALUE / 10 && pop < -8)) {
                return 0;
            }
            ans = ans * 10 + pop;
        }
        return ans;
    }
}
