package cn.shui.learning_plan.offerII;

import cn.shui.learning_plan.offerII.model.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author shui.
 * @date 2021/12/20.
 * @time 16:31.
 * 所有大于等于节点的值之和
 */
public class Offer054 {
    public TreeNode covertBST(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        int sum = inorder(root, queue);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            int val = node.val;
            node.val = sum;
            sum -= val;
        }
        return root;
    }

    private int inorder(TreeNode node, Queue<TreeNode> queue) {
        if (node == null) {
            return 0;
        }
        int result = inorder(node.left, queue);
        queue.offer(node);
        result += node.val;
        result += inorder(node.right, queue);
        return result;
    }

    // 递归
    private int sum;
    public TreeNode covertBST2(TreeNode root) {
        sum = 0;
        dfs(root);
        return root;
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.right);
        sum += root.val;
        root.val = sum;
        dfs((root.left));
    }

    // 迭代
    public TreeNode covertBST3(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        int sum = 0;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.right;
            }
            curr = stack.pop();
            sum += curr.val;
            curr.val = sum;
            curr = curr.left;
        }
        return root;
    }
}
