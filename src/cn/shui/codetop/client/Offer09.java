package cn.shui.codetop.client;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by chenyiting on 2022/3/30
 * 用两个栈实现队列
 */
public class Offer09 {
    private static class CQueue {
        private final Deque<Integer> deque1;
        private final Deque<Integer> deque2;

        public CQueue() {
            deque1 = new LinkedList<>();
            deque2 = new LinkedList<>();
        }

        public void appendToTail(int val) {
            deque1.push(val);
        }

        public int deleteHead() {
            if (deque2.isEmpty()) {
                while (!deque1.isEmpty()) {
                    deque2.push(deque1.poll());
                }
                return deque2.isEmpty() ? -1 : deque2.pop();
            } else {
                return deque2.pop();
            }
        }
    }
}
