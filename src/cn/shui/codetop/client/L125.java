package cn.shui.codetop.client;

/**
 * Created by chenyiting on 2022/4/7
 * 验证回文串
 */
public class L125 {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int l = 0, r = s.length() - 1;
        boolean result = true;
        while (l < r) {
            while (l < r && !isLetterOrDigit(s.charAt(l))) {
                l++;
            }
            while (l < r && !isLetterOrDigit(s.charAt(r))) {
                r--;
            }
            if (l < r && s.charAt(l) != s.charAt(r)) {
                result = false;
                break;
            }
            while (l < r && s.charAt(l) == s.charAt(r)) {
                l++;
                r--;
            }
        }
        return result;
    }

    private boolean isLetterOrDigit(char ch) {
        return (ch >= 'a' && ch <= 'z') || (ch >= '0' && ch <= '9');
    }

    public static void main(String[] args) {
        L125 test = new L125();
        test.isPalindrome("OP");
    }
}
