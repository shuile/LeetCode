package cn.shui.learning_plan.offerII;

import cn.shui.learning_plan.offerII.model.TreeNode;

/**
 * @author shui.
 * @date 2021/12/20.
 * @time 16:18.
 * 二叉搜索树中的中序后继
 */
public class Offer053 {

    private boolean isFind = false;

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        return inorder(root, p);
    }

    private TreeNode inorder(TreeNode node, TreeNode p) {
        if (node == null) {
            return null;
        }
        TreeNode ret = inorder(node.left, p);
        if (ret != null) {
            return ret;
        }
        if (isFind) {
            return node;
        }
        if (node == p) {
            isFind = true;
        }
        return inorder(node.right, p);
    }

    // 利用二叉搜索树的特性查找
    public TreeNode inorderSuccessor2(TreeNode root, TreeNode p) {
        TreeNode curr = root;
        TreeNode ans = null;
        while (curr != null) {
            if (curr.val > p.val) {
                ans = curr;
                curr = curr.left;
            } else {
                curr = curr.right;
            }
        }
        return ans;
    }
}
