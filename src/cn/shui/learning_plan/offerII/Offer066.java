package cn.shui.learning_plan.offerII;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * @author shui.
 * @date 2021/12/24.
 * @time 16:17.
 * 单词只和
 */
public class Offer066 {

    public static void main(String[] args) {
        MapSum test = new MapSum();
        test.insert("apple", 3);
        System.out.println(test.sum("ap"));
        test.insert("app", 2);
        System.out.println(test.sum("ap"));
        test.insert("apple", 5);
        test.insert("apple", 1);
        System.out.println(test.sum("apple"));
    }

    private static class MapSum {

        private final Map<String, Integer> mData;
        private final Map<String, Integer> mSum;

        /**
         * Initialize your data structure here.
         */
        public MapSum() {
            mData = new HashMap<>();
            mSum = new HashMap<>();
        }

        public void insert(String key, int val) {
            if (mData.containsKey(key)) {
                int oldVal = mData.get(key);
                mData.replace(key, val);
                val -= oldVal;
            } else {
                mData.put(key, val);
            }
            for (int i = 1; i <= key.length(); i++) {
                String sub = key.substring(0, i);
                mSum.put(sub, mSum.getOrDefault(sub, 0) + val);
            }
        }

        public int sum(String prefix) {
            return mSum.getOrDefault(prefix, 0);
        }
    }

    private static class MapSum2 {

        private final TrieNode mRoot;

        public MapSum2() {
            mRoot = new TrieNode();
        }

        public void insert(String key, int val) {
            mRoot.insert(key, val);
        }

        public int sum(String prefix) {
            return mRoot.countSum(prefix);
        }

        private static class TrieNode {
            TrieNode[] children;
            int val;

            public TrieNode() {
                children = new TrieNode[26];
                val = 0;
            }

            public void  insert(String str, int val) {
                TrieNode node = this;
                for (char c : str.toCharArray()) {
                    if (node.children[c - 'a'] == null) {
                        node.children[c - 'a'] = new TrieNode();
                    }
                    node = node.children[c - 'a'];
                }
                node.val = val;
            }

            public int countSum(String prefix) {
                TrieNode node = this;
                for (char c : prefix.toCharArray()) {
                    if (node.children[c - 'a'] == null) {
                        return 0;
                    }
                    node = node.children[c - 'a'];
                }

                // BFS
                int count = 0;
                Queue<TrieNode> queue = new LinkedList<>();
                queue.offer(node);
                while (!queue.isEmpty()) {
                    TrieNode n = queue.poll();
                    count += n.val;
                    for (int i = 0; i < node.children.length; i++) {
                        if (node.children[i] != null) {
                            queue.offer(node.children[i]);
                        }
                    }
                }
                return count;
            }
        }
    }
}
