package cn.shui.codetop.client;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenyiting on 2022/4/2
 * 复原IP地址
 */
public class L93 {

    private final List<String> ans = new ArrayList<>();

    public List<String> restoreIpAddress(String s) {
        help(s, "", 0);
        return ans;
    }

    private void help(String s, String curr, int index) {
        if (index >= 4) {
            if (s == null || s.length() == 0) {
                ans.add(curr.substring(0, curr.length() - 1));
            }
            return;
        }
        if (s == null || s.length() == 0) {
            return;
        }
        int len = s.length();
        char ch = s.charAt(0);
        help(s.substring(1), curr + ch + ".", index + 1);
        if (ch == '0' || len < 2) {
            return;
        }
        help(s.substring(2), curr + s.substring(0, 2) + ".", index + 1);
        if (len < 3 || Integer.parseInt(s.substring(0, 3)) > 255) {
            return;
        }
        help(s.substring(3), curr + s.substring(0, 3) + ".", index + 1);
    }
}
