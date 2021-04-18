package cn.shui.offer;

public class Offer_17 {
    public static void main(String[] args) {

    }

    private int[] printNumbers(int n) {
        int len = (int) (Math.pow(10, n) - 1);
        int[] ans = new int[len];
        for (int i = 0; i < len; i++) {
            ans[i] = i + 1;
        }
        return ans;
    }
}
