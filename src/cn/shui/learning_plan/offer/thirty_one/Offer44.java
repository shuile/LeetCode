package cn.shui.learning_plan.offer.thirty_one;

/**
 * @author shui.
 * @date 2021/11/25.
 * @time 10:23.
 * 数字序列中某一位的数字
 */
public class Offer44 {
    // 超时
    public int findNthDigit(int n) {
        StringBuilder sb = new StringBuilder();
        long i = 0;
        while (sb.length() <= n) {
            sb.append(i++);
        }
        return sb.toString().charAt(n) - '0';
    }

    // 迭代+求整/求余
    public int findNthDigit2(int n) {
        int digit = 1;
        long start = 1;
        long count = 9;
        while (n > count) {
            n -= count;
            digit += 1;
            start *= 10;
            count = digit * start * 9;
        }
        long num = start + (n - 1) / digit;
        return Long.toString(num).charAt((n - 1) % digit) - '0';
    }
}
