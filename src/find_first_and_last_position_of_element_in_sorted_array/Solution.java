package find_first_and_last_position_of_element_in_sorted_array;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10};
        int target1 = 6;
        int target2 = 8;
        System.out.println(Arrays.toString(searchRange(nums, target1)));
        System.out.println(Arrays.toString(searchRange(nums, target2)));
    }

    private static int[] searchRange(int[] nums, int target) {
        int[] index = {-1, -1};
        for (int i = 0; i < nums.length; i++) {
            if  (nums[i] == target) {
                if (index[0] == -1) {
                    index[0] = i;
                }
                index[1] = i;
            }
            if (nums[i] > target) {
                break;
            }
        }
        return index;
    }
}
