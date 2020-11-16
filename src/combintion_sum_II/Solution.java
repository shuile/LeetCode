package combintion_sum_II;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        int[] candidates = {2, 5, 1, 1, 2, 3, 3, 3, 1, 2, 2};
        int target = 5;
        List<List<Integer>> lists = combinationSum2(candidates, target);
        for (List<Integer> a : lists) {
            System.out.println(a);
        }
    }

    private static List<List<Integer>> combinationSum2 (int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        Arrays.sort(candidates);
        combination(candidates, target, 0, ans, result);
        Arrays.sort(candidates);
        for (int i = 0 ; i < result.size(); i++) {
            for (int j = i + 1; j < result.size(); j++) {
                if (isListEqual(result.get(i), result.get(j))) {
                    result.remove(j);
                    j--;
                }
            }
        }
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
                combination(candidates, target - candidates[i], i + 1, ans, result);
                ans.remove(ans.size() - 1);
            }
        }
    }

    private static boolean isListEqual (List<Integer> a, List<Integer> b) {
        return a.containsAll(b) && b.containsAll(a) && (a.size() == b.size());
    }

    private static List<List<Integer>> combinationSum2_(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> combine = new ArrayList<>();
        dfs(candidates, target, ans, combine, 0);
        return ans;
    }

    private static void dfs(int[] candidates, int target, List<List<Integer>> ans, List<Integer> combine, int pos) {
        if (pos == candidates.length) {
            return;
        }
        if (target == 0 && !ans.contains(new ArrayList<Integer>(combine))) {
            ans.add(new ArrayList<Integer>(combine));
            return;
        }
        for (int i = pos; i < candidates.length; i++) {
            int diff = target - candidates[i];
            if (diff > 0) {
                combine.add(candidates[i]);
                dfs(candidates, target - candidates[i], ans, combine, i + 1);

            } else {
                if (diff == 0) {
                    ans.add(new ArrayList<Integer>(combine));
                }
                break;
            }
        }
    }
}
