package cn.shui.learning_plan.datastruct_basic.first;

/**
 * @author shui.
 * @date 2021/8/30.
 * @time 09:12.
 * 只出现一次的数字
 */
public class L136 {
    public int singleNumber(int[] nums) {
        if (nums == null || nums.length < 1) {
            return -1;
        }
        int ans = 0;
        for (int num : nums) {
            ans ^= num;
        }
        return ans;
    }
}
