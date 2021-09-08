package cn.shui.learning_plan.datastruct_basic.second;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * @author shui.
 * @date 2021/9/6.
 * @time 11:34.
 * 设计哈希映射
 */
public class L706 {

    public static void main(String[] args) {
        List<Integer> temp = new ArrayList<>();
        temp.add(1);
        temp.add(2);
        temp.remove(1);
        System.out.println(temp);
    }

    private class MyHashMap1 {
        List<Integer> keyList;
        List<Integer> valueList;

        /**
         * Initialize your data structure here.
         */
        public MyHashMap1() {
            keyList = new ArrayList<>();
            valueList = new ArrayList<>();
        }

        /**
         * value will always be non-negative.
         */
        public void put(int key, int value) {
            if (keyList.contains(key)) {
                valueList.set(keyList.indexOf(key), value);
            } else {
                keyList.add(key);
                valueList.add(value);
            }
        }

        /**
         * Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
         */
        public int get(int key) {
            if (keyList.contains(key)) {
                return valueList.get(keyList.indexOf(key));
            }
            return -1;
        }

        /**
         * Removes the mapping of the specified value key if this map contains a mapping for the key
         */
        public void remove(int key) {
            if (keyList.contains(key)) {
                int index = keyList.indexOf(key);
                valueList.remove(index);
                keyList.remove(index);
            }
        }
    }

    private class MyHashMap2 {
        private class Pair {
            private int key;
            private int value;

            public Pair(int key, int value) {
                this.key = key;
                this.value = value;
            }

            public int getKey() {
                return key;
            }

            public int getValue() {
                return value;
            }

            public void setValue(int value) {
                this.value = value;
            }
        }

        private static final int BASE = 769;
        private LinkedList[] data;

        public MyHashMap2() {
            data = new LinkedList[BASE];
            for (int i = 0; i < BASE; i++) {
                data[i] = new LinkedList<Pair>();
            }
        }

        public void put(int key, int value) {
            int h = hash(key);
            Iterator<Pair> iterator = data[h].iterator();
            while (iterator.hasNext()) {
                Pair pair = iterator.next();
                if (pair.getKey() == key) {
                    pair.setValue(value);
                    return;
                }
            }
            data[h].offerLast(new Pair(key, value));
        }

        public int get(int key) {
            int h = hash(key);
            Iterator<Pair> iterator = data[h].iterator();
            while (iterator.hasNext()) {
                Pair pair = iterator.next();
                if (pair.getKey() == key) {
                    return pair.getValue();
                }
            }
            return -1;
        }

        public void remove(int key) {
            int h = hash(key);
            Iterator<Pair> iterator = data[h].iterator();
            while (iterator.hasNext()) {
                Pair pair = iterator.next();
                if (pair.getKey() == key) {
                    data[h].remove(pair);
                    return;
                }
            }
        }

        private int hash(int key) {
            return key % BASE;
        }
    }
}
