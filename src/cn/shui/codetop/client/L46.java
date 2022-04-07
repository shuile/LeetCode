package cn.shui.codetop.client;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenyiting on 2022/4/7
 * 全排列
 */
public class L46 {

    private final List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }
        help(list, new ArrayList<>());
        return ans;
    }

    private void help(List<Integer> list, List<Integer> temp) {
        if (list.isEmpty()) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        for (int i = 0; i < list.size(); i++) {
            int a = list.get(i);
            temp.add(a);
            list.remove(i);
            help(list, temp);
            list.add(i, a);
            temp.remove(temp.size() - 1);
        }
    }
}
