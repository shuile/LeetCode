package cn.shui.labuladong;

import cn.shui.labuladong.model.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenyiting on 2022/5/29
 * 路径总和II
 */
public class L113 {

    private final List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        dfs(root, targetSum, new ArrayList<>());
        return ans;
    }

    private void dfs(TreeNode root, int targetSum, List<Integer> list) {
        if (root == null) {
            return;
        }
        targetSum -= root.val;
        list.add(root.val);
        if (root.left == null && root.right == null) {
            if (targetSum == 0) {
                ans.add(new ArrayList<>(list));
            }
            list.remove(list.size() - 1);
            return;
        }
        dfs(root.left, targetSum, list);
        dfs(root.right, targetSum, list);
        list.remove(list.size() - 1);
    }
}
