package cn.shui.learning_plan.offer.seventeenth;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author shui.
 * @date 2021/10/18.
 * @time 15:37.
 */
public class Offer41 {
    private static class MedianFinder {

        private final int[] data;
        private int size;

        /**
         * initialize your data structure here
         */
        public MedianFinder() {
            data = new int[50000];
            size = 0;
        }

        public void addNum(int num) {
            int curr = size;
            while (curr > 0 && data[curr - 1] > num) {
                data[curr] = data[curr - 1];
                curr--;
            }
            data[curr] = num;
            size++;
        }

        public double findMedian() {
            int mid = (size - 1) / 2;
            return size % 2 == 1 ? data[mid] : (data[mid] + data[mid + 1]) * 1.0 / 2;
        }
    }

    private static class MedianFinder2 {
        Queue<Integer> A, B;

        public MedianFinder2() {
            A = new PriorityQueue<>(); // 小顶堆，保存较大的
            B = new PriorityQueue<>((x, y) -> (y - x)); // 大顶堆，保存较小的
        }

        public void addNum(int num) {
            if (A.size() != B.size()) {
                A.add(num);
                B.add(A.poll());
            } else {
                B.add(num);
                A.add(B.poll());
            }
        }

        public double findMedian() {
            return A.size() != B.size() ? A.peek() : (A.peek() + B.peek()) / 2.0;
        }
    }
}
