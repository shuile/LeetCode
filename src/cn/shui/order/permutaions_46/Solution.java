package cn.shui.order.permutaions_46;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> permute = permute(nums);
        for (List<Integer> item : permute) {
            for (Integer i : item) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    private static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        permuteItem(result, nums, 0);
        return result;
    }

    private static void permuteItem(List<List<Integer>> result, int[] nums, int current) {
        if (current == nums.length) {
            List<Integer> item = new ArrayList<>();
            for (Integer temp : nums) {
                item.add(temp);
            }
            result.add(item);
        } else {
            for (int i = current; i < nums.length; i++) {
                swap(nums, current, i);
                permuteItem(result, nums, current + 1);
                swap(nums, current, i);
            }
        }
    }

    private static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
