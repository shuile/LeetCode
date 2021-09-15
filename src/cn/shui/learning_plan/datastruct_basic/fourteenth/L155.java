package cn.shui.learning_plan.datastruct_basic.fourteenth;

import java.util.Stack;

/**
 * @author shui.
 * @date 2021/9/15.
 * @time 10:08.
 * 最小栈
 */
public class L155 {

    private static class MinStack {

        private Stack<Integer> dataStack;
        private Stack<Integer> minStack;
        /**
         * initialize your data structure here.
         */
        public MinStack() {
            dataStack = new Stack<>();
            minStack = new Stack<>();
        }

        public void push(int val) {
            dataStack.push(val);
            if (minStack.isEmpty()) {
                minStack.push(val);
            } else {
                minStack.push(Math.min(minStack.peek(), val));
            }
        }

        public void pop() {
            dataStack.pop();
            minStack.pop();
        }

        public int top() {
            return dataStack.peek();
        }

        public int getMin() {
            return minStack.peek();
        }
    }
}
