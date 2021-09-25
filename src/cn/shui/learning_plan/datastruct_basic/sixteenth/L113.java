package cn.shui.learning_plan.datastruct_basic.sixteenth;

import java.util.*;

/**
 * @author shui.
 * @date 2021/9/17.
 * @time 09:48.
 * 路径总和II
 */
public class L113 {

    private List<List<Integer>> ans;

    public List<List<Integer>> pathSum1(TreeNode root, int targetSum) {
        ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        helper(root, targetSum, 0, new ArrayList<>());
        return ans;
    }

    private void helper(TreeNode root, int targetSum, int currSum, List<Integer> list) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        currSum += root.val;
        if (currSum == targetSum && root.left == null && root.right == null) {
            ans.add(new ArrayList<>(list));
        } else {
            helper(root.left, targetSum, currSum, list);
            helper(root.right, targetSum, currSum, list);
        }
        list.remove(list.size() - 1);
    }

    // 深度优先搜索
    List<List<Integer>> ret = new ArrayList<>();
    Deque<Integer> path = new LinkedList<>();

    public List<List<Integer>> pathSum2(TreeNode root, int targetSum) {
        dfs(root, targetSum);
        return ret;
    }

    public void dfs(TreeNode root, int targetSum) {
        if (root == null) {
            return;
        }
        path.offerLast(root.val);
        targetSum -= root.val;
        if (root.left == null && root.right == null && targetSum == 0) {
            ret.add(new LinkedList<>(path));
        }
        dfs(root.left, targetSum);
        dfs(root.right, targetSum);
        path.pollLast();
    }

    // 广度优先搜索
    Map<TreeNode, TreeNode> map = new HashMap<>();

    public List<List<Integer>> pathSum3(TreeNode root, int targetSum) {
        if (root == null) {
            return ret;
        }
        Queue<TreeNode> queueNode = new LinkedList<>();
        Queue<Integer> queueSum = new LinkedList<>();
        queueNode.offer(root);
        queueSum.offer(0);
        while (!queueNode.isEmpty()) {
            TreeNode node = queueNode.poll();
            int rec = queueSum.poll() + node.val;
            if (node.left == null && node.right == null) {
                if (rec == targetSum) {
                    getPath(node);
                }
            } else {
                if (node.left != null) {
                    map.put(node.left, node);
                    queueNode.offer(node.left);
                    queueSum.offer(rec);
                }
                if (node.right != null) {
                    map.put(node.right, node);
                    queueNode.offer(node.right);
                    queueSum.offer(rec);
                }
            }
        }
        return ret;
    }

    private void getPath(TreeNode node) {
        List<Integer> temp = new LinkedList<>();
        while (node != null) {
            temp.add(node.val);
            node = map.get(node);
        }
        Collections.reverse(temp);
        ret.add(new LinkedList<>(temp));
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
