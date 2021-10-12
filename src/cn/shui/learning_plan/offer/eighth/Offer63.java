package cn.shui.learning_plan.offer.eighth;

/**
 * @author shui.
 * @date 2021/10/12.
 * @time 10:47.
 */
public class Offer63 {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 1) {
            return 0;
        }
        int max = 0;
        int len = prices.length;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                max = Math.max(max, prices[j] - prices[i]);
            }
        }
        return max;
    }

    // 一次遍历
    public int maxProfit2(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else if (prices[i] - minPrice > maxProfit){
                maxProfit = prices[i] - minPrice;
            }
        }
        return maxProfit;
    }
}
