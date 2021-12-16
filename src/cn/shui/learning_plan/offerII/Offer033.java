package cn.shui.learning_plan.offerII;

import java.util.*;

/**
 * @author shui.
 * @date 2021/12/16.
 * @time 13:39.
 * 变位词组
 */
public class Offer033 {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        if (strs == null || strs.length < 1) {
            return ans;
        }
        int len = strs.length;
        if (len == 2) {
            List<String> list = new ArrayList<>();
            list.add(strs[0]);
            ans.add(list);
            return ans;
        }
        for (int i = 0; i < len; i++) {
            if (strs[i] == null) {
                continue;
            }
            List<String> list = new ArrayList<>();
            list.add(strs[i]);
            for (int j = i + 1; j < len; j++) {
                if (strs[j] == null) {
                    continue;
                }
                if (isAnagrams(strs[i], strs[j])) {
                    list.add(strs[j]);
                    strs[j] = null;
                }
            }
            strs[i] = null;
            ans.add(list);
        }
        return ans;
    }

    private boolean isAnagrams(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] temp = new int[26];
        int diff = 0;
        for (char ch : s.toCharArray()) {
            int index = ch - 'a';
            if (temp[index] == 0) {
                diff++;
            }
            temp[index]++;
        }
        for (char ch : t.toCharArray()) {
            int index = ch - 'a';
            if (temp[index] == 0) {
                return false;
            }
            temp[index]--;
            if (temp[index] == 0) {
                diff--;
            }
        }
        return diff == 0;
    }

    // 哈希表
    public List<List<String>> groupAnagrams2(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            List<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(str);
            map.put(key, list);
        }
        return new ArrayList<>(map.values());
    }
}
