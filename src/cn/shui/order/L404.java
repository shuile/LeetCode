package cn.shui.order;

import cn.shui.order.base.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by chenyiting on 2025/4/12
 * Sum of Left Leaves
 */
public class L404 {
    /**
     * dfs
     */
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return 0;
        }
        return dfsLeft(root.left) + dfsRight(root.right);
    }

    private int dfsLeft(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return root.val;
        }
        return dfsLeft(root.left) + dfsRight(root.right);
    }

    private int dfsRight(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return 0;
        }
        return dfsLeft(root.left) + dfsRight(root.right);
    }

    /**
     * bfs
     */
    public int sumOfLeftLeaves2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int ans = 0;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left != null) {
                if (isLeafNode(node.left)) {
                    ans += node.left.val;
                } else {
                    queue.offer(node.left);
                }
            }
            if (node.right != null && !isLeafNode(node.right)) {
                queue.offer(node.right);
            }
        }
        return ans;
    }

    private boolean isLeafNode(TreeNode root) {
        return root.left == null && root.right == null;
    }
}
