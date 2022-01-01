package cn.shui.learning_plan.offerII;

import java.util.*;

/**
 * @author shui.
 * @date 2021/12/30.
 * @time 10:07.
 * 含有重复元素集合的组合
 */
public class Offer082 {

    private Set<List<Integer>> ans;
    private int[] candidates;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        this.candidates = candidates;
        ans = new HashSet<>();
        help(new ArrayList<>(), 0, target);
        return new ArrayList<>(ans);
    }

    private void help(List<Integer> list, int currIndex, int target) {
        if (target == 0) {
            List<Integer> res = new ArrayList<>(list);
            Collections.sort(res);
            ans.add(res);
            return;
        }
        if (currIndex >= candidates.length || target < 0) {
            return;
        }
        list.add(candidates[currIndex]);
        help(list, currIndex + 1, target - candidates[currIndex]);
        list.remove(list.size() - 1);
        help(list, currIndex + 1, target);
    }

    public List<List<Integer>> combinationSum22(int[] candidates, int target) {
        List<List<Integer>> ret = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        Arrays.sort(candidates);
        helper(candidates, 0, target, ret, cur);
        return ret;
    }

    private void helper(int[] candidates, int index, int target, List<List<Integer>> ret, List<Integer> cur) {
        if (target == 0) {
            ret.add(new ArrayList<>(cur));
            return;
        }
        if (target < 0 || index >= candidates.length) {
            return;
        }
        cur.add(candidates[index]);
        helper(candidates, index + 1, target - candidates[index], ret, cur);
        cur.remove(cur.size() - 1);
        helper(candidates, getNext(candidates, index), target, ret, cur);
    }

    private int getNext(int[] candidates, int index) {
        for (int i = index + 1; i < candidates.length; i++) {
            if (candidates[i] != candidates[index]) {
                return i;
            }
        }
        return candidates.length;
    }
}
