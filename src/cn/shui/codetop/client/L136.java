package cn.shui.codetop.client;

/**
 * Created by chenyiting on 2022/4/7
 * 只出现一次的数字
 */
public class L136 {
    public int singleNumber(int[] nums) {
        int ans = 0;
        for (int num : nums) {
            ans ^= num;
        }
        return ans;
    }
}
