package cn.shui.offer;

import java.util.HashMap;
import java.util.Map;

public class Offer_57I {
    public static void main(String[] args) {

    }

    private int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return new int[0];
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                return new int[]{map.get(num), num};
            }
            map.put(target - num, num);
        }
        return new int[0];
    }

    private int[] twoSum2(int[] nums, int target) {
        if (nums == null) {
            return new int[0];
        }
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int sum = nums[l] + nums[r];
            if (sum < target) {
                l++;
            } else if (sum > target) {
                r--;
            } else {
                return new int[]{nums[l], nums[r]};
            }
        }
        return new int[0];
    }
}
