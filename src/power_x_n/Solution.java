package power_x_n;

public class Solution {
    public static void main(String[] args) {
        double x1 = 2.00000f;
        int n = 10;

    }

    private static double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n == Integer.MIN_VALUE) {
            return 1 / x * myPow(x, n + 1);
        }
        if (n < 0) {
            n = -n;
            x = 1 / x;
        }
        return (n % 2 == 0) ? myPow(x * x, n / 2) : x * myPow(x * x, n / 2);
    }
}
