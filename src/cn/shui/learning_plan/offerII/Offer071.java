package cn.shui.learning_plan.offerII;

import java.util.Arrays;

/**
 * @author shui.
 * @date 2021/12/28.
 * @time 10:05.
 * 按权重生成随机数
 */
public class Offer071 {
    public static class Solution {

        private final int[] pre;
        private final int total;

        public Solution(int[] w) {
            pre = new int[w.length];
            pre[0] = w[0];
            for (int i = 1; i < w.length; i++) {
                pre[i] = pre[i - 1] + w[i];
            }
            total = Arrays.stream(w).sum();
        }

        public int pickIndex() {
            int x = (int) (Math.random() * total) + 1;
            return binarySearch(x);
        }

        private int binarySearch(int x) {
            int low = 0, high = pre.length - 1;
            while (low < high) {
                int mid = low + (high - low) / 2;
                if (pre[mid] < x) {
                    low = mid + 1;
                } else {
                    high = mid;
                }
            }
            return low;
        }
    }
}
