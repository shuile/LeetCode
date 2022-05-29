package cn.shui.labuladong;

import cn.shui.labuladong.model.TreeNode;

/**
 * Created by chenyiting on 2022/5/30
 * 二叉树的堂兄弟节点
 */
public class L993 {

    private static final TreeNode TEST1 = new TreeNode(1);
    private static final TreeNode TEST2 = new TreeNode(1);

    static {
        TEST1.left = new TreeNode(2);
        TEST1.right = new TreeNode(3);
        TEST1.left.right = new TreeNode(4);
        TEST1.right.right = new TreeNode(5);

        TEST2.left = new TreeNode(2);
        TEST2.right = new TreeNode(3);
        TEST2.left.left = new TreeNode(4);
    }

    public static void main(String[] args) {
        L993 test = new L993();
        test.isCousins(TEST2, 4, 3);
    }

    public boolean isCousins(TreeNode root, int x, int y) {
        if (root == null || root.val == x || root.val == y) {
            return false;
        }
        int xDepth = dfs(root, x);
        int yDepth = dfs(root, y);
        if (xDepth != yDepth) {
            return false;
        }
        TreeNode commonParent = dfsCommonNode(root, x, y);
        return (commonParent.left.val == x && commonParent.right.val == y) || (commonParent.left.val == y && commonParent.right.val == x);
    }

    private int dfs(TreeNode root, int target) {
        if (root == null) {
            return 0;
        }
        if (root.val == target) {
            return 1;
        }
        int left = dfs(root.left, target);
        if (left > 0) {
            return left + 1;
        }
        int right = dfs(root.right, target);
        return right > 0 ? right + 1 : 0;
    }

    private TreeNode dfsCommonNode(TreeNode root, int x, int y) {
        if (root == null) {
            return null;
        }
        if (hasNode(root.left, x)) {
            if (hasNode(root.right, y)) {
                return root;
            }
            return dfsCommonNode(root.left, x, y);
        } else {
            if (hasNode(root.left, y)) {
                return root;
            }
            return dfsCommonNode(root.right, x, y);
        }
    }

    private boolean hasNode(TreeNode root, int target) {
        if (root == null) {
            return false;
        }
        return root.val == target || hasNode(root.left, target) || hasNode(root.right, target);
    }
}
