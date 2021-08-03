package cn.shui.learning_plan.algorithms.eleventh;

import java.util.*;

/**
 * @author shui.
 * @date 2021/7/24.
 * @time 17:44.
 * 组合
 */
public class L77 {

    public static void main(String[] args) {
        combine1(4, 2);
        System.out.println(ans);
    }

    private static List<List<Integer>> ans = new ArrayList<>();

    public static List<List<Integer>> combine1(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        if (k > n) {
            return null;
        }
        help(new ArrayList<>(), 0, n, k);
        return ans;
    }

    private static void help(List<Integer> list, int start, int n, int k) {
        if (k <= 0) {
            ans.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i < n; i++) {
            list.add(i + 1);
            help(list, i + 1, n, k - 1);
            list.remove(list.size() - 1);
        }
    }

    List<Integer> temp = new ArrayList<>();

    public List<List<Integer>> combine2(int n, int k) {
        dfs(1, n, k);
        return ans;
    }

    public void dfs(int cur, int n, int k) {
        // 剪枝：temp长度加上区间[cur, n]的长度小于k，不可能构造出长度为k的temp
        if (temp.size() + (n - cur + 1) < k) {
            return;
        }
        // 记录合法的答案
        if (temp.size() == k) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        // 考虑选择当前位置
        temp.add(cur);
        dfs(cur + 1, n, k);
        temp.remove(temp.size() - 1);
        // 考虑不选择当前位置
        dfs(cur + 1, n, k);
    }
}
