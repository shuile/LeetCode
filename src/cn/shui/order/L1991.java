package cn.shui.order;

/**
 * Created by chenyiting on 2024/11/24
 */
public class L1991 {
    public int findMiddleIndex(int[] nums) {
        if (nums == null || nums.length < 1) {
            return -1;
        }
        int rSum = 0, len = nums.length;
        for (int i = 1; i < nums.length; i++) {
            rSum += nums[i];
        }
        if (rSum == 0) {
            return 0;
        }
        int lSum = 0;
        for (int i = 1; i < nums.length; i++) {
            rSum -= nums[i];
            lSum += nums[i - 1];
            if (lSum == rSum) {
                return i;
            }
        }
        return -1;
    }

    // official
    public int findMiddleIndex2(int[] nums) {
        if (nums == null || nums.length < 1) {
            return -1;
        }
        int total = 0;
        for (int num : nums) {
            total += num;
        }
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (sum * 2 + nums[i] == total) {
                return i;
            }
            sum += nums[i];
        }
        return -1;
    }
}
