package cn.shui.order.combination_sum;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        List<List<Integer>> lists = combinationSum(candidates, target);
        System.out.println(lists.toString());
    }

    private static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        combination(candidates, target, 0, ans, result);
        return result;
    }

    private static void combination(int[] candidates, int target, int index, List<Integer> ans, List<List<Integer>> result) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            result.add(new ArrayList<>(ans));
        } else {
            for (int i = index; i < candidates.length; i++) {
                ans.add(candidates[i]);
                combination(candidates, target - candidates[i], i, ans, result);
                ans.remove(ans.size() - 1);
            }
        }
    }
}
