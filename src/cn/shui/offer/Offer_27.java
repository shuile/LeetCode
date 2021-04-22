package cn.shui.offer;

import cn.shui.order.base.TreeNode;

public class Offer_27 {
    public static void main(String[] args) {

    }

    private TreeNode mirrorTree(TreeNode root) {
        if (root == null) {
            return root;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        mirrorTree(root.left);
        mirrorTree(root.right);
        return root;
    }
}
