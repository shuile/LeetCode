package cn.shui.offer;

import cn.shui.order.base.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Offer_34 {
    public static void main(String[] args) {

    }

    private List<List<Integer>> ans;

    private List<List<Integer>> pathSum(TreeNode root, int target) {
        ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        bfs(root, target, new ArrayList<>());
        return ans;
    }

    private void bfs(TreeNode node, int target, List<Integer> list) {
        list.add(node.val);
        if (node.left == null && node.right == null && target == node.val) {
            ans.add(new ArrayList<>(list));
            list.remove(list.size() - 1);
            return;
        }
        if (node.left != null) {
            bfs(node.left, target - node.val, list);
        }
        if (node.right != null) {
            bfs(node.right, target - node.val, list);
        }
        list.remove(list.size() - 1);
    }

    private List<List<Integer>> pathSum2(TreeNode root, int target) {
        ans = new ArrayList<>();
        if (root != null) {
            bfs(root, target, new ArrayList<>());
        }
        return ans;
    }
}
