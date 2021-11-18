package cn.shui.order;

/**
 * @author shui.
 * @date 2021/11/18.
 * @time 14:04.
 * 翻转字符串里的单词
 */
public class L151 {
    public String reverseWords(String s) {
        if (s == null || s.length() < 1) {
            return s;
        }
        StringBuilder ans = new StringBuilder();
        int start = s.length() - 1, end = start;
        while (start >= 0) {
            while (start >= 0 && s.charAt(start) == ' ') {
                start--;
            }
            if (start < 0) {
                break;
            }
            end = start;
            while (start >= 0 && s.charAt(start) != ' ') {
                start--;
            }
            if (start < 0) {
                ans.append(s, 0, end + 1);
            } else {
                ans.append(s, start + 1, end + 1).append(" ");
            }
        }
        return ans.toString().trim();
    }
}
