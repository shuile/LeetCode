package cn.shui.order;

import java.util.Arrays;

/**
 * Created by chenyiting on 2024/4/18
 */
public class L164 {

    public int maximumGap(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        Arrays.sort(nums);
        int ans = Integer.MIN_VALUE;
        for (int i = 1; i < nums.length; i++) {
            ans = Math.max(ans, nums[i] - nums[i - 1]);
        }
        return ans;
    }

    /**
     * 基数排序
     */
    public int maximumGap2(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        int len = nums.length;
        long exp = 1;
        int[] buf = new int[len];
        int maxVal = Arrays.stream(nums).max().getAsInt();
        while (maxVal >= exp) {
            int[] cnt = new int[10];
            for (int num : nums) {
                int digit = (num / (int) exp) % 10;
                cnt[digit]++;
            }
            for (int i = 1; i < 10; i++) {
                cnt[i] += cnt[i - 1];
            }
            for (int i = len - 1; i >= 0; i--) {
                int digit = (nums[i] / (int) exp) % 10;
                buf[cnt[digit] - 1] = nums[i];
                cnt[digit]--;
            }
            System.arraycopy(buf, 0, nums, 0, len);
            exp *= 10;
        }
        int ans = Integer.MIN_VALUE;
        for (int i = 1; i < len; i++) {
            ans = Math.max(ans, nums[i] - nums[i - 1]);
        }
        return ans;
    }

    public static void main(String[] args) {
        L164 test = new L164();
        System.out.println(test.maximumGap2(new int[]{1, 3, 11, 13, 24, 4, 16, 7}));
    }
}
