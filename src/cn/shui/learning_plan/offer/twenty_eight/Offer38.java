package cn.shui.learning_plan.offer.twenty_eight;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author shui.
 * @date 2021/11/22.
 * @time 14:29.
 * 字符串的排列
 */
public class Offer38 {

    private final List<String> list = new ArrayList<>();

    // 超时
    public String[] permutation(String s) {
        if (s == null || s.length() < 1) {
            return new String[0];
        }
        if (s.length() == 1) {
            return new String[]{s};
        }
        boolean[] flag = new boolean[s.length()];
        help(s, flag, "");
        return list.toArray(new String[0]);
    }

    private void help(String s, boolean[] flag, String curr) {
        if (curr.length() == s.length()) {
            if (!list.contains(curr)) {
                list.add(curr);
            }
            return;
        }
        for (int i = 0; i < s.length(); i++) {
            if (flag[i]) {
                continue;
            }
            flag[i] = true;
            help(s, flag, curr + s.charAt(i));
            flag[i] = false;
        }
    }

    private final List<String> res = new ArrayList<>();
    private char[] c;

    // 剪枝
    public String[] permutation2(String s) {
        c = s.toCharArray();
        dfs(0);
        return res.toArray(new String[0]);
    }

    private void dfs(int x) {
        if (x == c.length - 1) {
            res.add(String.valueOf(c));
            return;
        }
        Set<Character> set = new HashSet<>();
        for (int i = x; i < c.length; i++) {
            if (set.contains(c[i])) {
                continue;
            }
            set.add(c[i]);
            swap(i, x);
            dfs(x + 1);
            swap(i, x);
        }
    }

    private void swap(int a, int b) {
        char tmp = c[a];
        c[a] = c[b];
        c[b] = tmp;
    }
}
