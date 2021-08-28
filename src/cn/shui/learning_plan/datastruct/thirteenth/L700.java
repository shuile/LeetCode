package cn.shui.learning_plan.datastruct.thirteenth;

/**
 * @author shui.
 * @date 2021/8/28.
 * @time 23:59.
 * 二叉搜索树中的搜索
 */
public class L700 {

    public TreeNode searchBST1(TreeNode root, int val) {
        if (root == null || root.val == val) {
            return root;
        }
        if (root.val < val) {
            return searchBST1(root.right, val);
        } else {
            return searchBST1(root.left, val);
        }
    }

    // 迭代
    public TreeNode searchBST2(TreeNode root, int val) {
        while (root != null && val != root.val) {
            root = val < root.val ? root.left : root.right;
        }
        return root;
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
