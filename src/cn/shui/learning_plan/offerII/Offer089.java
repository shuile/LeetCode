package cn.shui.learning_plan.offerII;

/**
 * @author shui.
 * @date 2022/1/4.
 * @time 10:48.
 * 房屋偷盗
 */
public class Offer089 {
    // 超限
    public int rob(int[] nums) {
        return help(nums, 0, 0);
    }

    private int help(int[] nums, int index, int curr) {
        if (index >= nums.length) {
            return curr;
        }
        return Math.max(help(nums, index + 2, curr + nums[index]), help(nums, index + 1, curr));
    }

    private int rob2(int[] nums) {
        int pre = 0, cur = 0, tmp;
        for (int num : nums) {
            tmp = cur;
            cur = Math.max(pre + num, cur);
            pre =  tmp;
        }
        return cur;
    }
}
