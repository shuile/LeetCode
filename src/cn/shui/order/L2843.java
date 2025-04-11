package cn.shui.order;

/**
 * Created by chenyiting on 2025/4/11
 * Count Symmetric Integers
 */
public class L2843 {
    public int countSymmetricIntegers(int low, int high) {
        int ans = 0;
        for (int i = low; i <= high; i++) {
            ans += isSymmetric(i) ? 1 : 0;
        }
        return ans;
    }

    private boolean isSymmetric(int x) {
        String xStr = String.valueOf(x);
        int len = xStr.length();
        if (len % 2 == 1) {
            return false;
        }
        int res = 0;
        for (int i = 0; i < len / 2; i++) {
            res += xStr.charAt(i) - '0';
            res -= xStr.charAt(len - i - 1) - '0';
        }
        return res == 0;
    }

    public static void main(String[] args) {
        L2843 test = new L2843();
        System.out.println(test.countSymmetricIntegers(1200, 1230));
    }
}
