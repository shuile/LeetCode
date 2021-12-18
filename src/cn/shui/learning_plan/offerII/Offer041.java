package cn.shui.learning_plan.offerII;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shui.
 * @date 2021/12/18.
 * @time 20:59.
 * 滑动窗口的平均值
 */
public class Offer041 {
    private class MovingAverage {
        private final int mSize;
        private final List<Integer> mList;
        private long mSum = 0;

        /**
         * Initialize your data structure here.
         */
        public MovingAverage(int size) {
            mSize = size;
            mList = new ArrayList<>();
        }

        public double next(int val) {
            mList.add(val);
            mSum += val;
            if (mList.size() > mSize) {
                mSum -= mList.get(0);
                mList.remove(0);
            }
            return mSum * 1.0 / mList.size();
        }
    }
}
