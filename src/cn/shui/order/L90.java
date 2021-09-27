package cn.shui.order;

import java.util.*;

/**
 * @author shui.
 * @date 2021/9/27.
 * @time 11:49.
 * 子集II
 */
public class L90 {
    List<Integer> t = new ArrayList<>();
    List<List<Integer>> ans = new ArrayList<>();

    // 迭代法实现子集枚举
    public List<List<Integer>> subsetWithDup1(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        for (int mask = 0; mask < (1 << n); mask++) {
            t.clear();
            boolean flag = true;
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    if (i > 0 && (mask >> (i - 1) & 1) == 0 && nums[i] == nums[i - 1]) {
                        flag = false;
                        break;
                    }
                    t.add(nums[i]);
                }
            }
            if (flag) {
                ans.add(new ArrayList<>(t));
            }
        }
        return ans;
    }

    // 递归法实现子集枚举
    public List<List<Integer>> subsetWithDup2(int[] nums) {
        Arrays.sort(nums);
        dfs(false, 0, nums);
        return ans;
    }

    private void dfs(boolean choospre, int cur, int[] nums) {
        if (cur == nums.length) {
            ans.add(new ArrayList<>(t));
            return;
        }
        dfs(false, cur + 1, nums);
        if (!choospre && cur > 0 && nums[cur - 1] == nums[cur]) {
            return;
        }
        t.add(nums[cur]);
        dfs(true, cur + 1, nums);
        t.remove(t.size() - 1);
    }
}
