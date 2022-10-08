package cn.shui.order;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenyiting on 2022/10/8
 * 组合总和III
 */
public class L216 {
    private List<List<Integer>> ans;

    public List<List<Integer>> combinationSum3(int n, int k) {
        ans = new ArrayList<>();
        dfs(1, n, k, new ArrayList<>());
        return ans;
    }

    private void dfs(int start, int target, int num, List<Integer> list) {
        if (target == 0 && num == 0) {
            ans.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i <= 9; i++) {
            if (i > target) {
                return;
            }
            list.add(i);
            dfs(i + 1, target - i, num - 1, list);
            list.remove(list.size() - 1);
        }
    }
}
