package cn.shui.order;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by chenyiting on 2023/7/12
 */
public class L368 {

    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return ans;
        }
        Arrays.sort(nums);
        int len = nums.length;
        int[] dp = new int[len];
        Arrays.fill(dp, 1);
        int maxSize = 1;
        int maxVal = nums[0];
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            if (dp[i] > maxSize) {
                maxSize = dp[i];
                maxVal = nums[i];
            }
        }
        if (maxSize == 1) {
            ans.add(nums[0]);
            return ans;
        }
        for (int i = len - 1; i >= 0; i--) {
            if (dp[i] == maxSize && maxVal % nums[i] == 0) {
                ans.add(nums[i]);
                maxSize--;
                maxVal = nums[i];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] test1 = new int[]{1,2,3,4,6,8,9};
        L368 test = new L368();
        System.out.println(test.largestDivisibleSubset(test1));
    }
}
