package cn.shui.learning_plan.offerII;

import cn.shui.learning_plan.offerII.model.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author shui.
 * @date 2021/12/20.
 * @time 16:46.
 * 二叉搜索树迭代器
 */
public class Offer055 {
    private class BSTIterator {

        private final Queue<TreeNode> mQueue;

        public BSTIterator(TreeNode root) {
            mQueue = new LinkedList<>();
            inorder(root);
        }

        private void inorder(TreeNode root) {
            if (root == null) {
                return;
            }
            inorder(root.left);
            mQueue.offer(root);
            inorder(root.right);
        }

        private int next() {
            return hasNext() ? mQueue.poll().val : -1;
        }

        private boolean hasNext() {
            return !mQueue.isEmpty();
        }
    }

    private class BSTIterator2 {
        private final Stack<TreeNode> mStack;
        private TreeNode curr;

        public BSTIterator2(TreeNode root) {
            curr = root;
            mStack = new Stack<>();
        }

        public int next() {
            while (curr != null) {
                mStack.push(curr);
                curr = curr.left;
            }
            curr = mStack.pop();
            int ret = curr.val;
            curr = curr.right;
            return ret;
        }

        private boolean hasNext() {
            return curr != null || !mStack.isEmpty();
        }
    }
}
