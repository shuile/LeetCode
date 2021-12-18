package cn.shui.learning_plan.offerII;

import cn.shui.learning_plan.offerII.model.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author shui.
 * @date 2021/12/18.
 * @time 23:49.
 * 二叉树最底层左边的值
 */
public class Offer045 {
    public int findBottomLeftValue(TreeNode root) {
        if (root == null) {
            return -1;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        TreeNode ans = null;
        while (!queue.isEmpty()) {
            ans = queue.peek();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        return ans == null ? -1 : ans.val;
    }
}
