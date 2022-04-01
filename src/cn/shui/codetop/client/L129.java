package cn.shui.codetop.client;

import cn.shui.codetop.client.model.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by chenyiting on 2022/3/31
 * 求根节点到叶节点数字之和
 */
public class L129 {

    // dfs
    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }

    private int dfs(TreeNode root, int parentSum) {
        if (root == null) {
            return 0;
        }
        parentSum = parentSum * 10 + root.val;
        if (root.left == null && root.right == null) {
            return parentSum;
        } else {
            return dfs(root.left, parentSum) + dfs(root.right, parentSum);
        }
    }

    // bfs
    public int sumNumbers2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        Queue<Integer> sumQueue = new LinkedList<>();
        nodeQueue.offer(root);
        sumQueue.offer(root.val);
        TreeNode node;
        int ans = 0;
        while (!nodeQueue.isEmpty()) {
            node = nodeQueue.poll();
            int sum = sumQueue.poll();
            if (node.left == null && node.right == null) {
                ans += sum;
            } else {
                if (node.left != null) {
                    nodeQueue.offer(node.left);
                    sumQueue.offer(sum * 10 + node.left.val);
                }
                if (node.right != null) {
                    nodeQueue.offer(node.right);
                    sumQueue.offer(sum * 10 + node.right.val);
                }
            }
        }
        return ans;
    }
}
