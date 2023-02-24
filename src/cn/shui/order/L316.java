package cn.shui.order;

import java.util.Stack;

/**
 * Created by chenyiting on 2023/2/24
 * 去除重复字母
 */
public class L316 {
    public String removeDuplicateLetters(String s) {
        Stack<Character> stack = new Stack<>();

        int[] count = new int[256];
        for (char c : s.toCharArray()) {
            count[c]++;
        }

        boolean[] inStack = new boolean[256];
        for (char c : s.toCharArray()) {
            count[c]--;
            if (inStack[c]) {
                continue;
            }
            while (!stack.isEmpty() && stack.peek() > c) {
                if (count[stack.peek()] == 0) {
                    break;
                }
                inStack[stack.pop()] = false;
            }
            stack.push(c);
            inStack[c] = true;
        }
        StringBuilder ans = new StringBuilder();
        while (!stack.isEmpty()) {
            ans.append(stack.pop());
        }
        return ans.reverse().toString();
    }
}
