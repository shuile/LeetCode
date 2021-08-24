package cn.shui.learning_plan.datastruct.ninth;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author shui.
 * @date 2021/8/24.
 * @time 10:00.
 * 用栈实现队列
 */
public class L232 {

    private static class MyQueue1 {

        Deque<Integer> receive;
        Deque<Integer> send;

        public MyQueue1() {
            receive = new LinkedList<>();
            send = new LinkedList<>();
        }

        public void push(int x) {
            receive.push(x);
            transfer();
        }

        public int pop() {
            if (empty()) {
                return -1;
            }
            transfer();
            return send.pop();
        }

        public int peek() {
            if (empty()) {
                return -1;
            }
            transfer();
            return send.peek();
        }

        public boolean empty() {
            return receive.isEmpty() && send.isEmpty();
        }

        private void transfer() {
            if (send.isEmpty()) {
                while (!receive.isEmpty()) {
                    send.push(receive.pop());
                }
            }
        }
    }

    private static class MyQueue2 {

        Deque<Integer> inStack;
        Deque<Integer> outStack;

        public MyQueue2() {
            inStack = new LinkedList<>();
            outStack = new LinkedList<>();
        }

        public void push(int x) {
            inStack.push(x);
        }

        public int pop() {
            if (outStack.isEmpty()) {
                in2out();
            }
            return outStack.pop();
        }

        public int peek() {
            if (outStack.isEmpty()) {
                in2out();
            }
            return outStack.peek();
        }

        public boolean empty() {
            return inStack.isEmpty() && outStack.isEmpty();
        }

        private void in2out() {
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
        }
    }
}
