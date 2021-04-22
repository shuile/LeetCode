package cn.shui.offer;

import cn.shui.order.base.TreeNode;

public class Offer_28 {
    public static void main(String[] args) {

    }

    private boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isValid(root.left, root.right);
    }

    private boolean isValid(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null || left.val != right.val) {
            return false;
        }
        return isValid(left.left, right.right) && isValid(left.right, right.left);
    }
}
