package cn.shui.learning_plan.offerII;

/**
 * @author shui.
 * @date 2021/12/10.
 * @time 15:26.
 * 回文子字符串的个数
 */
public class Offer020 {
    public int countSubstrings(String s) {
        int len = s.length();
        if (len < 2) {
            return len;
        }
        int ans = 0;
        for (int i = 0; i < len; i++) {
            // 以i为中心
            int l = i, r = i;
            while (l >= 0 && r < len && s.charAt(l) == s.charAt(r)) {
                ans++;
                l--;
                r++;
            }
            if (i + 1 < len) {
                // 以i，i + 1位中心
                l = i;
                r = i + 1;
                while (l >= 0 && r < len && s.charAt(l) == s.charAt(r)) {
                    ans++;
                    l--;
                    r++;
                }
            }
        }
        return ans;
    }
}
