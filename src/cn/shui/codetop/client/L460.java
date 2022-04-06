package cn.shui.codetop.client;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 * Created by chenyiting on 2022/4/3
 * LFU缓存
 */
public class L460 {

    // 超时
    private static class LFUCache {
        private final Map<Integer, DLinkedNode> cache;
        private DLinkedNode head, tail;
        private int capacity;
        private int size;

        public LFUCache(int capacity) {
            this.capacity = capacity;
            size = 0;
            cache = new HashMap<>();
            head = new DLinkedNode();
            tail = new DLinkedNode();
            head.next = tail;
            tail.prev = head;
        }

        public int get(int key) {
            // 判断缓存中key值是否存在
            if (cache.containsKey(key)) {
                DLinkedNode node = cache.get(key);
                node.prev.next = node.next;
                node.next.prev = node.prev;
                node.next = head.next;
                head.next = node;
                node.next.prev = node;
                node.prev = head;
                node.increment();
                return node.value;
            } else {
                return -1;
            }
        }

        public void put(int key, int value) {
            if (capacity <= 0) {
                return;
            }
            // 判断缓存中key值是否存在
            if (cache.containsKey(key)) {
                DLinkedNode node = cache.get(key);
                node.prev.next = node.next;
                node.next.prev = node.prev;
                node.next = head.next;
                head.next = node;
                node.next.prev = node;
                node.prev = head;
                node.value = value;
                node.increment();
            } else {
                // 判断缓存是否达到最大容量
                if (size >= capacity) {
                    removeLeastFrequencyNode();
                }
                DLinkedNode node = new DLinkedNode(key, value);
                node.next = head.next;
                head.next = node;
                node.next.prev = node;
                node.prev = head;
                cache.put(key, node);
                size++;
            }
        }

        // 移除最不经常使用的节点
        private void removeLeastFrequencyNode() {
            if (size < capacity) {
                return;
            }
            DLinkedNode removeNode = tail.prev;
            if (removeNode == head) {
                return;
            }
            DLinkedNode node = removeNode.prev;
            while (node != head) {
                // 由于更靠近末尾的节点为最久未使用的节点，所以只有当count值小于要移除的节点的count值时，才进行替换
                if (node.getCount() < removeNode.getCount()) {
                    removeNode = node;
                }
                node = node.prev;
            }
            removeNode.prev.next = removeNode.next;
            removeNode.next.prev = removeNode.prev;
            cache.remove(removeNode.key);
            removeNode = null;
            size--;
        }

        private class DLinkedNode {
            public int key;
            public int value;
            public DLinkedNode prev;
            public DLinkedNode next;
            private int count = 1;

            public DLinkedNode() {

            }

            public DLinkedNode(int key, int value) {
                this.key = key;
                this.value = value;
            }

            public void increment() {
                count++;
            }

            public int getCount() {
                return count;
            }
        }
    }

    // 哈希表 + 平衡二叉树
    private static class LFUCache2 {
        private int capacity, time;
        private final Map<Integer, Node> keyTable;
        private TreeSet<Node> tree;

        public LFUCache2(int capacity) {
            this.capacity = capacity;
            time = 0;
            keyTable = new HashMap<>();
            tree = new TreeSet<>();
        }

        public int get(int key) {
            if (capacity == 0) {
                return -1;
            }
            if (keyTable.containsKey(key)) {
                Node cache = keyTable.get(key);
                tree.remove(cache);
                cache.count++;
                cache.time = ++time;
                tree.add(cache);
                keyTable.put(key, cache);
                return cache.value;
            } else {
                return -1;
            }
        }

        public void put(int key, int value) {
            if (capacity == 0) {
                return;
            }
            if (keyTable.containsKey(key)) {
                Node cache = keyTable.get(key);
                tree.remove(cache);
                cache.count++;
                cache.time = ++time;
                cache.value = value;
                tree.add(cache);
                keyTable.put(key, cache);
            } else {
                if (keyTable.size() == capacity) {
                    keyTable.remove(tree.first().key);
                    tree.remove(tree.first());
                }
                Node cache = new Node(1, ++time, key, value);
                keyTable.put(key, cache);
                tree.add(cache);
            }
        }

        private class Node implements Comparable<Node> {
            public int count, time, key, value;

