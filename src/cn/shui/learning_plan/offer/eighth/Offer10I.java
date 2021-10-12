package cn.shui.learning_plan.offer.eighth;

import java.util.HashMap;
import java.util.Map;

/**
 * @author shui.
 * @date 2021/10/12.
 * @time 09:49.
 */
public class Offer10I {

    // 超出时间限制
    public int fib(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return (fib(n - 1) + fib(n - 2)) % 1000000007;
    }

    // 优化
    Map<Integer, Integer> map = new HashMap<Integer, Integer>(){{
        put(0, 0);
        put(1, 1);
    }};

    public int fib2(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (!map.containsKey(n - 1)) {
            map.put(n - 1, fib(n - 1));
        }
        if (!map.containsKey(n - 2)) {
            map.put(n - 2, fib(n - 2));
        }
        long sum = 0;
        sum += map.get(n - 1);
        sum += map.get(n - 2);
        return (int) (sum % 1000000007);
    }

    // 循环求余法
    public int fib3(int n) {
        int a = 0, b = 1, sum;
        for (int i = 0; i < n; i++) {
            sum = (a + b) % 1000000007;
            a = b;
            b = sum;
        }
        return a;
    }
}
