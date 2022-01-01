package cn.shui.learning_plan.offerII;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shui.
 * @date 2021/12/30.
 * @time 11:58.
 * 复原IP
 */
public class Offer087 {
    public List<String> restoreIpAddress(String s) {
        List<String> ans = new ArrayList<>();
        helper(s, 0, 0, "", "", ans);
        return ans;
    }

    // 回溯
    private void helper(String s, int i, int segI, String seg, String ip, List<String> ans) {
        // 当前ip + seg符合要求
        if (i == s.length() && segI == 3 && isValid(seg)) {
            ans.add(ip + seg);
        } else if (i < s.length() && segI <= 3){
            String temp = seg + s.charAt(i);
            // 将当前字符串拼接到当前分段后，切拼接后的分段合法
            if (isValid(temp)) {
                helper(s, i + 1, segI, temp, ip, ans);
            }

            // 将当前作为新的分段数字的开始，但是必须满足一个ip的分段最多只有4个,并且当开始一个新的分段数字时前一个分段不能为空
            if (seg.length() > 0 && segI < 3) {
                helper(s, i + 1, segI + 1, "" + s.charAt(i), ip + seg + ".", ans);
            }
        }
    }

    // 判断分段合法性
    private boolean isValid(String seg) {
        return Integer.parseInt(seg) <= 255 && (seg.equals("0") || seg.charAt(0) != '0');
    }
}
