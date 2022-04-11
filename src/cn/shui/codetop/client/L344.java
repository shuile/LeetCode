package cn.shui.codetop.client;

/**
 * Created by chenyiting on 2022/4/11
 * 反转字符串
 */
public class L344 {
    public void reverseString(char[] s) {
        if (s == null || s.length < 2) {
            return;
        }
        int l = 0, r = s.length - 1;
        while (l < r) {
            char temp = s[l];
            s[l] = s[r];
            s[r] = temp;
            l++;
            r--;
        }
    }
}
