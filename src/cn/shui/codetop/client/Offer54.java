package cn.shui.codetop.client;

import cn.shui.codetop.client.model.TreeNode;

/**
 * Created by chenyiting on 2022/4/10
 * 二叉搜索树的第k大节点
 */
public class Offer54 {

    private int k;

    public int kthLargest(TreeNode root, int k) {
        this.k = k;
        return dfs(root);
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return -1;
        }
        int ret = dfs(root.right);
        if (ret != -1) {
            return ret;
        }
        k--;
        if (k == 0) {
            return root.val;
        }
        return dfs(root.left);
    }
}
