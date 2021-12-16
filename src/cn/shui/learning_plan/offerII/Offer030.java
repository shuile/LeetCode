package cn.shui.learning_plan.offerII;

import java.util.*;

/**
 * @author shui.
 * @date 2021/12/14.
 * @time 18:01.
 * 插入、删除和随机访问都是O(1)的容器
 */
public class Offer030 {
    private class RandomizedSet {

        private Map<Integer, Integer> mMap;
        private List<Integer> mList;
        private Random mRandom;

        /**
         * Initialize your data structure here.
         */
        public RandomizedSet() {
            mMap = new HashMap<>();
            mList = new ArrayList<>();
            mRandom = new Random();
        }

        /**
         * Inserts a value to the set. Returns true if the set did not already contain the specified element.
         */
        public boolean insert(int val) {
            if (mMap.containsKey(val)) {
                return false;
            }
            mMap.put(val, mList.size());
            mList.add(val);
            return true;
        }

        /**
         * Removes a value from the set. Returns true if the set contained the specified element.
         */
        public boolean remove(int val) {
            if (!mMap.containsKey(val)) {
                return false;
            }
            int index = mMap.get(val);
            int lastNum = mList.get(mList.size() - 1);
            mMap.put(lastNum, index);
            mList.set(index, lastNum);
            mMap.remove(val);
            mList.remove(mList.size() - 1);
            return true;
        }

        /**
         * Get a random element from the set.
         */
        public int getRandom() {
            int index = mRandom.nextInt(mList.size());
            return mList.get(index);
        }
    }
}
