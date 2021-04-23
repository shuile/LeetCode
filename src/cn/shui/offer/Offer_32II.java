package cn.shui.offer;

import cn.shui.offer.domain.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Offer_32II {
    public static void main(String[] args) {

    }

    private List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        dfs(root, ans, 1);
        return ans;
    }

    private void dfs(TreeNode node, List<List<Integer>> list, int index) {
        if (node == null) {
            return;
        }
        if (list.size() < index) {
            List<Integer> top = new ArrayList<>();
            list.add(top);
        }
        List<Integer> cur = list.get(index - 1);
        cur.add(node.val);
        dfs(node.left, list, index + 1);
        dfs(node.right, list, index + 1);
    }

    private List<List<Integer>> levelOrder2(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> ans = new ArrayList<>();
        if (root != null) {
            queue.add(root);
        }
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            for (int i = queue.size(); i > 0; i--) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            ans.add(list);
        }
        return ans;
    }
}
