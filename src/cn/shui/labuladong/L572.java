package cn.shui.labuladong;

import cn.shui.labuladong.model.TreeNode;

/**
 * Created by chenyiting on 2022/5/31
 * 另一棵树的子树
 */
public class L572 {
    public boolean isSubTree(TreeNode root, TreeNode subRoot) {
        if (root == null) {
            return subRoot == null;
        }
        if (root.val == subRoot.val) {
            if (compare(root, subRoot)) {
                return true;
            }
        }
        return isSubTree(root.left, subRoot.left) || isSubTree(root.right, subRoot.right);
    }

    private boolean compare(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) {
            return true;
        }
        if (root == null || subRoot == null || root.val != subRoot.val) {
            return false;
        }
        return compare(root.left, subRoot.left) && compare(root.right, subRoot.right);
    }
}
