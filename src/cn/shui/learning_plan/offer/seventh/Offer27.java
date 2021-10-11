package cn.shui.learning_plan.offer.seventh;

import cn.shui.learning_plan.offer.model.TreeNode;

/**
 * @author shui.
 * @date 2021/10/11.
 * @time 14:17.
 */
public class Offer27 {
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return root;
        }
        if (root.left == null) {
            root.left = mirrorTree(root.right);
            root.right = null;
            return root;
        }
        if (root.right == null) {
            root.right = mirrorTree(root.left);
            root.left = null;
            return root;
        }
        TreeNode temp = root.left;
        root.left = mirrorTree(root.right);
        root.right = mirrorTree(temp);
        return root;
    }

    // 递归
    public TreeNode mirrorTree2(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = mirrorTree(root.left);
        root.left = mirrorTree(root.right);
        root.right = left;
        return root;
    }
}
