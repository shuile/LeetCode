package cn.shui.order;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenyiting on 2025/2/19
 */
public class L390 {
    /**
     * 超出时间限制
     * @param n
     * @return
     */
    public int lastRemaining(int n) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
        boolean isRight = true;
        while (list.size() > 1) {
            if (isRight) {
                for (int i = 0; i < list.size(); i++) {
                    list.remove(i);
                }
            } else {
                // 0 1 2 3 4 5 6 7 8
                for (int i = list.size() - 1; i >= 0; i -= 2) {
                    list.remove(i);
                }
            }
            isRight = !isRight;
        }
        return list.isEmpty() ? 0 : list.get(0);
    }

    public int lastRemaining2(int n) {
        int a1 = 1;
        int k = 0, cnt = n, step = 1;
        while (cnt > 1) {
            if (k % 2 == 0) { // 正向
                a1 += step;
            } else { // 反向
                a1 = (cnt % 2 == 0) ? a1 : a1 + step;
            }
            k++;
            cnt = cnt >> 1;
            step = step << 1;
        }
        return a1;
    }
}
