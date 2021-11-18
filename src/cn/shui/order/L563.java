package cn.shui.order;

import cn.shui.order.base.TreeNode;

/**
 * @author shui.
 * @date 2021/11/18.
 * @time 13:48.
 * 二叉树的坡度
 */
public class L563 {

    private int ans = 0;

    public int findTilt(TreeNode root) {
        dfs(root);
        return ans;
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);
        ans += left > right ? left - right : right - left;
        return root.val + left + right;
    }
}
