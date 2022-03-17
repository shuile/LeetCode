package cn.shui.codetop.client;

import cn.shui.codetop.client.model.TreeNode;

/**
 * Created by chenyiting on 2022/3/17
 * 二叉树的最近公共祖先
 */
public class L236 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p == root || q == root) {
            return root;
        }
        if (hasNode(root.left, p)) {
            return hasNode(root.left, q) ? lowestCommonAncestor(root.left, p, q) : root;
        } else {
            return hasNode(root.right, q) ? lowestCommonAncestor(root.right, p, q) : root;
        }
    }

    private boolean hasNode(TreeNode root, TreeNode node) {
        if (root == null) {
            return false;
        }
        if (root == node) {
            return true;
        }
        return hasNode(root.left, node) || hasNode(root.right, node);
    }

    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null) {
            return null;
        }
        TreeNode left = lowestCommonAncestor2(root.left, p, q);
        TreeNode right = lowestCommonAncestor2(root.right, p, q);
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }
        return root;
    }
}
