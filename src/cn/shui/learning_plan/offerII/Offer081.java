package cn.shui.learning_plan.offerII;

import java.util.*;

/**
 * @author shui.
 * @date 2021/12/29.
 * @time 14:39.
 * 允许重复选择元素的组合
 */
public class Offer081 {

    public static void main(String[] args) {
        Offer081 test = new Offer081();
        int[] candidates = {1};
        int target = 2;
        test.combinationSum2(candidates, target);
    }

    private Set<List<Integer>> set;
    private int[] candidates;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.candidates = candidates;
        set = new HashSet<>();
        help(new ArrayList<>(), target);
        return new ArrayList<>(set);
    }

    private void help(List<Integer> list, int target) {
        if (target == 0) {
            List<Integer> res = new ArrayList<>(list);
            Collections.sort(res);
            set.add(res);
            return;
        }
        if (target < 0) {
            return;
        }
        for (int candidate : candidates) {
            list.add(candidate);
            help(list, target - candidate);
            list.remove(list.size() - 1);
        }
    }

    private List<List<Integer>> res;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        this.candidates = candidates;
        res = new ArrayList<>();
        help(new ArrayList<>(), 0, target);
        return res;
    }

    private void help(List<Integer> list, int currIndex, int target) {
        if (target == 0) {
            res.add(new ArrayList<>(list));
            return;
        }
        if (currIndex >= candidates.length || target < 0) {
            return;
        }
        list.add(candidates[currIndex]);
        help(list, currIndex, target - candidates[currIndex]);
        list.remove(list.size() - 1);
        help(list, currIndex + 1, target);
    }
}
