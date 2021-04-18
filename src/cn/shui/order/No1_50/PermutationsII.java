package cn.shui.order.No1_50;

import java.util.ArrayList;
import java.util.List;

public class PermutationsII {
    public static void main(String[] args) {
        int[] nums = {1, 1, 2};
        List<List<Integer>> lists = permuteUnique(nums);
    }

    private static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        help(nums, ans, new ArrayList<>(), 0);
        return ans;
    }

    private static void help(int[] nums, List<List<Integer>> ans, List<Integer> list, int index) {
        if (index >= nums.length) {
            ans.add(new ArrayList<>(list));
            return;
        }
        int tmp = nums[index];
        for (int i = index; i < nums.length; i++) {
            nums[index] = nums[i];
            nums[i] = tmp;
            list.add(nums[i]);
            help(nums, ans, list, index + 1);
            list.remove(i);
            nums[i] = nums[index];
            nums[index] = tmp;
        }
    }
}
