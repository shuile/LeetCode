package cn.shui.learning_plan.offer.ninteenth;

import cn.shui.learning_plan.offer.model.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shui.
 * @date 2021/10/19.
 * @time 11:24.
 */
public class Offer68I {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == p || root == q) {
            return root;
        }
        if (find(root.left, p)) {
            if (find(root.right, q)) {
                return root;
            } else {
                return lowestCommonAncestor(root.left, p, q);
            }
        } else {
            if (find(root.left, q)) {
                return root;
            } else {
                return lowestCommonAncestor(root.right, p, q);
            }
        }
    }

    private boolean find(TreeNode root, TreeNode node) {
        if (root == null) {
            return false;
        }
        if (root == node) {
            return true;
        }
        return find(root.left, node) || find(root.right, node);
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
}
