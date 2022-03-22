package cn.shui.codetop.client;

import cn.shui.codetop.client.model.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenyiting on 2022/3/22
 * 路径总和II
 */
public class L113 {

    private final List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        help(root, targetSum, 0, new ArrayList<>());
        return ans;
    }

    private void help(TreeNode root, int targetSum, int currentSum, List<Integer> list) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        if (root.left == null && root.right == null) {
            if (currentSum + root.val == targetSum) {
                ans.add(new ArrayList<>(list));
            }
            list.remove(list.size() - 1);
            return;
        }
        help(root.left, targetSum, currentSum + root.val, list);
        help(root.right, targetSum, currentSum + root.val, list);
        list.remove(list.size() - 1);
    }

    // 深度优先搜索

}
