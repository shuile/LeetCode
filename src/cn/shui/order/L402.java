package cn.shui.order;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by chenyiting on 2025/4/11
 * Remove K Digits
 */
public class L402 {

    /**
     * 超时
     */
    public String removeKDigits(String num, int k) {
        if (k == 0) {
            return "".equals(num) ? "0" : num;
        }
        String ans = num;
        int len = num.length();
        for (int i = 0; i < len; i++) {
            if (i > 1 && num.charAt(i - 1) == num.charAt(i)) {
                continue;
            }
            ans = minString(ans, removeKDigits(num.substring(0, i) + num.substring(i + 1), k - 1));
        }
        int startIndex = 0;
        int lenAns = ans.length();
        while (startIndex < lenAns && ans.charAt(startIndex) == '0') {
            startIndex++;
        }
        return startIndex < lenAns ? ans.substring(startIndex) : "0";
    }

    private String minString(String num1, String num2) {
        if ("".equals(num1) || "".equals(num2)) {
            return "";
        }
        int len1 = num1.length(), len2 = num2.length();
        String longStr = len1 > len2 ? num1 : num2;
        String shortStr = len1 > len2 ? num2 : num1;
        int lenL = longStr.length(), lenS = shortStr.length();
        int diff = lenL - lenS;
        if (diff > 0) {
            for (int i = 0; i < diff; i++) {
                if (longStr.charAt(i) != '0') {
                    return shortStr;
                }
            }
        }
        for (int i = 0; i < lenS; i++) {
            char cL = longStr.charAt(i + diff);
            char cS = shortStr.charAt(i);
            if (cL > cS) {
                return shortStr;
            } else if (cL < cS) {
                return longStr;
            }
        }
        return shortStr;
    }

    /**
     * 贪心 + 单调栈
     */
    public String removeKDigits2(String num, int k) {
        Deque<Character> deque = new LinkedList<>();
        int len = num.length();
        for (int i = 0; i < len; i++) {
            char digit = num.charAt(i);
            while (!deque.isEmpty() && k > 0 && deque.peekLast() > digit) {
                deque.pollLast();
                k--;
            }
            deque.offerLast(digit);
        }

        for (int i = 0; i < k; i++) {
            deque.pollLast();
        }
        StringBuilder ans = new StringBuilder();
        boolean leadingZero = true;
        while (!deque.isEmpty()) {
            char c = deque.pollFirst();
            if (leadingZero && c == '0') {
                continue;
            }
            leadingZero = false;
            ans.append(c);
        }
        return ans.length() == 0 ? "0" : ans.toString();
    }

    public static void main(String[] args) {
        L402 test = new L402();
        System.out.println(test.removeKDigits("1432219", 3));
    }
}
