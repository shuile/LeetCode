package cn.shui.learning_plan.offerII;

import cn.shui.learning_plan.offerII.model.TreeNode;

/**
 * @author shui.
 * @date 2021/12/19.
 * @time 20:34.
 * 二叉树剪枝
 */
public class Offer047 {
    public TreeNode pruneTree(TreeNode root) {
        return dfs(root);
    }

    private TreeNode dfs(TreeNode node) {
        if (node == null) {
            return null;
        }
        node.left = dfs(node.left);
        node.right = dfs(node.right);
        if (node.val == 0 && node.left == null && node.right == null) {
            return null;
        }
        return node;
    }
}
