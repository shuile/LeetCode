package cn.shui.learning_plan.algorithms.eleventh;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shui.
 * @date 2021/7/26.
 * @time 23:34.
 * 全排列
 */
public class L46 {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> lists = permute1(nums);
        System.out.println(lists);
    }

    private static List<List<Integer>> ans = new ArrayList<>();
    private static List<Integer> temp = new ArrayList<>();

    public static List<List<Integer>> permute1(int[] nums) {
        if (nums == null || nums.length < 1) {
            return ans;
        }
        dfs(nums);
        return ans;
    }

    private static void dfs(int[] nums) {
        if (temp.size() == nums.length) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        for (int num : nums) {
            if (temp.contains(num)) {
                continue;
            }
            temp.add(num);
            dfs(nums);
            temp.remove(temp.size() - 1);
        }
    }
}
