package cn.shui.learning_plan.offerII;

import cn.shui.learning_plan.offerII.model.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author shui.
 * @date 2021/12/20.
 * @time 15:50.
 * 展开二叉搜索树
 */
public class Offer052 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(3);
        Offer052 test = new Offer052();
        test.increasingBST(root);
    }

    private final Queue<TreeNode> mQueue = new LinkedList<>();

    public TreeNode increasingBST(TreeNode root) {
        dfs(root);
        TreeNode newRoot = mQueue.poll();
        TreeNode curr = newRoot;
        while (!mQueue.isEmpty()) {
            curr.left = null;
            curr.right = mQueue.poll();
            curr = curr.right;
        }
        if (curr != null) {
            curr.left = null;
            curr.right = null;
        }
        return newRoot;
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        mQueue.offer(root);
        dfs(root.right);
    }

    // 中序遍历中改变节点指向

    private TreeNode resNode;

    public TreeNode increasingBST2(TreeNode root) {
        TreeNode dummyNode = new TreeNode(-1);
        resNode = dummyNode;
        inorder(root);
        return dummyNode.right;
    }

    private void inorder(TreeNode node) {
        if (node == null) {
            return;
        }
        inorder(node.left);

        // 在中序遍历的过程中修改节点指向
        resNode.right = node;
        node.left = null;
        resNode = node;

        inorder(node.right);
    }
}
