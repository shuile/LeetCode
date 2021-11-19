package cn.shui.order;

import java.util.HashMap;
import java.util.Map;

/**
 * @author shui.
 * @date 2021/11/19.
 * @time 10:03.
 * 整数替换
 */
public class L397 {

    public static void main(String[] args) {

    }

    private final Map<Long, Long> map = new HashMap<>();

    public int integerReplacement(int n) {
        return (int) help(n);
    }

    private long help(long n) {
        if (map.containsKey(n)) {
            return map.get(n);
        }
        if (n == 1) {
            return 0;
        }
        long res;
        if (n % 2 == 0) {
            res = 1 + help(n / 2);
        } else {
            res = 1 + Math.min(help(n - 1), help(n + 1));
        }
        map.put(n, res);
        return res;
    }

    // 贪心
    public int integerReplacement2(int n) {
        int ans = 0;
        while (n != 1) {
            if (n % 2 == 0) {
                ++ans;
                n /= 2;
            } else if (n % 4 == 1) {
                ans += 2;
                n /= 2;
            } else {
                if (n == 3) {
                    ans += 2;
                    n = 1;
                } else {
                    ans += 2;
                    n = n / 2 + 1;
                }
            }
        }
        return ans;
    }
}
