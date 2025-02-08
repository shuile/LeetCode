package cn.shui.order;

import java.util.*;

/**
 * Created by chenyiting on 2024/7/18
 * Lexicographical Numbers
 */
public class L386 {

    private static int[] NUMBER = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

    public List<Integer> lexicalOrder(int n) {
        List<Integer> ans = new ArrayList<>();
        if (n < 1) {
            return ans;
        }
        help(ans, n, -1);
        return ans;
    }

    private void help(List<Integer> ans, int n, int curIdx) {
        if (ans.isEmpty()) {
            if (n == 1) {
                ans.add(1);
            } else {
                for (int i = 1; i < NUMBER.length; i++) {
                    if (i > n) {
                        break;
                    }
                    ans.add(i);
                    help(ans, n, ans.size() - 1);
                }
            }
        } else {
            int size = ans.size();
            if (curIdx >= size) {
                help(ans, n, curIdx + 1);
                return;
            }
            int cur = ans.get(curIdx);
            if (cur > n) {
                help(ans, n, curIdx + 1);
                return;
            }
            cur *= 10;
            if (cur > n) {
                help(ans, n, curIdx + 1);
                return;
            }
            for (int num : NUMBER) {
                if (cur + num > n) {
                    break;
                }
                ans.add(cur + num);
                help(ans, n, ans.size() - 1);
            }
            help(ans, n, ans.size() - 1);
        }
    }

    /**
     * 官方题解
     * @param n
     * @return
     */
    public List<Integer> lexicalOrder2(int n) {
        List<Integer> ans = new ArrayList<>();
        int num = 1;
        for (int i = 0; i < n; i++) {
            ans.add(num);
            if (num * 10 <= n) {
                num *= 10;
            } else {
                while (num % 10 == 9 || num + 1 > n) {
                    num /= 10;
                }
                num++;
            }
        }
        return ans;
    }
}
