package cn.shui.codetop.client;

import cn.shui.codetop.client.model.TreeNode;

/**
 * Created by chenyiting on 2022/3/29
 * 路径综合
 */
public class L112 {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        targetSum -= root.val;
        if (root.left == null && root.right == null) {
            return targetSum == 0;
        }
        return hasPathSum(root.left, targetSum) || hasPathSum(root.right, targetSum);
    }
}
