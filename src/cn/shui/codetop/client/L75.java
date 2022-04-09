package cn.shui.codetop.client;

/**
 * Created by chenyiting on 2022/4/9
 * 颜色分类
 */
public class L75 {

    // 单指针
    public void sortColors(int[] nums) {
        int len = nums.length, zero = 0;
        for (int i = 0; i < len; i++) {
            if (nums[i] == 0) {
                swap(nums, i, zero++);
            }
        }
        int one = zero;
        for (int i = zero; i < len; i++) {
            if (nums[i] == 1) {
                swap(nums, i, one++);
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    // 双指针
    public void sortColors2(int[] nums) {
        int len = nums.length, zero = 0, one = 0;
        for (int i = 0; i < len; i++) {
            if (nums[i] == 1) {
                swap(nums, i, one);
                one++;
            } else if (nums[i] == 0) {
                swap(nums, i, zero);
                if (zero < one) {
                    swap(nums, i, one);
                }
                zero++;
                one++;
            }
        }
    }
}
