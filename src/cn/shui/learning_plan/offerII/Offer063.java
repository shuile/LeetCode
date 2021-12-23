package cn.shui.learning_plan.offerII;

import java.util.Arrays;
import java.util.List;

/**
 * @author shui.
 * @date 2021/12/23.
 * @time 11:52.
 * 替换单词
 */
public class Offer063 {

    public static void main(String[] args) {
        String s = "12 34254 4364";
        System.out.println(Arrays.toString(s.split("\\s+")));
    }

    public String replaceWords(List<String> dictionary, String sentence) {
        String[] split = sentence.split("\\s+");
        StringBuilder ans = new StringBuilder();
        for (String s : split) {
            for (int i = 1; i <= s.length(); i++) {
                if (dictionary.contains(s.substring(0, i))) {
                    s = s.substring(0, i);
                    break;
                }
            }
            ans.append(s).append(" ");
        }
        return ans.toString().trim();
    }

    // 前缀树
    public String replaceWords2(List<String> dictionary, String sentence) {
        String[] words = new String[dictionary.size()];
        for (int i = 0; i < words.length; i++) {
            words[i] = dictionary.get(i);
        }
        // 建树过程
        for (String word : words) {
            insert(root, word);
        }
        String[] strs = sentence.split("\\s+");
        for (int i = 0; i < strs.length; i++) {
            // 如果可以在树中找到对应单词的前缀，那么将这个单词替换为它的前缀
            if (search(root, strs[i])) {
                strs[i] = replace(strs[i], root);
            }
        }
        // 用StringBuilder来把字符串还原成源字符串巨子的转换目标字符串
        StringBuilder ans = new StringBuilder();
        for (String str : strs) {
            ans.append(str).append(" ");
        }
        return ans.toString().trim();
    }

    // 建前缀树模板
    private void insert(TrieNode root, String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            if (node.children[c - 'a'] == null) {
                node.children[c - 'a'] = new TrieNode();
            }
            node = node.children[c - 'a'];
        }
        node.isValid = true;
    }

    // 查询是否存在传入的字符串的前缀
    private boolean search(TrieNode root, String s) {
        TrieNode node = root;
        for (char c : s.toCharArray()) {
            if (node.isValid) {
                break;
            }
            if (node.children[c - 'a'] == null) {
                return false;
            }
            node = node.children[c - 'a'];
        }
        return true;
    }

    // 将传入的字符串替换为它在前缀树中的前缀字符串
    private String replace(String s, TrieNode root) {
        TrieNode node = root;
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (node.isValid || node.children[c - 'a'] == null) {
                break;
            }
            node = node.children[c - 'a'];
            sb.append(c);
        }
        return sb.toString();
    }

    private final TrieNode root = new TrieNode();

    private static class TrieNode {
        TrieNode[] children;
        boolean isValid;

        public TrieNode() {
            children = new TrieNode[26];
        }
    }
}
