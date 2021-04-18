package cn.shui.order.two_sum;

public class Solution {
    public static void main(String[] args) {
        int[] nums = { 2, 7, 11, 15 };
        int target = 9;
        int[] reNums = new int[2];
        reNums = twoSum( nums, target );
        System.out.println(reNums[0] + " " + reNums[1]);
    }

    public static int[] twoSum(int[] nums, int target) {
        int[] reNums = new int[2];
        for ( int i = 0 ; i < nums.length - 1 ; i++ ) {
            for ( int j = i + 1 ; j < nums.length ; j++ ) {
                if ( nums[i] + nums[j] == target ) {
                    reNums[0] = i;
                    reNums[1] = j;
                    break;
                }
            }
        }
        return reNums;
    }
}
