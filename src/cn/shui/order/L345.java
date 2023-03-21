package cn.shui.order;

/**
 * Created by chenyiting on 2023/3/21
 * 反转字符串中的原因字母
 */
public class L345 {
    public String reverseVowels(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }
        StringBuilder left = new StringBuilder();
        StringBuilder right = new StringBuilder();
        int l = 0, r = s.length() - 1;
        while (l <= r) {
            while (l < r && !isVowel(s.charAt(l))) {
                left.append(s.charAt(l++));
            }
            while (l < r && !isVowel(s.charAt(r))) {
                right.append(s.charAt(r--));
            }
            if (l == r) {
                left.append(s.charAt(l));
            } else {
                left.append(s.charAt(r));
                right.append(s.charAt(l));
            }
            l++;
            r--;
        }
        return left.append(right.reverse()).toString();
    }

    public String reverseVowels2(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }
        char[] chars = s.toCharArray();
        int l = 0, r = chars.length - 1;
        while (l < r) {
            while (l < r && !isVowel(chars[l])) {
                l++;
            }
            while (l < r && !isVowel(chars[r])) {
                r--;
            }
            char ch = chars[l];
            chars[l] = chars[r];
            chars[r] = ch;
            l++;
            r--;
        }
        return new String(chars);
    }

    private boolean isVowel(char ch) {
        return ch == 'a' || ch == 'A' || ch == 'e' || ch == 'E' || ch == 'i' || ch == 'I'
                || ch == 'o' || ch == 'O' || ch == 'u' || ch == 'U';
    }
}
