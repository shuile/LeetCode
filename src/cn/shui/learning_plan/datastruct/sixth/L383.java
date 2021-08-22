package cn.shui.learning_plan.datastruct.sixth;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author shui.
 * @date 2021/8/21.
 * @time 22:54.
 * 赎金信
 */
public class L383 {
    public boolean canConstruct1(String ransomNote, String magazine) {
        int[] count1 = new int[26];
        int[] count2 = new int[26];
        Arrays.fill(count1, 0);
        Arrays.fill(count2, 0);
        for (int i = 0; i < ransomNote.length(); i++) {
            count1[ransomNote.charAt(i) - 'a']++;
        }
        for (int i = 0; i < magazine.length(); i++) {
            count2[magazine.charAt(i) - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (count1[i] != 0 && count1[i] > count2[i]) {
                return false;
            }
        }
        return true;
    }

    public boolean canConstruct2(String ransomNote, String magazine) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : ransomNote.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (char c : magazine.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) - 1);
        }
        for (int value : map.values()) {
            if (value > 0) {
                return false;
            }
        }
        return true;
    }
}
