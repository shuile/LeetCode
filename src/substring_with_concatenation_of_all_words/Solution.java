package substring_with_concatenation_of_all_words;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        String s = "lingmindraboofooowingdingbarrwingmonkeypoundcake";
        String[] words = {"fooo", "barr", "wing", "ding", "wing"};
        List<Integer> ansList = findSubstring(s, words);
        for (Integer i : ansList) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    /**
     * 网上找的
     * @param s
     * @param words
     * @return
     */
    private static List<Integer> findSubstring2(String s, String[] words) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if (s == null || s.length() == 0 || words == null || words.length == 0) {
            return res;
        }
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for (int i = 0; i < words.length; i++) {
            if (map.containsKey(words[i])) {
                map.put(words[i], map.get(words[i]) + 1);
            } else {
                map.put(words[i], 1);
            }
        }
        for (int i = 0; i < words[0].length(); i++) {
            HashMap<String, Integer> curMap = new HashMap<String, Integer>();
            int count = 0;
            int left = i;
            for (int j = i; j <= s.length() - words[0].length(); j += words[0].length()) {
                String str = s.substring(j, j + words[0].length());
                if (map.containsKey(str)) {
                    if (curMap.containsKey(str)) {
                        curMap.put(str, curMap.get(str) + 1);
                    } else {
                        curMap.put(str, 1);
                    }
                    if (curMap.get(str) <= map.get(str)) {
                        count++;
                    } else {
                        while (curMap.get(str) > map.get(str)) {
                            String temp = s.substring(left, left + words[0].length());
                            if (curMap.containsKey(temp)) {
                                curMap.put(temp, curMap.get(temp) - 1);
                                if (curMap.get(temp) < map.get(temp)) {
                                    count--;
                                }
                            }
                            left += words[0].length();
                        }
                    }
                    if (count == words.length) {
                        res.add(left);
                        //if(left<)
                        String temp = s.substring(left, left + words[0].length());
                        if (curMap.containsKey(temp)) {
                            curMap.put(temp, curMap.get(temp) - 1);
                        }
                        count--;
                        left += words[0].length();
                    }
                } else {
                    curMap.clear();
                    count = 0;
                    left = j + words[0].length();
                }
            }
        }
        return res;
    }

    /**
     * 第一种方法
     *
     * @param s
     * @param words
     * @return
     */
    private static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> ansList = new ArrayList<>();
        if (s == null || s.length() < 1 || words == null || words.length < 1 || words[0].length() < 1) {
            return ansList;
        }
        int totalLen = words.length * words[0].length();
        if (totalLen > s.length()) {
            return ansList;
        }
        boolean allContains;
        int countNot = 0;
        for (int i = 0; i <= s.length() - totalLen; i++) {
            String sub = s.substring(i, i + totalLen);
            allContains = true;
            for (String word : words) {
                if (!sub.contains(word)) {
                    allContains = false;
                    break;
                }
                countNot = 0;
                int count = sub.length() / word.length();
                for (int j = 0; j < count; j++) {
                    String subSub = sub.substring(j * word.length(), (j + 1) * word.length());
                    if (subSub.equals(word)) {
                        String frontSub = sub.substring(0, ((j - 1) >= 0) ? (j * word.length()) : 0);
                        String backSub = sub.substring(((j + 1) < count) ? ((j + 1) * word.length()) : sub.length(), sub.length());
                        sub = frontSub.concat(backSub);
                        break;
                    } else {
                        countNot++;
                    }
                }
                if (countNot == count) {
                    allContains = false;
                    break;
                }
            }
            if (allContains) {
                ansList.add(i);
            }
        }
        return ansList;
    }
}
