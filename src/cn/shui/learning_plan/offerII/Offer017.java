package cn.shui.learning_plan.offerII;

/**
 * @author shui.
 * @date 2021/12/10.
 * @time 10:09.
 * 含有所有字符的最短字符串
 */
public class Offer017 {

    public String minWindow(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }
        String res = "";
        int st = 0;
        int minLength = s.length() + 1;
        int[] hash = new int[60];
        for (int i = 0; i < t.length(); i++) {
            hash[t.charAt(i) - 'A']++;
            hash[s.charAt(i) - 'A']--;
        }
        if (areAllZero(hash)) {
            return s.substring(0, t.length());
        }
        for (int i = t.length(); i < s.length(); i++) {
            hash[s.charAt(i) - 'A']--;
            while (areAllZero(hash)) {
                if (i - st + 1 < minLength) {
                    minLength = i - st + 1;
                    res = s.substring(st, st + minLength);
                }
                hash[s.charAt(st++) - 'A']++;
            }
        }
        return res;
    }

    private boolean areAllZero(int[] hash) {
        for (int x : hash) {
            if (x > 0) {
                return false;
            }
        }
        return true;
    }
}