            public Node(int count, int time, int key, int value) {
                this.count = count;
                this.time = time;
                this.key = key;
                this.value = value;
            }

            @Override
            public int compareTo(Node o) {
                return count == o.count ? time - o.time : count - o.count;
            }

            @Override
            public boolean equals(Object anotherObject) {
                if (this == anotherObject) {
                    return true;
                }
                if (anotherObject instanceof Node) {
                    Node node = (Node) anotherObject;
                    return count == node.count && time == node.time;
                }
                return false;
            }

            @Override
            public int hashCode() {
                return count * 1000000007 + time;
            }
        }
    }

    // 双哈希表
    private static class LFUCache3 {
        private int minFreq, capacity;
        private final Map<Integer, Node> keyTable;
        private final Map<Integer, DoublyLinkedList> freqTable;

        public LFUCache3(int capacity) {
            this.capacity = capacity;
            minFreq = 0;
            keyTable = new HashMap<>();
            freqTable = new HashMap<>();
        }

        public int get(int key) {
            if (capacity == 0) {
                return -1;
            }
            if (keyTable.containsKey(key)) {
                Node node = keyTable.get(key);
                int value = node.value, freq = node.freq;
                freqTable.get(freq).remove(node);
                // 如果当前链表为空，我们需要在哈希表中删除，且更新minFreq
                if (freqTable.get(freq).size == 0) {
                    freqTable.remove(freq);
                    if (minFreq == freq) {
                        minFreq++;
                    }
                }
                DoublyLinkedList list = freqTable.getOrDefault(freq + 1, new DoublyLinkedList());
                list.addFirst(new Node(key, value, freq + 1));
                freqTable.put(freq + 1, list);
                keyTable.put(key, freqTable.get(freq + 1).getHead());
                return value;
            } else {
                return -1;
            }
        }

        public void put(int key, int value) {
            if (capacity == 0) {
                return;
            }
            if (keyTable.containsKey(key)) {
                Node node = keyTable.get(key);
                int freq = node.freq;
                freqTable.get(freq).remove(node);
                if (freqTable.get(freq).size == 0) {
                    freqTable.remove(freq);
                    if (minFreq == freq) {
                        minFreq++;
                    }
                }
                DoublyLinkedList list = freqTable.getOrDefault(freq + 1, new DoublyLinkedList());
                list.addFirst(new Node(key, value, freq + 1));
                freqTable.put(freq + 1, list);
                keyTable.put(key, freqTable.get(freq + 1).getHead());
            } else {
                if (keyTable.size() == capacity) {
                    Node node = freqTable.get(minFreq).getTail();
                    keyTable.remove(node.key);
                    freqTable.get(minFreq).remove(node);
                    if (freqTable.get(minFreq).size == 0) {
                        freqTable.remove(minFreq);
                    }
                }
                DoublyLinkedList list = freqTable.getOrDefault(1, new DoublyLinkedList());
                list.addFirst(new Node(key, value, 1));
                freqTable.put(1, list);
                keyTable.put(key, freqTable.get(1).getHead());
                minFreq = 1;
            }
        }

        private class Node {
            public int key, value, freq;
            public Node prev, next;

            public Node() {
                this(-1, -1, 0);
            }

            public Node(int key, int value, int freq) {
                this.key = key;
                this.value = value;
                this.freq = freq;
            }
        }

        private class DoublyLinkedList {
            public Node head, tail;
            public int size;

            public DoublyLinkedList() {
                head = new Node();
                tail = new Node();
                head.next = tail;
                tail.prev = head;
                size = 0;
            }

            public void addFirst(Node node) {
                node.next = head.next;
                head.next = node;
                node.next.prev = node;
                node.prev = head;
                size++;
            }

            public void remove(Node node) {
                node.prev.next = node.next;
                node.next.prev = node.prev;
                size--;
            }

            public Node getHead() {
                return head.next;
            }

            public Node getTail() {
                return tail.prev;
            }
        }
    }

    public static void main(String[] args) {
        LFUCache cache = new LFUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));
        cache.put(3, 3);
        System.out.println(cache.get(2));
        System.out.println(cache.get(3));
        cache.put(4, 4);
        System.out.println(cache.get(1));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));
    }
}
