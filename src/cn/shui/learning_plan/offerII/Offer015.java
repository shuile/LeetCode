package cn.shui.learning_plan.offerII;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shui.
 * @date 2021/12/9.
 * @time 12:02.
 * 字符串中的所有变位词
 */
public class Offer015 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        int sLen = s.length(), pLen = p.length();
        if (pLen > sLen) {
            return ans;
        }
        int[] cnt = new int[26];
        for (int i = 0; i < pLen; i++) {
            cnt[p.charAt(i) - 'a']--;
            cnt[s.charAt(i) - 'a']++;
        }
        int diff = 0;
        for (int c : cnt) {
            if (c != 0) {
                diff++;
            }
        }
        if (diff == 0) {
            ans.add(0);
        }
        for (int i = pLen; i < sLen; i++) {
            int x = s.charAt(i) - 'a', y = s.charAt(i - pLen) - 'a';
            if (x == y) {
                if (diff == 0) {
                    ans.add(i - pLen + 1);
                }
                continue;
            }
            if (cnt[x] == 0) {
                diff++;
            }
            cnt[x]++;
            if (cnt[x] == 0) {
                diff--;
            }
            if (cnt[y] == 0) {
                diff++;
            }
            cnt[y]--;
            if (cnt[y] == 0) {
                diff--;
            }
            if (diff == 0) {
                ans.add(i - pLen + 1);
            }
        }
        return ans;
    }
}
