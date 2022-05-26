package cn.shui.codetop.client;

import cn.shui.codetop.client.model.TreeNode;

/**
 * Created by chenyiting on 2022/4/30
 */
public class L124 {

    private int ans = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        help(root);
        return ans;
    }

    private int help(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = Math.max(0, help(root.left));
        int right = Math.max(0, help(root.right));
        ans = Math.max(ans, root.val + left + right);
        return root.val + Math.max(left, right);
    }
}
