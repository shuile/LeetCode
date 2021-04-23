package cn.shui.offer;

import cn.shui.offer.domain.TreeNode;

import java.util.*;

public class Offer_32III {
    public static void main(String[] args) {

    }

    private List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> ans = new ArrayList<>();
        if (root != null) {
            queue.offer(root);
        }
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int index = ans.size() + 1;
            for (int i = queue.size(); i > 0; i--) {
                TreeNode node = queue.poll();
                if (index % 2 == 1) {
                    list.add(node.val);
                } else {
                    list.add(0, node.val);
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            ans.add(list);
        }
        return ans;
    }

    private List<List<Integer>> levelOrder2(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> ans = new ArrayList<>();
        if (root != null) {
            queue.add(root);
        }
        while (!queue.isEmpty()) {
            LinkedList<Integer> tmp = new LinkedList<>();
            for (int i = queue.size(); i > 0; i--) {
                TreeNode node = queue.poll();
                if (ans.size() % 2 == 0) {
                    tmp.addLast(node.val);
                } else {
                    tmp.addFirst(node.val);
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            ans.add(tmp);
        }
        return ans;
    }

    private List<List<Integer>> levelOrder3(TreeNode root) {
        Deque<TreeNode> deque = new LinkedList<>();
        List<List<Integer>> ans = new ArrayList<>();
        if (root != null) {
            deque.add(root);
        }
        while (!deque.isEmpty()) {
            // 打印奇数层
            List<Integer> list = new ArrayList<>();
            for (int i = deque.size(); i > 0; i--) {
                // 从左向右打印
                TreeNode node = deque.removeFirst();
                list.add(node.val);
                // 从左到右加入下层节点
                if (node.left != null) {
                    deque.addLast(node.left);
                }
                if (node.right != null) {
                    deque.addLast(node.right);
                }
            }
            ans.add(list);
            // 打印偶数层
            list = new ArrayList<>();
            for (int i = deque.size(); i > 0; i--) {
                // 从右向左打印
                TreeNode node = deque.removeLast();
                list.add(node.val);
                // 从右向左加入下层节点
                if (node.right != null) {
                    deque.addFirst(node.right);
                }
                if (node.left != null) {
                    deque.addFirst(node.left);
                }
            }
            ans.add(list);
        }
        return ans;
    }
}
