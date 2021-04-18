package cn.shui.order.search_in_rotated_sorted_array;

public class Solution {

    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int target1 = 0;
        int target2 = 3;
        System.out.println(search(nums, target1));
        System.out.println(search(nums, target2));
    }

    private static int search(int[] nums, int target) {
        int index = -1;
        for (int i = 0; i < nums.length; i++) {
            if  (nums[i] == target) {
                index = i;
                break;
            }
        }
        return index;
    }
}
