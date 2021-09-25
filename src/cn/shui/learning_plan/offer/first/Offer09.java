package cn.shui.learning_plan.offer.first;

import java.util.Stack;

/**
 * @author shui.
 * @date 2021/9/25.
 * @time 20:28.
 * 用两个栈实现队列
 */
public class Offer09 {

    private static class CQueue {
        Stack<Integer> stack1;
        Stack<Integer> stack2;

        public CQueue() {
            stack1 = new Stack<>();
            stack2 = new Stack<>();
        }

        public void appendTail(int value) {
            stack1.push(value);
        }

        public int deleteHead() {
            if (stack2.isEmpty()) {
                while (!stack1.isEmpty()) {
                    stack2.push(stack1.pop());
                }
            }
            return stack2.isEmpty() ? -1 : stack2.pop();
        }
    }
}
