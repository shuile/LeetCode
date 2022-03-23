package cn.shui.codetop.client;

import java.util.*;

/**
 * Created by chenyiting on 2022/3/23
 */
public class L151 {
    public String reverseWords(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        s = " " + s;
        StringBuilder sb = new StringBuilder();
        int len = s.length();
        int end = len;
        for (int i = len - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                if (end - i > 1) {
                    sb.append(s.substring(i + 1, end)).append(" ");
                }
                end = i;
            }
        }
        return sb.toString().trim();
    }

    public String reverseWords2(String s) {
        s = s.trim();
        List<String> wordList = Arrays.asList(s.split("\\s+"));
        Collections.reverse(wordList);
        return String.join(" ", wordList);
    }

    // 队列
    public String reverseWords3(String s) {
        int left = 0, right = s.length() - 1;
        while (left <= right && s.charAt(left) == ' ') {
            left++;
        }
        while (left <= right && s.charAt(right) == ' ') {
            right--;
        }
        Deque<String> deque = new LinkedList<>();
        StringBuilder word = new StringBuilder();
        while (left <= right) {
            char c = s.charAt(left);
            if (word.length() > 0 && c == ' ') {
                deque.offerFirst(word.toString());
                word.setLength(0);
            } else if (c != ' ') {
                word.append(c);
            }
            left++;
        }
        deque.offerFirst(word.toString());
        return String.join(" ", deque);
    }
}
