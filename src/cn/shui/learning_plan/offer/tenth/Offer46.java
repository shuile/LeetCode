package cn.shui.learning_plan.offer.tenth;

/**
 * @author shui.
 * @date 2021/10/13.
 * @time 10:25.
 */
public class Offer46 {
    public int translateNum(int num) {
        if (num < 0) {
            return 0;
        }
        return help(String.valueOf(num));
    }

    private int help(String num) {
        if (num == null || num.length() < 1) {
            return 1;
        }
        int sum = help(num.substring(1));
        if (num.charAt(0) != '0' && num.length() > 1) {
            int n = Integer.parseInt(num.substring(0, 2));
            if (n < 26) {
                sum += help(num.substring(2));
            }
        }
        return sum;
    }

    // 动态规划
    public int translateNum2(int num) {
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
