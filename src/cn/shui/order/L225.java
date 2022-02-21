package cn.shui.order;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author shui.
 * @date 2022/2/21.
 * @time 10:08.
 * 用队列实现栈
 */
public class L225 {
    private static class MyStack {

        private final Deque<Integer> mQueue1;
        private final Deque<Integer> mQueue2;

        public MyStack() {
            mQueue1 = new LinkedList<>();
            mQueue2 = new LinkedList<>();
        }

        public void push(int x) {
            mQueue1.offerLast(x);
        }

        public int pop() {
            moveData();
            return mQueue2.isEmpty() ? -1 : mQueue2.pollFirst();
        }

        public int top() {
            moveData();
            return mQueue2.isEmpty() ? -1 : mQueue2.peekFirst();
        }

        public boolean empty() {
            return mQueue1.isEmpty() && mQueue2.isEmpty();
        }

        private void moveData() {
            while (!mQueue1.isEmpty()) {
                mQueue2.offerFirst(mQueue1.pollFirst());
            }
        }
    }
}
