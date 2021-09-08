package cn.shui.learning_plan.datastruct_basic.fifth;

/**
 * @author shui.
 * @date 2021/9/8.
 * @time 22:02.
 * 递增的三元子序列
 */
public class L334 {
    public boolean increasingTriplet1(int[] nums) {
        if (nums == null || nums.length < 3) {
            return false;
        }
        int first = -1, second = -1, len = nums.length;
        for (int i = 0; i < len; i++) {
            if (first == -1 || nums[first] > nums[i]) {
                first = i;
            } else {
                continue;
            }
            for (int j = i + 1; j < len; j++) {
                if ((second == -1 || nums[second] > nums[j]) && nums[j] > nums[first]) {
                    second = j;
                } else {
                    continue;
                }
                for (int k = j + 1; k < len; k++) {
                    if (nums[k] > nums[second]) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean increasingTriplet2(int[] nums) {
        if (nums == null || nums.length < 3) {
            return false;
        }
        int first = Integer.MAX_VALUE, second = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (first > nums[i]) {
                first = nums[i];
            } else if (nums[i] > first && nums[i] < second) {
                second = nums[i];
            } else if (nums[i] > second) {
                return true;
            }
        }
        return false;
    }
}
