package cn.shui.order.minimum_depth_of_binary_tree_111;

import cn.shui.order.base.TreeNode;

public class Solution {

    public static void main(String[] args) {
        TreeNode node = new TreeNode(3);
        node.left = new TreeNode(9);
        node.right = new TreeNode(20);
        node.right.left = new TreeNode(15);
        node.right.right = new TreeNode(7);
        System.out.println(minDepth(node));
    }

    private static int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        int left, right;
        if (root.left != null) {
            left = minDepth(root.left);
        } else {
            left = Integer.MAX_VALUE;
        }
        if (root.right != null) {
            right = minDepth(root.right);
        } else {
            right = Integer.MAX_VALUE;
        }
        return Math.min(left, right) + 1;
    }
}
