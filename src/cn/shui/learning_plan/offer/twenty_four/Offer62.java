package cn.shui.learning_plan.offer.twenty_four;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shui.
 * @date 2021/10/21.
 * @time 11:42.
 */
public class Offer62 {
    public int lastRemaining(int n, int m) {
        if (n == 1 || m == 1) {
            return n - 1;
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        int cur = 0;
        while (list.size() != 1) {
            cur = (cur + m - 1) % list.size();
            list.remove(cur);
            cur %= list.size();
        }
        return list.get(0);
    }

    // 数学 + 递归
    public int lastRemaining2(int n, int m) {
        return f(n, m);
    }

    private int f(int n, int m) {
        if (n == 1) {
            return 0;
        }
        int x = f(n - 1, m);
        return (m + x) % n;
    }

    public int lastRemaining3(int n, int m) {
        int x = 0;
        for (int i = 2; i <= n; i++) {
            x = (x + m) % i;
        }
        return x;
    }
}
