package cn.shui.learning_plan.offerII;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author shui.
 * @date 2021/12/18.
 * @time 21:02.
 * 最近请求次数
 */
public class Offer042 {
    private class RecentCounter {

        private final Queue<Integer> mQueue;

        public RecentCounter() {
            mQueue = new LinkedList<>();
        }

        public int ping(int t) {
            while (!mQueue.isEmpty() && mQueue.peek() < t - 3000) {
                mQueue.poll();
            }
            mQueue.offer(t);
            return mQueue.size();
        }
    }
}
