package cn.shui.learning_plan.offer.fifteenth;

import cn.shui.learning_plan.offer.model.TreeNode;

/**
 * @author shui.
 * @date 2021/10/15.
 * @time 16:10.
 */
public class Offer54 {

    private int k;

    public int kthLargest(TreeNode root, int k) {
        if (root == null) {
            return -1;
        }
        this.k = k;
        return dfs(root);
    }

    private int dfs(TreeNode cur) {
        if (cur == null) {
            return -1;
        }
        int res = dfs(cur.right);
        if (res != -1) {
            return res;
        }
        if (k == 1) {
            return cur.val;
        }
        k--;
        return dfs(cur.left);
    }
}
