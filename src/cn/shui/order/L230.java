package cn.shui.order;

import cn.shui.order.base.TreeNode;

/**
 * Created by chenyiting on 2022/10/14
 * 二叉搜索树中第k小的元素
 */
public class L230 {

    private int k;

    public int kthSmallest(TreeNode root, int k) {
        this.k = k;
        return dfs(root);
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int ans = dfs(root.left);
        if (k == 0) {
            return ans;
        }
        k--;
        if (k == 0) {
            return root.val;
        }
        return dfs(root.right);
    }
}
