package cn.shui.order;

/**
 * @author shui.
 * @date 2021/11/8.
 * @time 09:51.
 * 验证回文串
 */
public class L125 {

    public static void main(String[] args) {
        L125 test = new L125();
        System.out.println(test.isPalindrome("0P"));
    }

    public boolean isPalindrome(String s) {
        if (s == null || s.length() < 2) {
            return true;
        }
        s = s.toLowerCase();
        StringBuilder sb = new StringBuilder(s);
        String reverseS = sb.reverse().toString().trim();
        int len = s.length(), count1 = 0, count2 = 0;
        while (count1 < len && count2 < len) {
            if (!isCharacter(s.charAt(count1))) {
                count1++;
            }
            if (!isCharacter(reverseS.charAt(count2))) {
                count2++;
            }
            if (count1 >= len || count2 >= len) {
                break;
            }
            if (s.charAt(count1) != reverseS.charAt(count2)) {
                return false;
            }
            count1++;
            count2++;
        }
        return true;
    }

    private boolean isCharacter(char ch) {
        return (ch >= 'a' && ch <= 'z') || (ch >= '0' && ch <= '9');
    }

    // 筛选 + 判断
    public boolean isPalindrome2(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isLetterOrDigit(ch)) {
                sb.append(Character.toLowerCase(ch));
            }
        }
        return sb.reverse().toString().equals(sb.toString());
    }

    // 在原字符上直接判断
    public boolean isPalindrome3(String s) {
        int l = 0, r = s.length() - 1;
        while (l < r) {
            while (l < r && !Character.isLetterOrDigit(s.charAt(l))) {
                l++;
            }
            while (l < r && !Character.isLetterOrDigit(s.charAt(r))) {
                r--;
            }
            if (l < r) {
                if (Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r))) {
                    return false;
                }
                l++;
                r--;
            }
        }
        return true;
    }
}
