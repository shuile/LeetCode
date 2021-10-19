package cn.shui.learning_plan.offer.ninteenth;

import cn.shui.learning_plan.offer.model.TreeNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author shui.
 * @date 2021/10/19.
 * @time 11:48.
 */
public class Offer68II {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == root || q == null) {
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
        if (node == root) {
            return true;
        }
        return find(root.left, node) || find(root.right, node);
    }

    // 递归
    private TreeNode ans;

    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p, q);
        return ans;
    }

    private boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return false;
        }
        boolean lson = dfs(root.left, p, q);
        boolean rson = dfs(root.right, p, q);
        if ((lson && rson) || ((root.val == p.val || root.val == q.val) && (lson || rson))) {
            ans = root;
        }
        return lson || rson || (root.val == p.val || root.val == q.val);
    }

    // 存储父节点
    private Map<Integer, TreeNode> parent = new HashMap<>();
    private Set<Integer> visited = new HashSet<>();

    public TreeNode lowestCommonAncestor3(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root);
        while (p != null) {
            visited.add(p.val);
            p = parent.get(p.val);
        }
        while (q != null) {
            if (visited.contains(q.val)) {
                return q;
            }
            q = parent.get(q.val);
        }
        return null;
    }

    private void dfs(TreeNode root) {
        if (root.left != null) {
            parent.put(root.left.val, root);
            dfs(root.left);
        }
        if (root.right != null) {
            parent.put(root.right.val, root);
            dfs(root.right);
        }
    }
}
