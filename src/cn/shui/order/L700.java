package cn.shui.order;

import cn.shui.order.base.TreeNode;

/**
 * @author shui.
 * @date 2021/11/26.
 * @time 10:24.
 * 二叉搜索树中的搜索
 */
public class L700 {
    public TreeNode searchBST(TreeNode root, int val) {
        return dfs(root, val);
    }

    private TreeNode dfs(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (root.val == val) {
            return root;
        }
        TreeNode ans = dfs(root.left, val);
        if (ans != null) {
            return ans;
        }
        return dfs(root.right, val);
    }
}
