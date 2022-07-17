package cn.shui.order;

/**
 * Created by chenyiting on 2022/7/16
 * 实现Trie(前缀树)
 */
public class L208 {
    private class Trie {

        public Trie[] children;
        public boolean isEnd = false;

        public Trie() {
            children = new Trie[26];
        }

        public void insert(String word) {
            if (word == null || word.length() == 0) {
                return;
            }
            int index = word.charAt(0) - 'a';
            Trie trie = children[index] == null ? new Trie() : children[index];
            if (word.length() == 1) {
                trie.isEnd = true;
            } else {
                trie.insert(word.substring(1));
            }
            children[index] = trie;
        }

        public boolean search(String word) {
            if (word == null) {
                return false;
            }
            if (word.length() == 0) {
                return true;
            }
            int index = word.charAt(0) - 'a';
            if (children[index] == null) {
                return false;
            }
            if (word.length() == 1) {
                return children[index].isEnd;
            }
            return children[index].search(word.substring(1));
        }

        public boolean startsWith(String prefix) {
            if (prefix == null) {
                return false;
            }
            if (prefix.length() == 0) {
                return true;
            }
            int index = prefix.charAt(0) - 'a';
            if (children[index] == null) {
                return false;
            }
            if (prefix.length() == 1) {
                return true;
            }
            return children[index].startsWith(prefix.substring(1));
        }
    }

    private class Trie2 {

        public Trie2[] children;

        public boolean isEnd;

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
