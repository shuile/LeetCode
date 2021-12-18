package cn.shui.learning_plan.offerII;

import cn.shui.learning_plan.offerII.model.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author shui.
 * @date 2021/12/18.
 * @time 23:38.
 * 二叉树每层的最大值
 */
public class Offer044 {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int max = Integer.MIN_VALUE;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                max = Math.max(max, node.val);
            }
            ans.add(max);
        }
        return ans;
    }
}
