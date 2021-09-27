package cn.shui.learning_plan.offer.third;

/**
 * @author shui.
 * @date 2021/9/27.
 * @time 09:29.
 */
public class Offer58II {
    public String reverseLeftWords(String s, int n) {
        if (s == null || s.length() < 2) {
            return s;
        }
        int len = s.length();
        n %= len;
        return s.substring(n, len) + s.substring(0, n);
    }
}
