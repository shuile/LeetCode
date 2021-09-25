package cn.shui.learning_plan.offer.first;

import java.util.Stack;

/**
 * @author shui.
 * @date 2021/9/25.
 * @time 20:32.
 * 包含min函数的栈
 */
public class Offer30 {

    private static class MinStack {

        Stack<Integer> normal;
        Stack<Integer> min;

        public MinStack() {
            normal = new Stack<>();
            min = new Stack<>();
        }

        public void push(int x) {
            normal.push(x);
            if (min.isEmpty()) {
                min.push(x);
            } else {
                min.push(Math.min(x, min.peek()));
            }
        }

        public void pop() {
            normal.pop();
            min.pop();
        }

        public int top() {
            return normal.peek();
        }

        public int min() {
            return min.peek();
        }
    }
}
