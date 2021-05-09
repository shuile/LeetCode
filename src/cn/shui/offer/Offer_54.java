package cn.shui.offer;

import cn.shui.offer.domain.TreeNode;

public class Offer_54 {
    public static void main(String[] args) {

    }

    private int res, k;

    private int kthLargest(TreeNode root, int k) {
        this.k = k;
        dfs(root);
        return res;
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.right);
        if (k == 0) {
            return;
        }
        if (--k == 0) {
            res = root.val;
        }
        dfs(root.left);
    }
}
