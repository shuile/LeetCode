package cn.shui.labuladong;

import cn.shui.labuladong.model.TreeNode;

/**
 * Created by chenyiting on 2022/5/27
 * 根据二叉树创建紫福春
 */
public class L606 {
    public String tree2str(TreeNode root) {
        StringBuilder ans = new StringBuilder();
        dfs(root, ans);
        return ans.toString();
    }

    private void dfs(TreeNode root, StringBuilder ans) {
        if (root == null) {
            return;
        }
        ans.append(root.val);
        if (root.left != null) {
            ans.append("(");
            dfs(root.left, ans);
            ans.append(")");

            if (root.right != null) {
                ans.append("(");
                dfs(root.right, ans);
                ans.append(")");
            }
        } else if (root.right != null) {
            ans.append("()");

            ans.append("(");
            dfs(root.right, ans);
            ans.append(")");
        }
    }
}
