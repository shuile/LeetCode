package cn.shui.order;

/**
 * Created by chenyiting on 2025/4/9
 * Nth Digit
 */
public class L400 {
    public int findNthDigit(int n) {
        if (n < 10) {
            return n;
        }
        return help(9, 10, 1, n);
    }

    private int help(long lastIndex, long max, int exp, int n) {
        long nextIndex = lastIndex + max * 9 * (exp + 1);
        if (n <= nextIndex) {
            long num = (n - lastIndex - 1) / (exp + 1) + max;
            int diff = (int) ((n - lastIndex - 1) % (exp + 1));
            return String.valueOf(num).charAt(diff) - '0';
        }
        return help(nextIndex, max * 10, exp + 1, n);
    }

    public static void main(String[] args) {
        L400 test = new L400();
        System.out.println(test.findNthDigit(10));
    }
}
