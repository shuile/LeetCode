package cn.shui.order;

import java.util.*;

/**
 * Created by chenyiting on 2023/8/6
 * O(1)时间插入、删除和获取随机元素
 */
public class L380 {
    private static class RandomizedSet {

        private Set<Integer> set;

        public RandomizedSet() {
            set = new HashSet<>();
        }

        public boolean insert(int val) {
            if (set.contains(val)) {
                return false;
            }
            set.add(val);
            return true;
        }

        public boolean remove(int val) {
            if (set.contains(val)) {
                set.remove(val);
                return true;
            }
            return false;
        }

        public int getRandom() {
            if (set.isEmpty()) {
                return -1;
            }
            Object[] objects = set.toArray();
            return (Integer) objects[new Random().nextInt(set.size())];
        }
    }

    /**
     * 官方实现
     */
    private static class RandomizedSet2 {

        private List<Integer> nums;
        private Map<Integer, Integer> indices;
        private Random random;

        public RandomizedSet2() {
            nums = new ArrayList<>();
            indices = new HashMap<>();
            random = new Random();
        }

        private boolean insert(int val) {
            if (indices.containsKey(val)) {
                return false;
            }
            int index = nums.size();
            nums.add(val);
            indices.put(val, index);
            return true;
        }

        private boolean remove(int val) {
            if (!indices.containsKey(val)) {
                return false;
            }
            int index = indices.get(val);
            int last = nums.get(nums.size() - 1);
            nums.set(index, last);
            indices.put(last, index);
            nums.remove(nums.size() - 1);
            indices.remove(val);
            return true;
        }

        private int getRandom() {
            return nums.get(random.nextInt(nums.size()));
        }
    }
}
