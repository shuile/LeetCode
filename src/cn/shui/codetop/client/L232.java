package cn.shui.codetop.client;

import java.util.Stack;

/**
 * Created by chenyiting on 2022/3/20
 * 用栈实现队列
 */
public class L232 {
    public static class MyQueue {
        private final Stack<Integer> stack1;
        private final Stack<Integer> stack2;

        public MyQueue() {
            stack1 = new Stack<>();
            stack2 = new Stack<>();
        }

        public void push(int x) {
            stack1.push(x);
        }

        public int pop() {
            if (stack2.isEmpty()) {
                while (!stack1.isEmpty()) {
                    stack2.push(stack1.pop());
                }
            }
            return stack2.isEmpty() ? -1 : stack2.pop();
        }

        public int peek() {
            if (stack2.isEmpty()) {
                while (!stack1.isEmpty()) {
                    stack2.push(stack1.pop());
                }
            }
            return stack2.isEmpty() ? -1 : stack2.peek();
        }

        public boolean isEmpty() {
            return stack1.isEmpty() && stack2.isEmpty();
        }
    }
}
