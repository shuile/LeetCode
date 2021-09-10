package cn.shui.learning_plan.datastruct_basic.eighth;

import java.util.*;

/**
 * @author shui.
 * @date 2021/9/10.
 * @time 09:11.
 * 字母异位词分组
 */
public class L49 {

    public static void main(String[] args) {
        String[] strs = { "abc", "acb", "bac", "bca", "cab", "cba"};
        for (String s : strs) {
            System.out.println(s + " = " + s.hashCode());
        }

        Integer a = 1;
        a++;
        Integer b = 2;
        System.out.println(a.equals(b));
    }

    public List<List<String>> groupAnagrams1(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        if (strs == null || strs.length < 1) {
            return ans;
        }
        List<String> list = new ArrayList<>();
        int len = strs.length;
        for (int i = 0; i < len; i++) {
            if (strs[i] == null) {
                continue;
            }
            list.clear();
            list.add(strs[i]);
            Map<Character, Integer> map1 = getMap(strs[i]);
            for (int j = i + 1; j < len; j++) {
                if (strs[j] == null) {
                    continue;
                }
                if (isMapEquals(map1, getMap(strs[j]))) {
                    list.add(strs[j]);
                    strs[j] = null;
                }
            }
            ans.add(new ArrayList<>(list));
            strs[i] = null;
        }
        return ans;
    }

    private Map<Character, Integer> getMap(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        return map;
    }

    private boolean isMapEquals(Map<Character, Integer> map1, Map<Character, Integer> map2) {
        if (map1.size() != map2.size()) {
            return false;
        }
        for (Map.Entry<Character, Integer> entry : map1.entrySet()) {
            if (!map2.containsKey(entry.getKey()) || !entry.getValue().equals(map2.get(entry.getKey()))) {
                return false;
            }
        }
        return true;
    }
    // 排序
    public List<List<String>> groupAnagrams2(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] array = str.toCharArray();
            Arrays.sort(array);
            String key = new String(array);
            List<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(str);
            map.put(key, list);
        }
        return new ArrayList<>(map.values());
    }

    // 计数
    public List<List<String>> groupAnagrams3(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            int[] count = new int[26];
            int length = str.length();
            for (int i = 0; i < length; i++) {
                count[str.charAt(i) - 'a']++;
            }
            // 将每个出现次数大于0的字母和出现自述按顺序拼接成字符串，作为哈希表的键
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                if (count[i] != 0) {
                    sb.append((char) ('a' + i));
                    sb.append(count[i]);
                }
            }
            String key = sb.toString();
            List<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(str);
            map.put(key, list);
        }
        return new ArrayList<>(map.values());
    }
}
