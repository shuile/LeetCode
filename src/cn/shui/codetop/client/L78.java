package cn.shui.codetop.client;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenyiting on 2022/4/9
 * 子集
 */
public class L78 {

    private final List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> list = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }
        for (int i = 0; i <= nums.length; i++) {
            help(list, temp, i, 0);
        }
        return ans;
    }

    private void help(List<Integer> list, List<Integer> temp, int total, int index) {
        if (temp.size() == total) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        for (int i = 0; i < list.size(); i++) {
            int a = list.get(i);
            list.remove(i);
            temp.add(a);
            help(list, temp, total, i);
            temp.remove(temp.size() - 1);
            list.add(i, a);
        }
    }
}
