package cn.shui.learning_plan.offerII;

import java.util.HashSet;
import java.util.Set;

/**
 * @author shui.
 * @date 2021/12/23.
 * @time 11:18.
 * 实现前缀树
 */
public class Offer062 {
    private class Trie {

        private final Set<String> prefixSet;
        private final Set<String> wordSet;

        /**
         * Initialize your data structure here.
         */
        public Trie() {
            prefixSet = new HashSet<>();
            wordSet = new HashSet<>();
        }

        /**
         * Inserts a word into here.
         */
        public void insert(String word) {
            if (wordSet.contains(word)) {
                return;
            }
            wordSet.add(word);
            if (prefixSet.contains(word)) {
                return;
            }
            for (int i = 1; i <= word.length(); i++) {
                prefixSet.add(word.substring(0, i));
            }
        }

        /**
         * Returns if the word is in the trie.
         */
        public boolean search(String word) {
            return wordSet.contains(word);
        }

        /**
         * Returns if there is any word in the trie that starts with the given prefix.
         */
        public boolean startsWith(String prefix) {
            return prefixSet.contains(prefix);
        }
    }

    // 字典树
    private class Trie2 {

        private Trie2[] children;
        private boolean isEnd;

        public Trie2() {
            children = new Trie2[26];
            isEnd = false;
        }

        public void insert(String word) {
            Trie2 node = this;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                int index = ch - 'a';
                if (node.children[index] == null) {
                    node.children[index] = new Trie2();
                }
                node = node.children[index];
            }
            node.isEnd = true;
        }

        public boolean search(String word) {
            Trie2 node = searchPrefix(word);
            return node != null && node.isEnd;
        }

        public boolean startsWith(String prefix) {
            return searchPrefix(prefix) != null;
        }

        private Trie2 searchPrefix(String prefix) {
            Trie2 node = this;
            for (int i = 0; i < prefix.length(); i++) {
                char ch = prefix.charAt(i);
                int index = ch - 'a';
                if (node.children[index] == null) {
                    return null;
                }
                node = node.children[index];
            }
            return node;
        }
    }
}
