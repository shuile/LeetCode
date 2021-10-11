package cn.shui.learning_plan.offer.seventh;

import cn.shui.learning_plan.offer.model.TreeNode;

/**
 * @author shui.
 * @date 2021/10/11.
 * @time 14:29.
 */
public class Offer28 {
    public boolean isSymmetric(TreeNode root) {
        return help(root, root);
    }

    private boolean help(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null || left.val != right.val) {
            return false;
        }
        return help(left.left, right.right) && help(left.right, right.left);
    }
}
