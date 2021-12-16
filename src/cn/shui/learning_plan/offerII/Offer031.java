package cn.shui.learning_plan.offerII;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author shui.
 * @date 2021/12/16.
 * @time 10:50.
 * 最近最少使用缓存
 */
public class Offer031 {

    public static void main(String[] args) {
        LRUCache test = new LRUCache(2);
        test.put(1, 1);
        test.put(2, 2);
        System.out.println(test.get(1));
        test.put(3, 3);
        System.out.println(test.get(2));
        test.put(4, 4);
        System.out.println(test.get(1));
        System.out.println(test.get(3));
        System.out.println(test.get(4));
    }

    private static class LRUCache {
        private Map<Integer, Integer> mMap;
        private List<Integer> mList;
        private final int mTotal;
        private int mSize = 0;

        public LRUCache(int capacity) {
            mTotal = capacity;
            mMap = new HashMap<>();
            mList = new ArrayList<>();
        }

        public int get(int key) {
            if (!mMap.containsKey(key)) {
                return -1;
            }
            mList.remove(key);
            mList.add(key);
            return mMap.get(key);
        }

        public void put(int key, int value) {
            if (mMap.containsKey(key)) {
                mMap.replace(key, value);
                mList.remove(key);
            } else {
                while (mSize >= mTotal && mList.size() > 0) {
                    mMap.remove(mList.get(0));
                    mList.remove(0);
                    mSize--;
                }
                mMap.put(key, value);
                mSize++;
            }
            mList.add(key);
        }
    }

    // 头插法
    private class LRUCache2 {
        class Node {
            Node pre, next;
            int key, val;

            public Node() {
            }

            public Node(int key, int val) {
                this.key = key;
                this.val = val;
            }
        }

        Node head = new Node();
        Node tail = new Node();
        int size = 0;
        Map<Integer, Node> map;

        public void deleteNode(Node node) {
            node.next.pre = node.pre;
            node.pre.next = node.next;
        }

        public void moveToHead(Node node) {
            deleteNode(node);
            addToHead(node);
        }

        public void addToHead(Node node) {
            Node after = head.next;
            head.next = node;
            node.next = after;
            after.pre = node;
            node.pre = head;
        }

        public LRUCache2(int capacity) {
            size = capacity;
            map = new HashMap<>();
            head.next = tail;
            tail.pre = head;
        }

        public int get(int key) {
            if (!map.containsKey(key)) {
                return -1;
            }
            Node node = map.get(key);
            moveToHead(node);
            return node.val;
        }

        public void put(int key, int val) {
            if (map.containsKey(key)) {
                Node node = map.get(key);
                node.val = val;
                map.put(key, node);
                moveToHead(node);
            } else {
                if (map.size() == size) {
                    Node node = tail.pre;
                    deleteNode(node);
                    map.remove(node.key);
                }
                Node node = new Node(key, val);
                map.put(key, node);
                addToHead(node);
            }
        }
    }

    private class LRUCache3 {
        class Node {
            Node pre;
            Node next;
            int key;
            int value;

            public Node(int key, int value) {
                this.key = key;
                this.value = value;
            }
        }

        public void deleteNode(Node node) {
            node.next.pre = node.pre;
            node.pre.next = node.next;
        }

        public void addToTail(Node node) {
            node.next = tail;
            tail.pre.next = node;
            node.pre = tail.pre;
            tail.pre = node;
        }

        public void moveToTail(Node node) {
            deleteNode(node);
            addToTail(node);
        }

        Map<Integer, Node> map;
        int size;
        Node head;
        Node tail;

        public LRUCache3(int capacity) {
            map = new HashMap<>();
            size = capacity;
            head = new Node(0, 0);
            tail = new Node(0, 0);
            head.next = tail;
            tail.pre = head;
        }

        public int get(int key) {
            if (!map.containsKey(key)) {
                return -1;
            }
            Node node = map.get(key);
            moveToTail(node);
            return node.value;
        }

        public void put(int key, int value) {
            if (map.containsKey(key)) {
                Node node = map.get(key);
                node.value = value;
                moveToTail(node);
            } else {
                if (map.size() == size) {
                    Node prev = head.next;
                    deleteNode(prev);
                    map.remove(prev.key);
                }
                Node node = new Node(key, value);
                addToTail(node);
                map.put(key, node);
            }
        }
    }
}
