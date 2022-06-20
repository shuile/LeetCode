package cn.shui.order;

import java.util.*;

/**
 * Created by chenyiting on 2022/6/16
 * 连接词
 */
public class L472 {

    private int P = 127, OFFSET = 128;
    private Set<Long> set = new HashSet<>();

    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        int len = words.length;
        List<String> ans = new ArrayList<>();

        for (int i = 0; i < len; i++) {
            long hash = 0;
            for (char c : words[i].toCharArray()) {
                hash = hash * P + (c - 'a') + OFFSET;
            }
            set.add(hash);
        }

        for (String s : words) {
            if (check(s)) {
                ans.add(s);
            }
        }

        return ans;
    }

    private boolean check(String s) {
        int len = s.length();
        int[] f = new int[len + 1];
        Arrays.fill(f, -1);
        f[0] = 0;

        for (int i = 0; i <= len; i++) {
            if (f[i] == -1) {
                continue;
            }
            long cur = 0;
            for (int j = i + 1; j <= len; j++) {
                cur = cur * P + (s.charAt(j - 1) - 'a') + OFFSET;
                if (set.contains(cur)) {
                    f[j] = Math.max(f[j], f[i] + 1);
                }
            }
            if (f[len] > 1) {
                return true;
            }
        }

        return false;
    }
}
