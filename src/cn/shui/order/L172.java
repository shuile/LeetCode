package cn.shui.order;

/**
 * Created by chenyiting on 2022/7/1
 * 阶乘后的零
 */
public class L172 {
    public int trailingZeros(int n) {
        int two = 0;
        int five = 0;
        for (int i = 2; i <= n; i++) {
            two += getCount(i, 2);
            five += getCount(i, 5);
        }
        return Math.min(two, five);
    }

    private int getCount(int n, int base) {
        if (base < 2) {
            return 0;
        }
        int res = 0;
        while (n % base == 0) {
            res++;
            n /= base;
        }
        return res;
    }

    private int two = 0;
    private int five = 0;

    // 优化
    public int trailingZeros2(int n) {
        for (int i = 2; i <= n; i++) {
            getCount(i);
        }
        return Math.min(two, five);
    }

    private void getCount(int n) {
        while (n % 2 == 0) {
            two++;
            n /= 2;
        }
        while (n % 5 == 0) {
            five++;
            n /= 5;
        }
    }

    // 数学：由于5的数量会比2的数量少，所以只需计算5的数量
    public int trailingZeros3(int n) {
        int ans = 0;
        for (int i = 5; i <= n; i++) {
            for (int j = i; j % 5 == 0; j /= 5) {
                ans++;
            }
        }
        return ans;
    }

    // 数学优化
    public int trailingZeros4(int n) {
        int ans = 0;
        while (n != 0) {
            n /= 5;
            ans += n;
        }
        return ans;
    }
}
