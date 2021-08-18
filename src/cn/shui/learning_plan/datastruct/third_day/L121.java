package cn.shui.learning_plan.datastruct.third_day;

/**
 * @author shui.
 * @date 2021/8/18.
 * @time 10:09.
 * 买股票的最佳时机
 */
public class L121 {
    // 超时
    public int maxProfit1(int[] prices) {
        int len = prices.length;
        int max = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                max = Math.max(max, prices[j] - prices[i]);
            }
        }
        return max;
    }

    public int maxProfit2(int[] prices) {
        int buyIn = 0, max = 0, len = prices.length;
        for (int i = 1; i < len; i++) {
            int profit = prices[i] - prices[buyIn];
            if (profit < 0) {
                buyIn = i;
                continue;
            }
            max = Math.max(max, profit);
        }
        return max;
    }

    public int maxProfit3(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else if (prices[i] - minPrice > maxProfit) {
                maxProfit = prices[i] - minPrice;
            }
        }
        return maxProfit;
    }
}
