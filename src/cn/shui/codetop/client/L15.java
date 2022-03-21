package cn.shui.codetop.client;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenyiting on 2022/3/21
 * 三数之和
 */
public class L15 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return ans;
        }
        int len = nums.length;
        for (int i = 0; i < len - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int target = -nums[i];
            for (int j = i + 1; j < len - 1; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int l = j + 1, r = len - 1;
                while (l <= r) {
                    int mid = l + (r - l) / 2;
                    if (nums[mid] + nums[j] == target) {
                        final int first = nums[i];
                        final int second = nums[j];
                        final int third = nums[mid];
                        ans.add(new ArrayList<Integer>() {{
                            add(first);
                            add(second);
                            add(third);
                        }});
                        break;
                    }
                    if (nums[mid] + nums[j] < target) {
                        l = mid + 1;
                    } else {
                        r = mid - 1;
                    }
                }
            }
        }
        return ans;
    }
}
