package cn.shui.codetop.client;

/**
 * Created by chenyiting on 2022/3/21
 * 买卖股票的最佳时机
 */
public class L121 {
    // 超出时间限制
    public int maxProfit(int[] prices) {
        int len = prices.length, max = 0;
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                max = Math.max(max, prices[j] - prices[i]);
            }
        }
        return max;
    }

    // 动态规划
    public int maxProfit2(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price;
            } else {
                maxProfit = Math.max(maxProfit, price - minPrice);
            }
        }
        return maxProfit;
    }
}
