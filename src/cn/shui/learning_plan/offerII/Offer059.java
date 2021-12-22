package cn.shui.learning_plan.offerII;

import java.util.PriorityQueue;

/**
 * @author shui.
 * @date 2021/12/22.
 * @time 14:48.
 * 数据流的第K大数值
 */
public class Offer059 {
    private class KthLargest {

        private final PriorityQueue<Integer> mQueue;
        private final int k;

        public KthLargest(int k, int[] nums) {
            this.k = k;
            mQueue = new PriorityQueue<>();
            for (int num : nums) {
                add(num);
            }
        }

        private int add(int val) {
            mQueue.offer(val);
            if (mQueue.size() > k) {
                mQueue.poll();
            }
            return mQueue.peek();
        }
    }
}
