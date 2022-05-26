package cn.shui.labuladong;

import cn.shui.labuladong.model.TreeNode;

/**
 * Created by chenyiting on 2022/5/26
 */
public class L112 {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        return dfs(root, targetSum);
    }

    private boolean dfs(TreeNode root, int targetSum) {
        if (root == null) {
            return targetSum == 0;
        }
        targetSum -= root.val;
        if (root.left == null) {
            return dfs(root.right, targetSum);
        }
        if (root.right == null) {
            return dfs(root.left, targetSum);
        }
        return dfs(root.left, targetSum) || dfs(root.right, targetSum);
    }

    //  优化成一个方法
    public boolean hasPathSum2(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return root.val == targetSum;
        }
        targetSum -= root.val;
        return hasPathSum2(root.left, targetSum) || hasPathSum2(root.right, targetSum);
    }
}
