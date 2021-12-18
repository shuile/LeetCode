package cn.shui.learning_plan.offerII;

import cn.shui.learning_plan.offerII.model.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author shui.
 * @date 2021/12/18.
 * @time 21:08.
 * 往完全二叉树添加节点
 */
public class Offer043 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        CBTInserter test = new CBTInserter(root);
        test.insert(2);
        test.insert(3);
        test.insert(4);
        test.get_root();
    }

    private static class CBTInserter {

        private final TreeNode mRoot;
        private final Queue<TreeNode> mQueue;

        public CBTInserter(TreeNode root) {
            mRoot = root;
            mQueue = new LinkedList<>();
            mQueue.offer(root);
            while (mQueue.peek().left != null && mQueue.peek().right != null) {
                TreeNode node = mQueue.poll();
                mQueue.offer(node.left);
                mQueue.offer(node.right);
            }
        }

        public int insert(int v) {
            TreeNode node = mQueue.peek();
            if (node.left == null) {
                node.left = new TreeNode(v);
            } else {
                node.right = new TreeNode(v);
                mQueue.poll();
                mQueue.offer(node.left);
                mQueue.offer(node.right);
            }
            return node.val;
        }

        public TreeNode get_root() {
            return mRoot;
        }
    }
}
