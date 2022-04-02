package cn.shui.codetop.client;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by chenyiting on 2022/4/2
 * 字符串编码
 */
public class L394 {
    public String decodeString(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        int len = s.length();
        Deque<String> deque = new LinkedList<>();
        StringBuilder ans = new StringBuilder();
        StringBuilder temp = new StringBuilder();
        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);
            if (ch == ']') {
                // 弹出需要重复的字符
                while (!"[".equals(deque.peek())) {
                    temp.insert(0, deque.pop());
                }
                // 弹出'['
                deque.pop();
                String digits = "";
                while (!deque.isEmpty() && deque.peek().charAt(0) >= '0' && deque.peek().charAt(0) <= '9') {
                    digits = deque.pop() + digits;
                }
                int repeatCount = Integer.parseInt(digits);
                String repeatStr = temp.toString().trim();
                for (int j = 1; j < repeatCount; j++) {
                    temp.append(repeatStr);
                }
                if (deque.isEmpty()) {
                    ans.append(temp.toString().trim());
                } else {
                    deque.push(temp.toString().trim());
                }
                temp.replace(0, temp.length(), "");
            } else if (deque.isEmpty() && ch >= 'a' && ch <= 'z') {
                ans.append(ch);
            } else {
                deque.push(String.valueOf(ch));
            }
        }
        return ans.toString().trim();
    }

    public static void main(String[] args) {
        L394 test = new L394();
//        test.decodeString("3[a]2[bc]");
        test.decodeString("3[a2[c]]");
//        test.decodeString("3[z]2[2[y]pq4[2[jk]e1[f]]]ef");
    }
}
