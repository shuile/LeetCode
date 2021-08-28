package cn.shui.learning_plan.datastruct.twelfth;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author shui.
 * @date 2021/8/27.
 * @time 10:31.
 * 路径总和
 */
public class L112 {

    public boolean hasPathSum1(TreeNode root, int targetSum) {
        return help(root, 0, targetSum);
    }

    private boolean help(TreeNode root, int currSum, int targetSum) {
        if (root == null) {
            return false;
        }
        currSum += root.val;
        if (root.left == null && root.right == null) {
            return currSum == targetSum;
        }
        return help(root.left, currSum, targetSum) || help(root.right, currSum, targetSum);
    }

    // 广度优先搜索
    public boolean hasPathSum2(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        Queue<TreeNode> queueNode = new LinkedList<>();
        Queue<Integer> queueVal = new LinkedList<>();
        queueNode.offer(root);
        queueVal.offer(root.val);
        while (!queueNode.isEmpty()) {
            TreeNode now = queueNode.poll();
            int temp = queueVal.poll();
            if (now.left == null && now.right == null) {
                if (temp == targetSum) {
                    return true;
                }
                continue;
            }
            if (now.left != null) {
                queueNode.offer(now.left);
                queueVal.offer(now.left.val + temp);
            }
            if (now.right != null) {
                queueNode.offer(now.right);
                queueVal.offer(now.right.val + temp);
            }
        }
        return false;
    }

    // 递归
    public boolean hasPathSum3(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return targetSum == root.val;
        }
        return hasPathSum3(root.left, targetSum - root.val) || hasPathSum1(root.right, targetSum - root.val);
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
