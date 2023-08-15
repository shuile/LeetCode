package cn.shui.order;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

/**
 * Created by chenyiting on 2023/8/8
 * 迷你语法分析器
 */
public class L385 {

    public static void main(String[] args) {
        L385 test = new L385();
        test.deserialize("[123,[456,[789]]]");
    }

    private int index = 0;

    /**
     * dfs
     */
    public NestedInteger deserialize(String s) {
        if (s == null || s.length() == 0) {
            return new NestedInteger();
        }
        if (s.charAt(0) == '[') {
            index++;
            NestedInteger ni = new NestedInteger();
            while (s.charAt(index) != ']') {
                ni.add(deserialize(s));
                if (s.charAt(index) == ',') {
                    index++;
                }
            }
            index++;
            return ni;
        } else {
            boolean negative = false;
            if (s.charAt(index) == '-') {
                negative = true;
                index++;
            }
            int num = 0;
            while (index < s.length() && Character.isDigit(s.charAt(index))) {
                num = num * 10 + s.charAt(index) - '0';
                index++;
            }
            if (negative) {
                num *= -1;
            }
            return new NestedInteger(num);
        }
    }

    /**
     * 栈
     */
    public NestedInteger deserialize2(String s) {
        if (s == null || s.length() == 0) {
            return new NestedInteger();
        }
        if (s.charAt(0) != '[') {
            return new NestedInteger(Integer.parseInt(s));
        }
        Deque<NestedInteger> deque = new ArrayDeque<>();
        int num = 0;
        boolean negative = false;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '-') {
                negative = true;
            } else if (c == '[') {
                deque.push(new NestedInteger());
            } else if (Character.isDigit(c)) {
                num = num * 10 + c - '0';
            } else if (c == ',' || c == ']') {
                if (Character.isDigit(s.charAt(i - 1))) {
                    if (negative) {
                        num *= -1;
                    }
                    deque.peek().add(new NestedInteger(num));
                }
                num = 0;
                negative = false;
                if (c == ']' && deque.size() > 1) {
                    NestedInteger ni = deque.pop();
                    deque.peek().add(ni);
                }
            }
        }
        return deque.pop();
    }

    private static class NestedInteger {
        public NestedInteger() {
        }

        public NestedInteger(int value) {
        }

        public boolean isInteger() {
            return true;
        }

        public Integer getInteger() {
            return 0;
        }

        public void setInteger(int value) {
        }

        public void add(NestedInteger ni) {
        }

        public List<NestedInteger> getList() {
            return null;
        }
    }
}
