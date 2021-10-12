package cn.shui.learning_plan.offer.ninth;

/**
 * @author shui.
 * @date 2021/10/12.
 * @time 10:57.
 */
public class Offer42 {
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int num : nums) {
            if (sum < 0) {
                sum = num;
            } else {
                sum += num;
            }
            max = Math.max(max, sum);
        }
        return max;
    }
}
