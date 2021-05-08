package cn.shui.offer;

public class Offer_46 {
    public static void main(String[] args) {

    }

    private int translateNum(int num) {
        num = num < 0 ? -num : num;
        return help(String.valueOf(num), 0);
    }

    private int help(String s, int cur) {
        if (cur >= s.length() - 1) {
            return 1;
        }
        char ch = s.charAt(cur);
        int count = 0;
        if (ch == '1' || (ch == '2' && s.charAt(cur + 1) >= '0' && s.charAt(cur + 1) <= '5')) {
            count += help(s, cur + 2);
        }
        count += help(s, cur + 1);
        return count;
    }

    /**
     * 动态规划
     */
    private int translateNum2(int num) {
        String src = String.valueOf(num);
        int p = 0, q = 0, r = 1;
        for (int i = 0; i < src.length(); i++) {
            p = q;
            q = r;
            r = 0;
            r += q;
            if (i == 0) {
                continue;
            }
            String pre = src.substring(i - 1, i + 1);
            if (pre.compareTo("25") <= 0 && pre.compareTo("10") >= 0) {
                r += p;
            }
        }
        return r;
    }
}
