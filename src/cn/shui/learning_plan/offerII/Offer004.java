package cn.shui.learning_plan.offerII;

/**
 * @author shui.
 * @date 2021/12/2.
 * @time 16:59.
 * 只出现一次的数字
 */
public class Offer004 {
    public int singleNumber(int[] nums) {
        int ones = 0, twos = 0;
        for (int num : nums) {
            ones = ones ^ num & ~twos;
            twos = twos ^ num & ~ones;
        }
        return ones;
    }
}
