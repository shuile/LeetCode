package first_missing_positive;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {

    }

    public static int firstMissingPositive(int[] nums) {
        Arrays.sort(nums);
        int smallest = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= 0) {
                continue;
            }
            if (nums[i] == (smallest - 1)) {
                continue;
            }
            if (nums[i] == smallest) {
                smallest++;
            } else {
                break;
            }
        }
        return smallest;
    }
}
