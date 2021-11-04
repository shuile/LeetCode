package cn.shui.order;

/**
 * @author shui.
 * @date 2021/11/4.
 * @time 09:33.
 * 有效的完全平方数
 */
public class L367 {

    public static void main(String[] args) {
        L367 test = new L367();
        test.isPerfectSquare(681);
    }

    public boolean isPerfectSquare(int num) {
        if (num == 1) {
            return true;
        }
        int start = num / 2;
        while ((num / start) < start) {
            start /= 2;
        }
        int temp = start * start;
        if (temp == num) {
            return true;
        }
        if (temp < num) {
            for (int i = start + 1; i < (start * 2); i++) {
                if ((num / i) == i) {
                    return true;
                }
                if ((num / i)  < i) {
                    break;
                }
            }
        } else {
            for (int i = start - 1; i > (start / 2); i--) {
                if ((num / i) == i) {
                    return true;
                }
                if ((num / i) > i) {
                    break;
                }
            }
        }
        return false;
    }

    // 二分迭代法
    public boolean isPerfectSquare2(int num) {
        int left = 0, right = num;
        while (left <= right) {
            int mid  = left + (right - left) / 2;
            long square = (long) mid * mid;
            if (square == num) {
                return true;
            }
            if (square < num) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }
}
