package cn.shui.order;

import cn.shui.order.base.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author shui.
 * @date 2021/11/9.
 * @time 09:26.
 * 求根节点到叶节点数字只和
 */
public class L129 {

    private long ans = 0;

    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        dfs(root, 0);
        return (int) ans;
    }

    private void dfs(TreeNode root, long num) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            ans += num * 10 + root.val;
            return;
        }
        dfs(root.left, num * 10 + root.val);
        dfs(root.right, num * 10 + root.val);
    }

    // 深度优先搜索
    public int sumNumbers2(TreeNode root) {
        return dfs2(root, 0);
    }

    private int dfs2(TreeNode root, int preSum) {
        if (root == null) {
            return 0;
        }
        int sum = preSum * 10 + root.val;
        if (root.left == null && root.right == null) {
            return sum;
        } else {
            return dfs2(root.left, sum) + dfs2(root.right, sum);
        }
    }

    // 广度优先搜索
    public int sumNumbers3(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int sum = 0;
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        Queue<Integer> numQueue = new LinkedList<>();
        nodeQueue.offer(root);
        numQueue.offer(root.val);
        while (!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.poll();
            int num = numQueue.poll();
            TreeNode left = node.left, right = node.right;
            if (left == null && right == null) {
                sum += num;
            } else {
                if (left != null) {
                    nodeQueue.offer(left);
                    numQueue.offer(num * 10 + left.val);
                }
                if (right != null) {
                    nodeQueue.offer(right);
                    numQueue.offer(num * 10 + right.val);
                }
            }
        }
        return sum;
    }
}
