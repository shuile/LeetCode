package cn.shui.learning_plan.datastruct.ninth;

import java.util.*;

/**
 * @author shui.
 * @date 2021/8/24.
 * @time 09:32.
 * 有效的括号
 */
public class L20 {
    public boolean isValid1(String s) {
        if (s == null || s.length() % 2 != 0) {
            return false;
        }
        Map<Character, Character> map = new HashMap<Character, Character>() {
            {
                put('(', ')');
                put('[', ']');
                put('{', '}');
            }
        };
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (stack.isEmpty()) {
                if (map.containsKey(c)) {
                    stack.push(c);
                } else {
                    return false;
                }
            } else {
                if (map.containsKey(c)) {
                    stack.push(c);
                } else {
                    if (map.get(stack.peek()) == c) {
                        stack.pop();
                    } else {
                        return false;
                    }
                }
            }
        }
        return stack.isEmpty();
    }

    // 栈
    public boolean isValid2(String s) {
        int n = s.length();
        if (n % 2 == 1) {
            return false;
        }
        Map<Character, Character> pairs = new HashMap<Character, Character>() {
            {
                put(')', '(');
                put(']', '[');
                put('}', '{');
            }
        };
        Deque<Character> stack = new LinkedList<>();
        for (char c : s.toCharArray()) {
            if (pairs.containsKey(c)) {
                if (stack.isEmpty() || stack.peek() != pairs.get(c)) {
                    return false;
                }
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}
