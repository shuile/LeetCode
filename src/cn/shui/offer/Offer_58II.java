package cn.shui.offer;

public class Offer_58II {
    public static void main(String[] args) {

    }

    private String reverseLeftWord(String s, int n) {
        if (s == null || s.length() == 0 || s.length() <=n) {
            return s;
        }
        return s.substring(n) + s.substring(0, n);
    }
}
