package cn.shui.codetop.client;

import cn.shui.codetop.client.model.TreeNode;

import java.util.*;

/**
 * Created by chenyiting on 2022/6/14
 * 二叉树中所有距离为K的节点
 */
public class L863 {

    private Map<Integer, TreeNode> parent = new HashMap<>();

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        traverse(root, null);

        Queue<TreeNode> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        queue.offer(target);
        visited.add(target.val);
        List<Integer> ans = new ArrayList<>();

        int dist = 0;
        TreeNode subNode, parentNode;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                subNode = queue.poll();
                if (dist == k) {
                    ans.add(subNode.val);
                }
                parentNode = parent.get(subNode.val);
                if (parentNode != null && !visited.contains(parentNode.val)) {
                    visited.add(parentNode.val);
                    queue.offer(parentNode);
                }
                if (subNode.left != null && !visited.contains(subNode.left.val)) {
                    visited.add(subNode.left.val);
                    queue.offer(subNode.left);
                }
                if (subNode.right != null && !visited.contains(subNode.right.val)) {
                    visited.add(subNode.right.val);
                    queue.offer(subNode.right);
                }
            }
            dist++;
        }
        return ans;
    }

    private void traverse(TreeNode root, TreeNode parentNode) {
        if (root == null) {
            return;
        }
        parent.put(root.val, parentNode);
        traverse(root.left, root);
        traverse(root.right, root);
    }
}
