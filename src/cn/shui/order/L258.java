package cn.shui.order;

/**
 * Created by chenyiting on 2022/10/19
 * 各位相加
 */
public class L258 {
    public int addDigits(int num) {
        if (num < 10) {
            return num;
        }
        int ans = 0;
        while (num > 0) {
            ans += num % 10;
            num /= 10;
        }
        return addDigits(ans);
    }

    // 数学
    public int addDigits2(int num) {
        return (num - 1) % 9 + 1;
    }
}
