package cn.shui.learning_plan.datastruct_basic.fourteenth;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shui.
 * @date 2021/9/15.
 * @time 16:23.
 * 找出游戏的获胜者
 */
public class L1823 {

    public static void main(String[] args) {
        L1823 test = new L1823();
        System.out.println(test.findTheWinner(6, 5));
    }

    public int findTheWinner(int n, int k) {
        if (n <= 1) {
            return n;
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
        int index = 0;
        int size = list.size();
        while (size > 1) {
            index = (index + k - 1) % (size);
            list.remove(index);
            size = list.size();
        }
        return list.get(0);
    }
}
