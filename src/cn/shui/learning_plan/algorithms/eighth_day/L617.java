package cn.shui.learning_plan.algorithms.eighth_day;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author shui.
 * @date 2021/7/21.
 * @time 19:40.
 * 合并二叉树
 */
public class L617 {
    public TreeNode mergeTrees1(TreeNode root1, TreeNode root2) {
        if (root1 == null) {
            return root2;
        }
        if (root2 == null) {
            return root1;
        }
        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();
        queue1.offer(root1);
        queue2.offer(root2);
        while (!queue1.isEmpty() || !queue2.isEmpty()) {
            TreeNode node1 = queue1.poll(), node2 = queue2.poll();
            node1.val += node2.val;
            if (node1.left != null && node2.left != null) {
                queue1.offer(node1.left);
                queue2.offer(node2.left);
            }
            if (node1.left == null && node2.left != null) {
                node1.left = node2.left;
            }
            if (node1.right != null && node2.right != null) {
                queue1.offer(node1.right);
                queue2.offer(node2.right);
            }
            if (node1.right == null && node2.right != null) {
                node1.right = node2.right;
            }
        }
        return root1;
    }

    // 深度优先搜索
    public TreeNode mergeTrees2(TreeNode root1, TreeNode root2) {
        if (root1 == null) {
            return root2;
        }
        if (root2 == null) {
            return root1;
        }
        TreeNode merge = new TreeNode(root1.val + root2.val);
        merge.left = mergeTrees2(root1.left, root2.left);
        merge.right = mergeTrees2(root1.right, root2.right);
        return merge;
    }
}
