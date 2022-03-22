package cn.shui.codetop.client;

import cn.shui.codetop.client.model.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by chenyiting on 2022/3/22
 * 二叉树的前序遍历
 */
public class L144 {

    private final List<Integer> ans = new ArrayList<>();

    // 递归
    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) {
            return ans;
        }
        ans.add(root.val);
        preorderTraversal(root.left);
        preorderTraversal(root.right);
        return ans;
    }

    // 迭代
    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                ans.add(node.val);
                stack.push(node);
                node = node.left;
            }
            if (!stack.isEmpty()) {
                node = stack.pop();
                node = node.right;
            }
        }
        return ans;
    }
}
