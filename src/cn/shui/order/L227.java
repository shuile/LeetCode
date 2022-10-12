package cn.shui.order;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * Created by chenyiting on 2022/10/12
 * 基本计算器II
 */
public class L227 {
    public int calculate(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int len = s.length();
        int flag = 1;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);
            if (ch >= '0' && ch <= '9') {
                int temp = 0;
                while (ch >= '0' && ch <= '9') {
                    temp = temp * 10 + ch - '0';
                    i++;
                    if (i >= len) {
                        break;
                    }
                    ch = s.charAt(i);
                }
                stack.push(temp * flag);
            }
            if(i >= len || ch == ' ') {
                continue;
            }
            if (ch == '+') {
                flag = 1;
                continue;
            }
            if (ch == '-') {
                flag = -1;
                continue;
            }
            if (ch == '*') {
                int temp = 0;
                i++;
                ch = s.charAt(i);
                while (ch == ' ') {
                    i++;
                    ch = s.charAt(i);
                }
                while (ch >= '0' && ch <= '9') {
                    temp = temp * 10 + ch - '0';
                    i++;
                    if (i >= len) {
                        break;
                    }
                    ch = s.charAt(i);
                }
                i--;
                stack.push(stack.pop() * temp);
            } else {
                int temp = 0;
                i++;
                ch = s.charAt(i);
                while (ch == ' ') {
                    i++;
                    ch = s.charAt(i);
                }
                while (ch >= '0' && ch <= '9') {
                    temp = temp * 10 + ch - '0';
                    i++;
                    if (i >= len) {
                        break;
                    }
                    ch = s.charAt(i);
                }
                i--;
                stack.push(stack.pop() / temp);
            }
        }
        int ans = 0;
        for (int num : stack) {
            ans += num;
        }
        return ans;
    }

    // 官方题解：栈
    public int calculate2(String s) {
        Deque<Integer> stack = new ArrayDeque<>();
        char preSign = '+';
        int num = 0;
        int len = s.length();
        for (int i = 0; i < len; i++) {
            if (Character.isDigit(s.charAt(i))) {
                num = num * 10 + s.charAt(i) - '0';
            }
            if (!Character.isDigit(s.charAt(i)) && s.charAt(i) != ' ' || i == len - 1) {
                switch (preSign) {
                    case '+':
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(-num);
                        break;
                    case '*':
                        stack.push(stack.pop() * num);
                        break;
                    case '/':
                        stack.push(stack.pop() / num);
                        break;
                }
                preSign = s.charAt(i);
                num = 0;
            }
        }
        int ans = 0;
        while (!stack.isEmpty()) {
            ans += stack.pop();
        }
        return ans;
    }

    public static void main(String[] args) {
        L227 test = new L227();
        System.out.println(test.calculate("2*3-4"));
    }
}
