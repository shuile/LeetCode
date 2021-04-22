package cn.shui.offer;

import cn.shui.order.base.TreeNode;

public class Offer_26 {
    public static void main(String[] args) {

    }

    private boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null) {
            return false;
        }
        return dfs(A, B);
    }

    private boolean dfs(TreeNode node1, TreeNode node2) {
        if (node1 == null) {
            return false;
        }
        if (node1.val == node2.val && isValid(node1, node2)) {
            return true;
        }
        return dfs(node1.left, node2) || dfs(node1.right, node2);
    }

    private boolean isValid(TreeNode node1, TreeNode node2) {
        if (node2 == null) {
            return true;
        }
        if (node1 == null) {
            return false;
        }
        if (node1.val != node2.val) {
            return false;
        }
        return isValid(node1.left, node2.left) && isValid(node1.right, node2.right);
    }

    private boolean isSubStructure2(TreeNode A, TreeNode B) {
        return (A != null && B != null) && (isValid2(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B));
    }

    private boolean isValid2(TreeNode A, TreeNode B) {
        if (B == null) {
            return true;
        }
        if (A == null || A.val != B.val) {
            return false;
        }
        return isValid2(A.left, B.left) && isValid2(A.right, B.right);
    }
}
