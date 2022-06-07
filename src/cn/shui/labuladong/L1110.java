package cn.shui.labuladong;

import cn.shui.labuladong.model.TreeNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by chenyiting on 2022/6/1
 * 删点成林
 */
public class L1110 {

    // 优化
    public List<TreeNode> delNodes2(TreeNode root, int[] to_delete) {
        ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        for (int i : to_delete) {
            deleted.add(i);
        }
        doDelete(root, false);
        return ans;
    }

    private TreeNode doDelete(TreeNode root, boolean hasParent) {
        if (root == null) {
            return null;
        }
        boolean delRes = deleted.contains(root.val);
        if (!delRes && !hasParent) {
             ans.add(root);
        }
        root.left = doDelete(root.left, !delRes);
        root.right = doDelete(root.right, !delRes);
        return delRes ? null : root;
    }

    private Set<Integer> deleted;
    private List<TreeNode> ans;

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        deleted = new HashSet<>();
        for (int i : to_delete) {
            deleted.add(i);
        }
        ans.add(root);
        dfs(root, null, true);
        return ans;
    }

    private void dfs(TreeNode root, TreeNode parent, boolean isSubLeft) {
        if (root == null) {
            return;
        }
        if (deleted.contains(root.val)) {
            if (parent != null) {
                if (isSubLeft) {
                    parent.left = null;
                } else {
                    parent.right = null;
                }
            }
            if (ans.contains(root)) {
                ans.remove(root);
            }
            if (root.left != null) {
                ans.add(root.left);
            }
            if (root.right != null) {
                ans.add(root.right);
            }
        }
        dfs(root.left, root, true);
        dfs(root.right, root, false);
    }
}
