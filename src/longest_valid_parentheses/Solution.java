package longest_valid_parentheses;

import java.util.Scanner;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        String str = "{\"m8\":\"0xd0x26\"}";
        String[] split = str.split("\"");
        String[] s = split[3].split("0x");
//        System.out.println(split[3].length());
        for (int i = 0; i < s.length; i++) {
//            System.out.println(i + " " + s[i]);
        }

        for (int i = 1; i < s.length; i++) {
            String s1 = s[i];
//            System.out.println(s1);
            s1 = s1.toUpperCase();
//            System.out.println(s1);
            if (s1.length() < 2) {
                s1 = "0" + s1;
            }
//            System.out.println(s1);
            char c1 = s1.charAt(0);
            char c2 = s1.charAt(1);
            byte b = 0;
            if (c1 >= '0' && c1 <= '9') {
                b += (c1 - '0') * 16;
            }
            if (c1 >= 'A' && c1 <= 'F') {
                b += (c1 - 'A' + 10) * 16;
            }
            if (c2 >= '0' && c2 <= '9') {
                b += c2 - '0';
            }
            if (c2 >= 'A' && c2 <= 'Z') {
                b += c2 - 'A' + 10;
            }
            System.out.println(s1 + "  " + b);
        }

        Scanner in = new Scanner(System.in);
//        System.out.println(longestValidParentheses(in.next()));
        in.close();
    }

    private static int longestValidParentheses(String s) {
        int maxans = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.empty()) {
                    stack.push(i);
                } else {
                    maxans = Math.max(maxans, i - stack.peek());
                }
            }
        }
        return maxans;
    }

    private static String toHexString(String str) {
        StringBuilder sb = new StringBuilder();
        String[] escapeArray = {"\b", "\t", "\n", "\f", "\r"};
        boolean flag = false;
        for (String escapeStr : escapeArray) {
            if (str.contains(escapeStr)) {
                flag = true;
                break;
            }
        }
        if (flag) {
            return null;
        }
        char[] hexArray = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        byte[] b = str.getBytes();
        int bit;
        for (int i = 0; i < b.length; i++) {
            bit = (b[i] & 0x0f0) >> 4;
            sb.append(hexArray[bit]);
            bit = b[i] & 0x0f;
            sb.append(hexArray[bit]);
        }
        return sb.toString();
    }
}
