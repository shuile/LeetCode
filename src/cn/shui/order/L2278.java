package cn.shui.order;

/**
 * Created by chenyiting on 2025/3/31
 * Percentage of letter in string
 */
public class L2278 {
    public int percentageLetter(String s, char letter) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int l = 0, r = s.length() - 1;
        int count = 0;
        while (l <= r) {
            if (s.charAt(l) == letter) {
                count++;
            }
            if (l == r) {
                break;
            }
            if (s.charAt(r) == letter) {
                count++;
            }
            l++;
            r--;
        }
        return count * 100 / s.length();
    }
}
