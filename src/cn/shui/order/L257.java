package cn.shui.order;

import cn.shui.order.base.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenyiting on 2022/7/21
 * 二叉树的所有路径
 */
public class L257 {

    private List<String> ans = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) {
            return ans;
        }
        dfs(root, "" + root.val);
        return ans;
    }

    private void dfs(TreeNode root, String parent) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            ans.add(parent);
            return;
        }
        if (root.left != null) {
            dfs(root.left, parent + "->" + root.left.val);
        }
        if (root.right != null) {
            dfs(root.right, parent + "->" + root.right.val);
        }
    }

    private List<String> binaryTreePaths2(TreeNode root) {
        List<String> paths = new ArrayList<>();
        dfs(root, "", paths);
        return paths;
    }

    private void dfs(TreeNode root, String path, List<String> paths) {
        if (root != null) {
            StringBuilder sb = new StringBuilder(path);
            sb.append(root.val);
            if (root.left == null && root.right == null) {
                paths.add(sb.toString());
            } else {
                sb.append("->");
                dfs(root.left, sb.toString(), paths);
                dfs(root.right, sb.toString(), paths);
            }
        }
    }
}
