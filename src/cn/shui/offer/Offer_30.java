package cn.shui.offer;

import java.util.Stack;

public class Offer_30 {
    public static void main(String[] args) {

    }

    class MinStack {

        private Stack<Integer> stack;
        private Stack<Integer> minStack;

        public MinStack() {
            stack = new Stack<>();
            minStack = new Stack<>();
        }

        public void push(int x) {
            stack.push(x);
            if (!minStack.isEmpty()) {
                x = minStack.peek() > x ? x : minStack.peek();
            }
            minStack.push(x);
        }

        public void pop() {
            stack.pop();
            minStack.pop();
        }

        public int top() {
            return stack.peek();
        }

        public int min() {
            return minStack.peek();
        }
    }
}
