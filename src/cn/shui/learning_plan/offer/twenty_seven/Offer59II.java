package cn.shui.learning_plan.offer.twenty_seven;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author shui.
 * @date 2021/11/21.
 * @time 10:37.
 * 队列的最大值
 */
public class Offer59II {

    private class MaxQueue {

        private Queue<Integer> queue;
        private Deque<Integer> deque;

        public MaxQueue() {
            queue = new LinkedList<>();
            deque = new LinkedList<>();
        }

        public int max_value() {
            return deque.isEmpty() ? -1 : deque.peekFirst();
        }

        public void push_back(int value) {
            queue.offer(value);
            while (!deque.isEmpty() && deque.peekLast() < value) {
                deque.pollLast();
            }
            deque.offerLast(value);
        }

        public int pop_value() {
            if (queue.isEmpty()) {
                return -1;
            }
            if (queue.peek().equals(deque.peekFirst())) {
                deque.pollFirst();
            }
            return queue.poll();
        }
    }
}
