package cn.shui.learning_plan.offerII;

/**
 * @author shui.
 * @date 2021/12/10.
 * @time 14:49.
 * 有效的回文
 */
public class Offer018 {
    public boolean isPalindrome(String s) {
        if (s.length() < 2) {
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
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
