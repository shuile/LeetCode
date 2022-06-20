package cn.shui.test;

import java.util.*;

/**
 * Created by chenyiting on 2022/6/16
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] words = {"bookstore", "book", "store", "books", "tore", "store", "bookstores", "noise", "makingupset", "making", "upset", "noisemakingupset"};
        List<List<String>> allResult = solution.findAllResult(words);
        System.out.println(allResult);
    }

    private Set<String> set = new HashSet<>();

    private List<List<String>> ans = new ArrayList<>();

    private List<List<String>> findAllResult(String[] words) {
        Arrays.sort(words, (a, b) -> b.length() - a.length());
        for (String word : words) {
            if (word.equals("")) {
                continue;
            }
            set.add(word);
        }
        for (String word : words) {
            dfs(word, 0, new ArrayList<>());
        }
        return ans;
    }

    private void dfs(String s, int startIndex, List<String> temp) {
        if (startIndex == s.length()) {
            if (temp.size() >= 2) {
                ans.add(new ArrayList<>(temp));
            }
            return;
        }
        for (int i = startIndex; i <= s.length(); i++) {
            if (!set.contains(s.substring(startIndex, i))) {
                continue;
            }
            temp.add(s.substring(startIndex, i));
            dfs(s, i, temp);
            temp.remove(temp.size() - 1);
        }
    }
}
