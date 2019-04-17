package _3sum_closest;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 1, 55};
        int target = 3;
        System.out.println(threeSumClosest(nums, target));
    }

    private static int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length < 3) {
            return 0;
        }
        Arrays.sort(nums);
        long closestNumber = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - 2; i++) {
            int firstNumber = nums[i];
            int leftIndex = i + 1;
            int rightIndex = nums.length - 1;
            int twoSumTarget = target - firstNumber;
            while (leftIndex < rightIndex) {
                int twoSum = nums[leftIndex] + nums[rightIndex];
                if (Math.abs(target - (firstNumber + twoSum)) < Math.abs(target - closestNumber)) {
                    closestNumber = firstNumber + twoSum;
                }
                if (twoSum == twoSumTarget) {
                    return target;
                }
                if (twoSum < twoSumTarget) {
                    leftIndex++;
                } else {
                    rightIndex--;
                }
            }
        }
        return (int) closestNumber;
    }
}
