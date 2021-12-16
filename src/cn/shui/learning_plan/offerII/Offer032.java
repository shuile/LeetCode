package cn.shui.learning_plan.offerII;

/**
 * @author shui.
 * @date 2021/12/16.
 * @time 13:31.
 * 有效的变位词
 */
public class Offer032 {
    public boolean isAnagram(String s, String t) {
        if (s == t || s.equals(t) || s.length() != t.length()) {
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
}
