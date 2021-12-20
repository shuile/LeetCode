package cn.shui.learning_plan.offerII;

import cn.shui.learning_plan.offerII.model.TreeNode;

/**
 * @author shui.
 * @date 2021/12/20.
 * @time 15:34.
 * 节点只和最大的路径
 */
public class Offer051 {
    private int ans = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return ans;
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftSum = Math.max(0, dfs(root.left));
        int rightSum = Math.max(0, dfs(root.right));
        ans = Math.max(ans, leftSum + rightSum + root.val);
        return root.val + Math.max(leftSum, rightSum);
    }
}
