package cn.shui.learning_plan.offerII;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shui.
 * @date 2021/12/30.
 * @time 10:34.
 * 没有重复元素集合的全排列
 */
public class Offer083 {
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> original = new ArrayList<>();
        for (int num : nums) {
            original.add(num);
        }
        List<List<Integer>> ans = new ArrayList<>();
        help(new ArrayList<>(), ans, original);
        return ans;
    }

    private void help(List<Integer> list, List<List<Integer>> ans, List<Integer> original) {
        if (original.isEmpty()) {
            ans.add(new ArrayList<>(list));
            return;
        }
        int size = original.size();
        for (int i = 0; i < size; i++) {
            int num = original.get(i);
            list.add(num);
            original.remove(i);
            help(list, ans, original);
            original.add(i, num);
            list.remove(list.size() - 1);
        }
    }

    // 回溯法
    public List<List<Integer>> permute2(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }
        List<List<Integer>> ans = new ArrayList<>();
        helper(list, 0, ans);
        return ans;
    }

    private void helper(List<Integer> list, int index, List<List<Integer>> ans) {
        if (index == list.size()) {
            ans.add(new ArrayList<>(list));
            return;
        }
        for (int i = index; i < list.size(); i++) {
            swap(list, index, i);
            helper(list, index + 1, ans);
            swap(list, index, i);
        }
    }

    private void swap(List<Integer> list, int i, int j) {
        int temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }
}
