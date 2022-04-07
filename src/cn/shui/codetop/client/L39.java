package cn.shui.codetop.client;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenyiting on 2022/4/7
 * 组合总和
 */
public class L39 {

    private final List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        help(candidates, new ArrayList<>(), 0, 0, target);
        return ans;
    }

    private void help(int[] candidates, List<Integer> temp, int sum, int index, int target) {
        if (sum >= target) {
            if (sum == target) {
                ans.add(new ArrayList<>(temp));
            }
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            temp.add(candidates[i]);
            help(candidates, temp, sum + candidates[i], i, target);
            temp.remove(temp.size() - 1);
        }
    }
}
