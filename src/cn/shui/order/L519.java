package cn.shui.order;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @author shui.
 * @date 2021/11/28.
 * @time 10:39.
 * 随机翻转矩阵
 */
public class L519 {

    private class Solution {

        private Map<Integer, Integer> map = new HashMap<>();
        private int m, n, total;
        private Random random = new Random();

        public Solution(int m, int n) {
            this.m = m;
            this.n = n;
            this.total = m * n;
        }

        public int[] flip() {
            int x = random.nextInt(total);
            total--;
            // 查找位置x对应的映射
            int idx = map.getOrDefault(x, x);
            // 将位置x对应的映射设置为位置total对应的映射
            map.put(x, map.getOrDefault(total, total));
            return new int[]{idx / n, idx % n};
        }

        public void reset() {
            total = m * n;
            map.clear();
        }
    }
}
