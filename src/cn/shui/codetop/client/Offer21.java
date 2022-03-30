package cn.shui.codetop.client;

/**
 * Created by chenyiting on 2022/3/30
 * 调整数组顺序使奇数位于偶数前面
 */
public class Offer21 {

    //不稳定的排序
    public int[] exchange(int[] nums) {
        if (nums == null || nums.length < 2) {
            return nums;
        }
        int odd = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 1) {
                int temp = nums[i];
                nums[i] = nums[odd];
                nums[odd] = temp;
                odd++;
            }
        }
        return nums;
    }

    // 稳定的排序

}
