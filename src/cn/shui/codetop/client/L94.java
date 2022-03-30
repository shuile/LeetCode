package cn.shui.codetop.client;

import cn.shui.codetop.client.model.TreeNode;

import java.util.*;

/**
 * Created by chenyiting on 2022/3/30
 * 二叉树的中序遍历
 */
public class L94 {

    // 递归
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        dfs(root, ans);
        return ans;
    }

    private void dfs(TreeNode root, List<Integer> ans) {
        if (root == null) {
            return;
        }
        dfs(root.left, ans);
        ans.add(root.val);
        dfs(root.right, ans);
    }

    // 迭代
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Deque<TreeNode> deque = new LinkedList<>();
        TreeNode node = root;
        while (node != null || !deque.isEmpty()) {
            while (node != null) {
                deque.offer(node);
                node = node.left;
            }
            if (!deque.isEmpty()) {
                node = deque.poll();
                ans.add(node.val);
                node = node.right;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        L94 test = new L94();
        test.inorderTraversal2(root);
    }
}
