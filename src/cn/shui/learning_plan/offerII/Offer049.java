package cn.shui.learning_plan.offerII;

import cn.shui.learning_plan.offerII.model.TreeNode;

/**
 * @author shui.
 * @date 2021/12/19.
 * @time 22:20.
 * 从根节点到叶节点的路径数字只和
 */
public class Offer049 {
    public int sumNumbers(TreeNode root) {
        return dfs(root, "");
    }

    private int dfs(TreeNode root, String str) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return Integer.parseInt(str + root.val);
        }
        return dfs(root.left, str + root.val) + dfs(root.right, str + root.val);
    }

    public int sumNumbers2(TreeNode root) {
        return dfs(root, 0);
    }

    private int dfs(TreeNode root, int preSum) {
        if (root == null) {
            return 0;
        }
        int sum = preSum * 10 + root.val;
        if (root.left == null && root.right == null) {
            return sum;
        } else {
            return dfs(root.left, sum) + dfs(root.right, sum);
        }
    }
}
