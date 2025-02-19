package cn.shui.codetop.client;

import cn.shui.codetop.client.model.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by chenyiting on 2023/8/19
 * 二叉树最大深度
 */
public class L662 {
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int width = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {

        }
        return 0;
    }
}
