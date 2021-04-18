package cn.shui.offer;

public class Offer_15 {
    public static void main(String[] args) {

    }

    private int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            count += n & 1;
            n = n >>> 1;
        }
        return count;
    }
}
