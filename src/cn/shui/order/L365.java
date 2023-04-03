package cn.shui.order;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * Created by chenyiting on 2023/4/3
 * 水壶问题
 */
public class L365 {
    public boolean canMeasureWater(int jug1, int jug2, int target) {
        Deque<int[]> stack = new LinkedList<>();
        stack.push(new int[]{0, 0});
        Set<Long> seen = new HashSet<>();
        while (!stack.isEmpty()) {
            if (seen.contains(hash(stack.peek()))) {
                stack.pop();
                continue;
            }
            seen.add(hash(stack.peek()));
            int[] state = stack.pop();
            int remain1 = state[0], remain2 = state[1];
            if (remain1 == target || remain2 == target || remain1 + remain2 == target) {
                return true;
            }
            // 把1壶装满
            stack.push(new int[]{jug1, remain2});
            // 把2壶装满
            stack.push(new int[]{remain1, jug2});
            // 把1壶倒掉
            stack.push(new int[]{0, remain2});
            // 把2壶倒掉
            stack.push(new int[]{remain1, 0});
            // 把1壶的水灌进2壶，直至灌满或倒空
            stack.push(new int[]{remain1 - Math.min(remain1, jug2 - remain2), remain2 + Math.min(remain1, jug2 - remain2)});
            // 把2壶的水灌进1壶，直至灌满或倒空
            stack.push(new int[]{remain1 + Math.min(jug1 - remain1, remain2), remain2 - Math.min(jug1 - remain1, remain2)});
        }
        return false;
    }

    private long hash(int[] state) {
        return (long) state[0] * 1000001 + state[1];
    }
}
