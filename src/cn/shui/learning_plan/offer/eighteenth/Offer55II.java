package cn.shui.learning_plan.offer.eighteenth;

import cn.shui.learning_plan.offer.model.TreeNode;

/**
 * @author shui.
 * @date 2021/10/19.
 * @time 11:02.
 */
public class Offer55II {

    // 自顶向下递归
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        if (left - right <= 1 && left - right >= -1) {
            return isBalanced(root.left) && isBalanced(root.right);
        }
        return false;
    }

    private int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

    // 自底向上递归
    public boolean isBalanced2(TreeNode root) {
        return height(root) >= 0;
    }

    private int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = height(root.left);
        int right = height(root.right);
        if (left == -1 || right == -1 || Math.abs(left - right) > 1) {
            return -1;
        } else {
            return Math.max(left, right) + 1;
        }
    }
}
