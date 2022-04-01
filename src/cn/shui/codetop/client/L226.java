package cn.shui.codetop.client;

import cn.shui.codetop.client.model.TreeNode;

/**
 * Created by chenyiting on 2022/3/31
 * 翻转二叉树
 */
public class L226 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }
}
