package cn.shui.learning_plan.offer.sixteenth;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author shui.
 * @date 2021/10/18.
 * @time 12:01.
 */
public class Offer61 {
    public boolean isStraight(int[] nums) {
        Arrays.sort(nums);
        int zeros = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeros++;
                continue;
            }
            if (i == 0 || nums[i - 1] == 0) {
                continue;
            }
            if (nums[i] == nums[i - 1]) {
                return false;
            }
            zeros -= nums[i] - nums[i - 1] - 1;
        }
        return zeros >= 0;
    }

    // 集合Set + 遍历
    public boolean isStraight2(int[] nums) {
        Set<Integer> repeat = new HashSet<>();
        int max = 0, min = 14;
        for (int num : nums) {
            if (num == 0) {
                continue;
            }
            max = Math.max(max, num);
            min = Math.min(min, num);
            if (repeat.contains(num)) {
                return false;
            }
            repeat.add(num);
        }
        return max - min < 5;
    }

    // 排序 + 遍历
    public boolean isStraight3(int[] nums) {
        int joker = 0;
        Arrays.sort(nums);
        for (int i = 0; i < 4; i++) {
            if (nums[i] == 0) {
                joker++;
            } else if (nums[i] == nums[i + 1]) {
                return false;
            }
        }
        return nums[4] - nums[joker] < 5;
    }
}
