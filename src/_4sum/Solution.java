package _4sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {1, 0, -1, 0, -2, 2};
        int targer = 0;
        List<List<Integer>> result = fourSum(nums, 0);
        for (List<Integer> list : result) {
            System.out.println(list.toString());
        }
    }

    private static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null || nums.length < 4) {
            return ans;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int sum3 = target - nums[i];
            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j > (i + 1) && nums[j] == nums[j - 1]) {
                    continue;
                }
                int sum2 = sum3 - nums[j];
                int left = j + 1;
                int right = nums.length - 1;
                while (left < right) {
                    int res = nums[left] + nums[right] - sum2;
                    if (res == 0) {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[left]);
                        list.add(nums[right]);
                        list.add(nums[j]);
                        list.add(nums[i]);
                        ans.add(list);
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        left++;
                        right--;
                    } else if (res < 0) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        return ans;
    }
}
