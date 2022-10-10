package cn.shui.order;

import cn.shui.order.base.TreeNode;

/**
 * Created by chenyiting on 2022/10/10
 * 完全二叉树的节点个数
 */
public class L222 {
    public int countNodes(TreeNode root) {
        return root == null ? 0 : 1 + countNodes(root.left) + countNodes(root.right);
    }
}
