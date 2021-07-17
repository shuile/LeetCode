package cn.shui.learning_plan.algorithms.forth_day;

/**
 * @author shui.
 * @date 2021/7/17.
 * @time 14:19.
 * 反转字符串
 */
public class L344 {
    public void reverseString1(char[] s) {
        if (s == null || s.length < 2) {
            return;
        }
        int l = 0, r = s.length - 1;
        char temp;
        while (l < r) {
            temp = s[l];
            s[l] = s[r];
            s[r] = temp;
            l++;
            r--;
        }
    }

    public void reverseString2(char[] s) {
        if (s == null) {
            return;
        }
        StringBuilder sb = new StringBuilder(String.valueOf(s));
        char[] ans = sb.reverse().toString().toCharArray();
        System.arraycopy(ans, 0, s, 0, ans.length);
    }
}
