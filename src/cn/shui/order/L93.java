package cn.shui.order;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shui.
 * @date 2021/10/27.
 * @time 07:56.
 * 复原IP地址
 */
public class L93 {
    private List<String> ans = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        help(s, 0, "");
        return ans;
    }

    private void help(String s, int index, String str) {
        if (index == 0) {
            if (s.length() < 1) {
                ans.add(str);
            }
            return;
        }
        if (index < 4) {
            str += ".";
        }
        index--;
        // 一位地址
        if (s.length() > 0) {
            help(s.substring(1), index, str + s.substring(0, 1));
        } else {
            return;
        }
        // 二位地址
        if (s.length() > 1 && s.charAt(0) != '0') {
            help(s.substring(2), index, str + s.substring(0, 2));
        } else {
            return;
        }
        // 三位地址
        if (s.length() > 2 && s.charAt(0) != '0') {
            int num = Integer.parseInt(s.substring(0, 3));
            if (num <= 255) {
                help(s.substring(3), index, str + num);
            }
        }
    }
}
