package combination_sum;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] args) {

    }

    private List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < candidates.length; i++) {
            ans.clear();
            int num = candidates[i];
            int count = 0;
            while ((target - num * count) >= 0) {
                if ((target - num * count) == 0) {

                }
            }
        }
    }
}
