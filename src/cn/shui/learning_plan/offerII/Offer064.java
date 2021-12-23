package cn.shui.learning_plan.offerII;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author shui.
 * @date 2021/12/23.
 * @time 14:50.
 * 神奇的字典
 */
public class Offer064 {

    public static void main(String[] args) {
        String[] dictionary = {"hello", "hallo", "leetcode"};
        MagicDictionary test = new MagicDictionary();
        test.buildDictionary(dictionary);
        test.search("hello");
        test.search("hhllo");
        test.search("hell");
        test.search("leetcoded");
    }

    private static class MagicDictionary {

        private final TrieNode mRoot;

        /**
         * Initialize your data structure here.
         */
        public MagicDictionary() {
            mRoot = new TrieNode();
        }

        public void buildDictionary(String[] dictionary) {
            for (String s : dictionary) {
                insert(mRoot, s);
            }
        }

        public boolean search(String searchWord) {
            return search(mRoot, searchWord, 0, false);
        }

        private void insert(TrieNode root, String s) {
            TrieNode node = root;
            for (char c : s.toCharArray()) {
                if (node.children[c - 'a'] == null) {
                    node.children[c - 'a'] = new TrieNode();
                }
                node = node.children[c - 'a'];
            }
            node.isValid = true;
        }

        private boolean search(TrieNode node, String s, int index, boolean isModified) {
            if (index >= s.length()) {
                return isModified && node.isValid;
            }
            int cnt = s.charAt(index) - 'a';
            if (node.children[cnt] == null) {
                if (isModified) {
                    return false;
                }
                for (int i = 0; i < 26; i++) {
                    if (i == cnt || node.children[i] == null) {
                        continue;
                    }
                    boolean res = search(node.children[i], s, index + 1, true);
                    if (res) {
                        return true;
                    }
                }
                return false;
            } else {
                boolean res = search(node.children[cnt], s, index + 1, isModified);
                if (res || isModified) {
                    return res;
                }
                for (int i = 0; i < 26; i++) {
                    if (i == cnt || node.children[i] == null) {
                        continue;
                    }
                    res = search(node.children[i], s, index + 1, true);
                    if (res) {
                        return true;
                    }
                }
                return false;
            }
        }

        private static class TrieNode {
            TrieNode[] children;
            boolean isValid;

            public TrieNode() {
                children = new TrieNode[26];
            }
        }
    }

    private static class MagicDictionary2 {

        // 存放字典单词
        Set<String> words;
        // 记录字典中所有广义邻居对应的个数
        Map<String, Integer> neighborCount;

        public MagicDictionary2() {
            words = new HashSet<>();
            neighborCount = new HashMap<>();
        }

        // 生成一个单词所有的广义邻居
        public String[] getNeighbors(String word) {
            // 广义邻居的个数=字符串的长度
            String[] neighbors = new String[word.length()];
            StringBuilder str = new StringBuilder(word);
            // 修改字符串中的各位上的字符来生成广义邻居
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                str.setCharAt(i, '*');
                neighbors[i] = str.toString();
                str.setCharAt(i, c);
            }
            return neighbors;
        }

        public void buildDictionary(String[] dictionary) {
            for (String s : dictionary) {
                words.add(s);
                for (String neighbor : getNeighbors(s)) {
                    neighborCount.put(neighbor, neighborCount.getOrDefault(neighbor, 0) + 1);
                }
            }
        }

        public boolean search(String searchWord) {
            for (String neighbor : getNeighbors(searchWord)) {
                int neighborNum = neighborCount.getOrDefault(neighbor, 0);
                if (neighborNum > 1 || neighborNum == 1 && !words.contains(searchWord)) {
                    return true;
                }
            }
            return false;
        }
    }
}
