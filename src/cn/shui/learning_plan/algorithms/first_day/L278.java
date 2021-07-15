package cn.shui.learning_plan.algorithms.first_day;

/**
 * @author shui.
 * @date 2021/7/15.
 * @time 11:41.
 * 第一个错误的版本
 */
public class L278 {
    public int firstBasVersion(int n) {
        int l = 1, r = n;
        int mid;
        while (l < r) {
            mid = l + (r - l) / 2;
            if (isBadVersion(mid)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    // 模拟题中的isBadVersion,防止代码报错
    private boolean isBadVersion(int n) {
        return n % 2 == 0;
    }
}
