package cn.shui.codetop.client;

import cn.shui.codetop.client.model.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by chenyiting on 2022/3/27
 * 对称二叉树
 */
public class L101 {
    public boolean isSymmetric(TreeNode root) {
        return help(root, root);
    }

    private boolean help(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null || left.val != right.val) {
            return false;
        }
        return help(left.left, right.right) && help(left.right, right.left);
    }

    // 迭代
    public boolean isSymmetric2(TreeNode root) {
        return check(root, root);
    }

    private boolean check(TreeNode u, TreeNode v) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(u);
        queue.offer(v);
        while (!queue.isEmpty()) {
            u = queue.poll();
            v = queue.poll();
            if (u == null && v == null) {
                continue;
            }
            if (u == null || v == null || u.val != v.val) {
                return false;
            }
            queue.offer(u.left);
            queue.offer(v.right);
            queue.offer(u.right);
            queue.offer(v.left);
        }
        return true;
    }
}
