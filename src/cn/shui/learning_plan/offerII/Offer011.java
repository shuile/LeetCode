package cn.shui.learning_plan.offerII;

import java.util.HashMap;
import java.util.Map;

/**
 * @author shui.
 * @date 2021/12/7.
 * @time 17:17.
 * 0和1个数相同的子数组
 */
public class Offer011 {
    public int findMaxLength(int[] nums) {
        int maxLength = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int counter = 0;
        map.put(counter, -1);
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            if (num == 1) {
                counter++;
            } else {
                counter--;
            }
            if (map.containsKey(counter)) {
                int prevIndex = map.get(counter);
                maxLength = Math.max(maxLength, i - prevIndex);
            } else {
                map.put(counter, i);
            }
        }
        return maxLength;
    }
}
