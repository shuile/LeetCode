package cn.shui.labuladong;

import cn.shui.labuladong.model.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenyiting on 2022/5/27
 * 二叉树的前序遍历
 */
public class L144 {

    private final List<Integer> ans = new ArrayList<>();

    public List<Integer> preorderTraversal(TreeNode root) {
        if (root != null) {
            dfs(root);
        }
        return ans;
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        ans.add(root.val);
        dfs(root.left);
        dfs(root.right);
    }
}
