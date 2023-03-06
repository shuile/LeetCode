package cn.shui.order;

/**
 * Created by chenyiting on 2023/3/6
 * 3的幂
 */
public class L326 {
    // 方法一 循环
    public boolean isPowerOfThree(int n) {
        if (n == 0) {
            return false;
        }
        while (n != 1) {
            if (n % 3 != 0) {
                return false;
            }
            n /= 3;
        }
        return true;
    }

    // 方法一 循环精简版
    public boolean isPowerOfThree2(int n) {
        while (n != 0 && n % 3 == 0) {
            n /= 3;
        }
        return n == 1;
    }

    // 方法二 以范围内3的幂最大值的约束，3 ^ 19 = 1162261467
    public boolean isPowerOfThree3(int n) {
        return n != 0 && 1162261467 % n == 0;
    }
}
