package cn.shui.learning_plan.algorithms.forth_day;

/**
 * @author shui.
 * @date 2021/7/17.
 * @time 22:24.
 * 反转字符串中的单词III
 */
public class L557 {
    public String reverseWords1(String s) {
        if (s == null) {
            return s;
        }
        String[] ss = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String temp : ss) {
            sb.append(new StringBuilder(temp).reverse()).append(" ");
        }
        return sb.toString().trim();
    }

    public String reverseWords2(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }
        int len = s.length(), start = 0, end = 0;
        char ch;
        StringBuilder ans = new StringBuilder();
        while (end < len) {
            ch = s.charAt(end);
            if (ch == ' ') {
                ans.append(new StringBuilder(s.substring(start, end)). reverse()).append(" ");
                start = end + 1;
            }
            if (end == len - 1) {
                ans.append(new StringBuilder(s.substring(start, end + 1)).reverse());
            }
            end++;
        }
        return ans.toString().trim();
    }

    public String reverseWords3(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }
        StringBuilder ans = new StringBuilder();
        int len = s.length(), start, current = 0;
        while (current < len) {
            start = current;
            while (current < len && s.charAt(current) != ' ') {
                current++;
            }
            for (int i = start; i < current; i++) {
                ans.append(s.charAt(start + current - 1 - i));
            }
            while (current < len && s.charAt(current) == ' ') {
                current++;
                ans.append(" ");
            }
        }
        return ans.toString().trim();
    }
}
