package cn.shui.labuladong;

import cn.shui.labuladong.model.TreeNode;

/**
 * Created by chenyiting on 2022/5/28
 * 最长同值路径
 */
public class L687 {

    private int ans = 0;

    public int longestUnivaluePath(TreeNode root) {
        if (root == null) {
            return 0;
        }
        dfs(root, root.val);
        return ans;
    }

    private int dfs(TreeNode root, int parentVal) {
        if (root == null) {
            return 0;
        }
        int left = dfs(root.left, root.val);
        int right = dfs(root.right, root.val);
        ans = Math.max(ans, left + right);
        if (root.val != parentVal) {
            return 0;
        }
        return 1 + Math.max(left, right);
    }
}
