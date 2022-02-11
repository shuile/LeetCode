package cn.shui.learning_plan.beike.day_4;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * @author shui.
 * @date 2022/2/11.
 * @time 09:51.
 * 丑数II
 */
public class Beike_264 {

    // 小顶堆
    public int nthUglyNumber(int n) {
        int[] factors = {2, 3, 5};
        Set<Long> seen = new HashSet<>();
        PriorityQueue<Long> head = new PriorityQueue<>();
        seen.add(1L);
        head.offer(1L);
        int ugly = 0;
        for (int i = 0; i < n; i++) {
            long curr = head.poll();
            ugly = (int) curr;
            for (int factor : factors) {
                long next = curr * factor;
                if (seen.add(next)) {
                    head.offer(next);
                }
            }
        }
        return ugly;
    }

    // 动态规划
    public int nthUglyNumber2(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        int p2 = 1, p3 = 1, p5 = 1;
        for (int i = 2; i <= n; i++) {
            int num2 = dp[p2] * 2, num3 = dp[p3] * 3, num5 = dp[p5] * 5;
            dp[i] = Math.min(num2, Math.min(num3, num5));
            if (dp[i] == num2) {
                p2++;
            }
            if (dp[i] == num3) {
                p3++;
            }
            if (dp[i] == num5) {
                p5++;
            }
        }
        return dp[n];
    }
}
