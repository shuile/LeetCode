package cn.shui.order;

/**
 * Created by chenyiting on 2022/7/5
 * 数字范围按位与
 */
public class L201 {
    public int rangeBitwiseAnd(int left, int right) {
        if (left > right) {
            return 0;
        }
        if (left == right) {
            return 0;
        }
        if (right - left == 1) {
            return left & right;
        }
        int mid = left + (right - left) / 2;
        int leftPart = rangeBitwiseAnd(left, mid);
        if (right - mid == 1) {
            return leftPart & right;
        }
        int rightPart = rangeBitwiseAnd(mid + 1, right);
        return leftPart & rightPart;
    }

    public int rangeBitwiseAnd2(int left, int right) {
        if (left > right) {
            return 0;
        }
        int shift = 0;
        while (left < right) {
            left >>= 1;
            right >>= 1;
            shift++;
        }
        return left << shift;
    }

    // Brian Kernighan 算法
    public int rangeBitwiseAnd3(int left, int right) {
        if (left > right) {
            return 0;
        }
        while (left < right) {
            right &= (right - 1);
        }
        return right;
    }
}
