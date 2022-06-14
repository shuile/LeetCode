package cn.shui.codetop.client;

/**
 * Created by chenyiting on 2022/6/9
 * 翻转字符串中的单词II
 */
public class L557 {
    public String reverseWords(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        StringBuilder ans = new StringBuilder();
        int len = s.length(), start = 0, end = 0;
        while (start < len) {
            while (start < len && s.charAt(start) == ' ') {
                start++;
            }
            end = start;
            while (end < len && s.charAt(end) != ' ') {
                end++;
            }
            StringBuilder temp = new StringBuilder(s.substring(start, end));
            ans.append(temp.reverse()).append(" ");
            start = end;
        }
        return ans.toString().trim();
    }
}
