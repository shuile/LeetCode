package cn.shui.learning_plan.offer.eighteenth;

import cn.shui.learning_plan.offer.model.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author shui.
 * @date 2021/10/19.
 * @time 10:55.
 */
public class Offer55I {

    // 后续遍历 + DFS
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

    // BFS
    public int maxDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>(){{
            add(root);
        }};
        int res = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            res++;
        }
        return res;
    }
}
