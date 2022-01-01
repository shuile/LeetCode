package cn.shui.learning_plan.offerII;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author shui.
 * @date 2021/12/30.
 * @time 10:59.
 * 含有重复元素集合的全排列
 */
public class Offer084 {
    // 回溯法 + 哈希表
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }
        List<List<Integer>> ans=  new ArrayList<>();
        helper(list, 0, ans);
        return ans;
    }

    private void helper(List<Integer> list, int index, List<List<Integer>> ans) {
        if (index == list.size()) {
            ans.add(new ArrayList<>(list));
            return;
        }
        Set<Integer> set = new HashSet<>();
        for (int i = index; i < list.size(); i++) {
            if (!set.contains(list.get(i))) {
                set.add(list.get(i));
                swap(list, index, i);
                helper(list, index + 1, ans);
                swap(list, index, i);
            }
        }
    }

    private void swap(List<Integer> list, int i, int j) {
        int temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }
}
