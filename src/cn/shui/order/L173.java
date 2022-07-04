package cn.shui.order;

import cn.shui.order.base.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by chenyiting on 2022/7/4
 * 二叉搜索树迭代器
 */
public class L173 {
    private class BSTIterator {

        private final Queue<TreeNode> queue = new LinkedList<>();

        public BSTIterator(TreeNode root) {
            dfs(root);
        }

        private void dfs(TreeNode root) {
            if (root == null) {
                return;
            }
            dfs(root.left);
            queue.offer(root);
            dfs(root.right);
        }

        public int next() {
            return hasNext() ? queue.poll().val : -1;
        }

        public boolean hasNext() {
            return !queue.isEmpty();
        }
    }
}
