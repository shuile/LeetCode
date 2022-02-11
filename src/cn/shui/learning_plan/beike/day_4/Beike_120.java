package cn.shui.learning_plan.beike.day_4;

import java.util.List;

/**
 * @author shui.
 * @date 2022/2/11.
 * @time 09:13.
 * 三角形最小路径和
 */
public class Beike_120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int size = triangle.size();
        int[] dp = new int[size];
        dp[0] = triangle.get(0).get(0);
        for (int i = 1; i < size; i++) {
            dp[i] = dp[i - 1] + triangle.get(i).get(i);
            for (int j = i - 1; j > 0; j--) {
                dp[j] = Math.min(dp[j - 1], dp[j]) + triangle.get(i).get(j);
            }
            dp[0] += triangle.get(i).get(0);
        }
        int min = dp[0];
        for (int num : dp) {
            min = Math.min(min, num);
        }
        return min;
    }
}
