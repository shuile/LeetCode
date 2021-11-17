package cn.shui.order;

import java.util.Stack;

/**
 * @author shui.
 * @date 2021/11/17.
 * @time 19:58.
 * 逆波兰表达式求值
 */
public class L150 {

    public static void main(String[] args) {
        L150 test = new L150();
        test.evalRPN(new String[]{"4", "13", "5", "/", "+"});
    }

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            char ch = token.charAt(0);
            if (ch >= '0' && ch <= '9' || token.length() > 1) {
                stack.push(Integer.parseInt(token));
                continue;
            }
            int a = stack.pop(), b = stack.pop();
            if (ch == '+') {
                stack.push(b + a);
            }
            if (ch == '-') {
                stack.push(b - a);
            }
            if (ch == '*') {
                stack.push(b * a);
            }
            if (ch == '/') {
                stack.push(b / a);
            }
        }
        return stack.size() == 1 ? stack.pop() : 0;
    }
}
