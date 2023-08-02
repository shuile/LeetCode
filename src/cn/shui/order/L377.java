package cn.shui.order;

import java.util.*;

/**
 * Created by chenyiting on 2023/8/2
 * 组合综合IV
 */
public class L377 {

    private int ans = 0;
    private Map<Integer, Integer> map;

    public int combinationSum4(int[] nums, int target) {
        Arrays.sort(nums);
        ans = 0;
        map = new HashMap();
        help(nums, target);
        return ans;
    }

    private void help(int[] nums, int target) {
        if (target == 0) {
            ans++;
            return;
        }
        for (int num : nums) {
            if (target - num >= 0) {
                if (!map.containsKey(target - num)) {
                    int tmp = ans;
                    ans = 0;
                    help(nums, target - num);
                    map.put(target - num, ans);
                    ans += tmp;
                } else {
                    ans += map.get(target - num);
                }
            }
        }
    }

    // 动态规划
    public int combinationSum4_2(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i <= target; i++) {
            for (int num : nums) {
                if (num <= i) {
                    dp[i] += dp[i - num];
                }
            }
        }
        return dp[target];
    }
}
