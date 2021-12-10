package cn.shui.learning_plan.offerII;

/**
 * @author shui.
 * @date 2021/12/5.
 * @time 15:40.
 * 和大于等于target的最短子数组
 */
public class Offer008 {

    public static void main(String[] args) {
        Offer008 test = new Offer008();
        test.minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3});
    }

    // 滑动窗口
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        int start = 0, end = 0;
        int sum = 0;
        while (end < n) {
            sum += nums[end];
            while (sum >= target) {
                ans = Math.min(ans, end - start + 1);
                sum -= nums[start++];
            }
            end++;
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}
