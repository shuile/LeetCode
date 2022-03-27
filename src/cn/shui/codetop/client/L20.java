package cn.shui.codetop.client;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * Created by chenyiting on 2022/3/27
 * 有效的括号
 */
public class L20 {

    private final Map<Character, Character> map = new HashMap<Character, Character>() {{
        put('(', ')');
        put('[', ']');
        put('{', '}');
    }};

    public boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        Deque<Character> deque = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(' || ch == '[' || ch == '{') {
                deque.push(ch);
            } else if (!deque.isEmpty() && map.get(deque.peek()) == ch) {
                deque.pop();
            } else {
                return false;
            }
        }
        return deque.isEmpty();
    }
}
