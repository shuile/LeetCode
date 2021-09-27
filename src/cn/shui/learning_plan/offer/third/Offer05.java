package cn.shui.learning_plan.offer.third;

/**
 * @author shui.
 * @date 2021/9/27.
 * @time 09:20.
 * 替换空格
 */
public class Offer05 {
    public String replaceSpace(String s) {
        if (s == null || s.length() < 1) {
            return s;
        }
        StringBuilder ans = new StringBuilder();
        int len = s.length();
        int start = 0;
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == ' ') {
                if (start != i) {
                    ans.append(s, start, i);
                }
                ans.append("%20");
                start = i + 1;
            }
        }
        if (start != len) {
            ans.append(s, start, len);
        }
        return ans.toString();
    }
}
