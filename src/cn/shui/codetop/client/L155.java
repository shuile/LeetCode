package cn.shui.codetop.client;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by chenyiting on 2022/3/25
 * 最小栈
 */
public class L155 {
    private static class MinStack {

        private final Deque<Integer> original;
        private final Deque<Integer> min;

        public MinStack() {
            original = new LinkedList<>();
            min = new LinkedList<>();
        }

        public void push(int val) {
            original.push(val);
            if (min.isEmpty()) {
                min.push(val);
            } else {
                min.push(Math.min(min.peek(), val));
            }
        }

        public void pop() {
            original.pop();
            min.pop();
        }

        public int top() {
            return original.isEmpty() ? -1 : original.pop();
        }

        public int getMin() {
            return min.isEmpty() ? -1 : min.peek();
        }
    }
}
