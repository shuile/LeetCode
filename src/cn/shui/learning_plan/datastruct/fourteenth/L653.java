package cn.shui.learning_plan.datastruct.fourteenth;

import java.util.*;

/**
 * @author shui.
 * @date 2021/8/29.
 * @time 17:44.
 * 两数之和IV - 输入BST
 */
public class L653 {

    public boolean findTarget1(TreeNode root, int k) {
        if (root == null) {
            return false;
        }
        return findTarget1(root, root, k);
    }

    private boolean findTarget1(TreeNode left, TreeNode right, int k) {
        if (left == null || right == null) {
            return false;
        }
        if (left == right) {
            if (left.val * 2 < k) {
                return findTarget1(left.right, right, k) || findTarget1(left, right.right, k);
            } else {
                return findTarget1(left.left, right, k) || findTarget1(left, right.left, k);
            }
        }
        int sum = left.val + right.val;
        if (sum == k) {
            return true;
        }
        if (sum < k) {
            return findTarget1(left.right, right, k) || findTarget1(left, right.right, k);
        } else {
            return findTarget1(left.left, right, k) || findTarget1(left, right.left, k);
        }
    }

    private boolean findTarget2(TreeNode root, int k) {
        Set<Integer> set = new HashSet<>();
        return find(root, k, set);
    }

    // 使用HashSet
    private boolean find(TreeNode root, int k, Set<Integer> set) {
        if (root == null) {
            return false;
        }
        if (set.contains(k - root.val)) {
            return true;
        }
        set.add(root.val);
        return find(root.left, k, set) || find(root.right, k, set);
    }

    // 使用BFS和HashSet
    public boolean findTarget3(TreeNode root, int k) {
        Set<Integer> set = new HashSet<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            if (queue.peek() != null) {
                TreeNode node = queue.remove();
                if (set.contains(k - node.val)) {
                    return true;
                }
                set.add(node.val);
                queue.add(node.left);
                queue.add(node.right);
            } else {
                queue.remove();
            }
        }
        return false;
    }

    // 使用BFS
    public boolean findTarget4(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        inorder(root, list);
        int l = 0, r = list.size() - 1;
        while (l < r) {
            int sum = list.get(l) + list.get(r);
            if (sum == k) {
                return true;
            }
            if (sum < k) {
                l++;
            } else {
                r--;
            }
        }
        return false;
    }

    private void inorder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
