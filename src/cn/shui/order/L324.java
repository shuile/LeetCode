package cn.shui.order;

import java.util.Arrays;

/**
 * Created by chenyiting on 2023/3/5
 * 摆动排序
 */
public class L324 {
    public void wiggleSort(int[] nums) {
        int[] arr = nums.clone();
        Arrays.sort(arr);
        int len = nums.length;
        int x = (nums.length + 1) / 2;
        for (int i = 0, j = x - 1, k = len - 1; i < len; i += 2, j--, k--) {
            nums[i] = arr[j];
            if (i + 1 < len) {
                nums[i + 1] = arr[k];
            }
        }
    }
}
