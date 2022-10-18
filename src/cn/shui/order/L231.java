package cn.shui.order;

/**
 * Created by chenyiting on 2022/10/18
 * 2的幂
 */
public class L231 {
    public boolean isPowerOfTwo(int n) {
        if (n == 0) {
            return false;
        }
        if (n == 1) {
            return true;
        }
        if (n % 2 == 1) {
            return false;
        }
        return isPowerOfTwo(n / 2);
    }

    // 二进制表示
    public boolean isPowerOfTwo2(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }

    public boolean isPowerOfTwo3(int n) {
        return n > 0 && (n & -n) == n;
    }

    private static final int BIG = 1 << 30;

    // 判断是否为最大2的幂的约数
    public boolean isPowerOfTwo4(int n) {
        return n > 0 && BIG % n == 0;
    }
}
