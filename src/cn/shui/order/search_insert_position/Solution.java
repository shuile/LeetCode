package cn.shui.order.search_insert_position;

public class Solution {

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6};
        int[] target = {5, 2, 7, 0};
        for (int i = 0; i < target.length; i++) {
            System.out.println("target" + i + ":  " + searchInsert(nums, target[i]));
        }
    }

    //在有序数组中寻找插入位置
    public static int searchInsert(int[] nums, int target) {
        int index = -1;
        if (nums.length <= 0) {
            index = 0;
        }
        int i = 0;
        for (; i < nums.length; i++) {
            if (nums[i] >= target) {
                break;
            }
        }
        index = i;
        return index;
    }
}
