package cn.shui.codetop.client;

/**
 * Created by chenyiting on 2022/4/11
 * 移动零
 */
public class L283 {
    public void moveZeros(int[] nums) {
        int index = 0, len = nums.length;
        for (int i = 0; i < len; i++) {
            if (nums[i] != 0) {
                int temp = nums[i];
                nums[i] = nums[index];
                nums[index] = temp;
                index++;
            }
        }
    }
}
