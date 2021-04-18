package cn.shui.offer;

public class Offer_16 {
    public static void main(String[] args) {

    }

    private double myPow(double x, int n) {
        if (x == 0) {
            return 0;
        }
        double res = 1.0;
        long b = n;
        if (b < 0) {
            x = 1 / x;
            b = -b;
        }
        while (b != 0) {
            if (b % 2 == 1) {
                res *= x;
            }
            x *= x;
            b /= 2;
        }
        return res;
    }
}
