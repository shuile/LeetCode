package cn.shui.order;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author shui.
 * @date 2021/11/16.
 * @time 11:12.
 * LRU缓存机制
 */
public class L146 {

    public static void main(String[] args) {
        LRUCache test = new LRUCache(2);
        test.put(1, 1);
        test.put(2, 2);
        test.get(1);
        test.put(3, 3);
        test.get(2);
        test.put(4, 4);
        test.get(1);
        test.get(3);
        test.get(4);
    }

    private static class LRUCache {

        private final List<Integer> mKeys;
        private final List<Integer> mValues;
        private int mCapacity;

        public LRUCache(int capacity) {
            mCapacity = capacity;
            mKeys = new ArrayList<>();
            mValues = new ArrayList<>();
        }

        public int get(int key) {
            int ret = -1;
            if (mKeys.contains(key)) {
                int index = mKeys.indexOf(key);
                if (mCapacity == 1) {
                    ret = mValues.get(index);
                } else {
                    ret = mValues.remove(index);
                    mKeys.add(mKeys.remove(index));
                    mValues.add(ret);
                }
            }
            return ret;
        }

        public void put(int key, int value) {
            if (mKeys.contains(key)) {
                get(key);
                mValues.set(mKeys.indexOf(key), value);
                return;
            }
            if (mKeys.size() >= mCapacity) {
                mKeys.remove(0);
                mValues.remove(0);
            }
            mKeys.add(key);
            mValues.add(value);
        }
    }

    // 哈希表 + 双向链表
    private static class LRUCache2 {
        class DLinkedNode {
            int key;
            int value;
            DLinkedNode prev;
            DLinkedNode next;

            public DLinkedNode() {
            }

            public DLinkedNode(int key, int value) {
                this.key = key;
                this.value = value;
            }
        }

        private Map<Integer, DLinkedNode> cache = new HashMap<>();
        private int size;
        private int capacity;
        private DLinkedNode head, tail;

        public LRUCache2(int capacity) {
            this.size = 0;
            this.capacity = capacity;
            head = new DLinkedNode();
            tail = new DLinkedNode();
            head.next = tail;
            tail.prev = head;
        }

        public int get(int key) {
            DLinkedNode node = cache.get(key);
            if (node == null) {
                return -1;
            }
            // 如果key存在，先通过哈希表定位，再移到头部
            moveToHead(node);
            return node.value;
        }

        public void put(int key, int value) {
            DLinkedNode node = cache.get(key);
            if (node == null) {
                // 如果key不存在，创建一个新的节点
                DLinkedNode newNode = new DLinkedNode(key, value);
                // 添加进哈希表
                cache.put(key, newNode);
                // 添加至双向链表的头部
                addToHead(newNode);
                size++;
                if (size > capacity) {
                    // 如果超出容量，删除双向链表的尾部节点
                    DLinkedNode tail = removeTail();
                    // 删除哈希表中对应的项
                    cache.remove(tail.key);
                    --size;
                }
            } else {
                // 如果key存在，先通过哈希表定位，在修改value，并移动到头部
                node.value = value;
                moveToHead(node);
            }
        }

        private void addToHead(DLinkedNode node) {
            node.prev = head;
            node.next = head.next;
            head.next.prev = node;
            head.next = node;
        }

        private void removeNode(DLinkedNode node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        private void moveToHead(DLinkedNode node) {
            removeNode(node);
            addToHead(node);
        }

        private DLinkedNode removeTail() {
            DLinkedNode res = tail.prev;
            removeNode(res);
            return res;
        }
    }
}
