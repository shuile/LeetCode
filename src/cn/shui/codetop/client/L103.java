package cn.shui.codetop.client;

import cn.shui.codetop.client.model.TreeNode;

import java.util.*;

/**
 * Created by chenyiting on 2022/3/20
 * 二叉树的锯齿形层序遍历
 */
public class L103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean isOrderLeft = true;
        while (!queue.isEmpty()) {
            Deque<Integer> level = new LinkedList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (isOrderLeft) {
                    level.offerLast(node.val);
                } else {
                    level.offerFirst(node.val);
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            ans.add(new LinkedList<>(level));
            isOrderLeft = !isOrderLeft;
        }
        return ans;
    }
}
