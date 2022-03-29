package cn.shui.codetop.client;

import cn.shui.codetop.client.model.TreeNode;

/**
 * Created by chenyiting on 2022/3/29
 * 二叉树的直径
 */
public class L543 {

    private int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return max;
    }

    private int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftMax = maxDepth(root.left);
        int rightMax = maxDepth(root.right);
        max = Math.max(max, leftMax + rightMax);
        return 1 + Math.max(leftMax, rightMax);
    }
}
