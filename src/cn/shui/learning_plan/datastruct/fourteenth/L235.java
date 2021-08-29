package cn.shui.learning_plan.datastruct.fourteenth;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shui.
 * @date 2021/8/29.
 * @time 22:16.
 * 二叉搜索树的最近公共祖先
 */
public class L235 {

    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (root.val == p.val && hasNode(root, q)) {
            return root;
        }
        if (root.val == q.val && hasNode(root, p)) {
            return root;
        }
        if (p.val < root.val) {
            if (q.val < root.val) {
                return lowestCommonAncestor1(root.left, p, q);
            }
            return hasNode(root.left, p) && hasNode(root.right, q) ? root : null;
        } else {
            if (q.val > root.val) {
                return lowestCommonAncestor1(root.right, p, q);
            }
            return hasNode(root.left, q) && hasNode(root.right, p) ? root : null;
        }
    }

    private boolean hasNode(TreeNode root, TreeNode target) {
        if (root == null) {
            return false;
        }
        if (root.val == target.val) {
            return true;
        }
        return root.val < target.val ? hasNode(root.right, target) : hasNode(root.left, target);
    }

    // 两次遍历
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> path_p = getPath(root, p);
        List<TreeNode> path_q = getPath(root, q);
        TreeNode ancestor = null;
        for (int i = 0; i < path_p.size() && i < path_q.size(); i++) {
            if (path_p.get(i) == path_q.get(i)) {
                ancestor = path_p.get(i);
            } else {
                break;
            }
        }
        return ancestor;
    }

    private List<TreeNode> getPath(TreeNode root, TreeNode target) {
        List<TreeNode> path = new ArrayList<>();
        TreeNode node = root;
        while (node != target) {
            path.add(node);
            if (target.val < node.val) {
                node = node.left;
            } else {
                node = node.right;
            }
        }
        path.add(node);
        return path;
    }

    // 一次遍历
    public TreeNode lowestCommonAncestor3(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode ancestor = root;
        while (true) {
            if (p.val < ancestor.val && q.val < ancestor.val) {
                ancestor = ancestor.left;
            } else if (p.val > ancestor.val && q.val > ancestor.val) {
                ancestor = ancestor.right;
            } else {
                break;
            }
        }
        return ancestor;
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
