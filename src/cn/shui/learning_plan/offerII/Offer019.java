package cn.shui.learning_plan.offerII;

/**
 * @author shui.
 * @date 2021/12/10.
 * @time 15:09.
 * 最多删除一个字符得到回文
 */
public class Offer019 {
    public boolean validPalindrome(String s) {
        if (s.length() < 3) {
            return true;
        }
        int l = 0, r = s.length() - 1;
        while (l < r) {
            while (l < r && !Character.isLetterOrDigit(s.charAt(l))) {
                l++;
            }
            while (l < r && !Character.isLetterOrDigit(s.charAt(r))) {
                r--;
            }
            if (l != r && Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r))) {
                return isValidPalindrome(s, l + 1, r) || isValidPalindrome(s, l, r - 1);
            }
            l++;
            r--;
        }
        return true;
    }

    private boolean isValidPalindrome(String s, int l, int r) {
        while (l < r) {
            while (l < r && !Character.isLetterOrDigit(s.charAt(l))) {
                l++;
            }
            while (l < r && !Character.isLetterOrDigit(s.charAt(r))) {
                r--;
            }
            if (l != r && Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r))) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
