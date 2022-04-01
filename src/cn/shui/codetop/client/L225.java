package cn.shui.codetop.client;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by chenyiting on 2022/4/1
 */
public class L225 {
    private static class MyStack {

        private Queue<Integer> queue1;
        private Queue<Integer> queue2;

        public MyStack() {
            queue1 = new LinkedList<>();
            queue2 = new LinkedList<>();
        }

        public void push(int x) {
            queue1.offer(x);
            while (!queue2.isEmpty()) {
                queue1.offer(queue2.poll());
            }
            Queue<Integer> temp = queue1;
            queue1 = queue2;
            queue2 = temp;
        }

        public int pop() {
            return queue2.isEmpty() ? -1 : queue2.poll();
        }

        public int top() {
            return queue2.isEmpty() ? -1 : queue2.peek();
        }

        public boolean empty() {
            return queue1.isEmpty() && queue2.isEmpty();
        }
    }

}
