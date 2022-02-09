package cn.shui.learning_plan.beike.day_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author shui.
 * @date 2022/2/9.
 * @time 10:32.
 */
public class Beike_15 {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        // 枚举a
        for (int a = 0; a < n; a++) {
            // 需要和上一次枚举的数不同
            if (a > 0 && nums[a] == nums[a - 1]) {
                continue;
            }
            // c对应的指针初始指向数组的最右端
            int c = n - 1;
            int target = -nums[a];
            // 枚举b
            for (int b = a + 1; b < n; b++) {
                // 需要和上一次枚举的数不相同
                if (b > a + 1 && nums[b] == nums[b - 1]) {
                    continue;
                }
                // 需要保证b指针在c指针的左侧
                while (b < c && nums[b] + nums[c] > target) {
                    c--;
                }
                // 如果指针重合，随着b后续的增加，就不会有满足a + b + c = 0 并且 b < c的 c了，可以退出循环
                if (b == c) {
                    break;
                }
                if (nums[b] + nums[c] == target) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[a]);
                    list.add(nums[b]);
                    list.add(nums[c]);
                    ans.add(list);
                }
            }
        }
        return ans;
    }
}
