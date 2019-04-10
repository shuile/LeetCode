package _3Sum;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        int[] nums = {0,3,0,1,1,-1,-5,-5,3,-3,-3,0};
        List<List<Integer>> lists = threeSum(nums);
        for (List<Integer> list : lists) {
            for (int i : list) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
        List<List<Integer>> result = new ArrayList<>();
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> listLists = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+ 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if ((nums[i] + nums[j] + nums[k]) == 0) {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        listLists.add(list);
                    }
                }
            }
        }
        for (int i = 0; i < listLists.size(); i++) {
            for (int j = i + 1; j < listLists.size(); j++) {
                boolean isEquals = true;
                for (int k : listLists.get(i)) {
                    if (!listLists.get(j).contains(k)) {
                        isEquals = false;
                        break;
                    }
                }
                if (isEquals) {
                    listLists.remove(j);
                    j--;
                }
            }
        }
        return listLists;
    }
}
