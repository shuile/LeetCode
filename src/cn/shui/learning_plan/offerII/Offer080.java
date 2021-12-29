package cn.shui.learning_plan.offerII;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shui.
 * @date 2021/12/29.
 * @time 14:30.
 * 含有k个元素的组合
 */
public class Offer080 {

    private List<List<Integer>> ans;
    private int n, k;

    public List<List<Integer>> combine(int n, int k) {
        this.n = n;
        this.k = k;
        ans = new ArrayList<>();
        help(new ArrayList<>(), 1);
        return ans;
    }

    private void  help(List<Integer> list, int currIndex) {
        if (list.size() == k) {
            ans.add(new ArrayList<>(list));
            return;
        }
        if (currIndex > n) {
            return;
        }
        list.add(currIndex);
        help(list, currIndex + 1);
        list.remove(list.size() - 1);
        help(list, currIndex + 1);
    }
}
