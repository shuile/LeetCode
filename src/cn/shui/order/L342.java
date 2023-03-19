package cn.shui.order;

/**
 * Created by chenyiting on 2023/3/19
 * 4的幂
 */
public class L342 {
    public boolean isPowerOfFour(int n) {
        if (n == 0) {
            return false;
        }
        while (n != 1) {
            if (n % 4 != 0) {
                return false;
            }
            n /= 4;
        }
        return true;
    }

    // 简化for循环
    public boolean isPowerOfFour2(int n) {
        while (n != 0 && n % 4 == 0) {
            n /= 4;
        }
        return n == 1;
    }

    // 二进制表示中1的位置
    public boolean isPowerOfFour3(int n) {
        return n > 0 && (n & (n - 1)) == 0 && (n & 0xAAAAAAAA) == 0;
    }

    // 取模性质
    public boolean ifPowerOfFour4(int n) {
        return ((n & (n - 1)) == 0) && (n % 3 == 1);
    }
}
