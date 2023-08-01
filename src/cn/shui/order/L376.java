package cn.shui.order;

/**
 * Created by chenyiting on 2023/8/1
 * 摆动序列
 */
public class L376 {
    public int wiggleMaxLength(int[] nums) {
        if (nums == null) {
            return 0;
        }
        int len = nums.length;
        if (len < 2) {
            return len;
        }
        int direction = 0, ans = 0;
        for (int i = 1; i < len; i++) {
            if (nums[i] == nums[i - 1]) {
                continue;
            }
            if (nums[i] > nums[i - 1]) {
                if (direction == 1) {
                    continue;
                }
                direction = 1;
                ans++;
            } else {
                if (direction == -1) {
                    continue;
                }
                direction = -1;
                ans++;
            }
        }
        return ans + 1;
    }
}
