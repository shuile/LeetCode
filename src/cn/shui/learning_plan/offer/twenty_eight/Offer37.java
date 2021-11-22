package cn.shui.learning_plan.offer.twenty_eight;

import cn.shui.order.base.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author shui.
 * @date 2021/11/22.
 * @time 09:20.
 * 序列化二叉树
 */
public class Offer37 {

    public static void main(String[] args) {
        Codec test = new Codec();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        String serialize = test.serialize(root);
        TreeNode deserialize = test.deserialize(serialize);
        System.out.println("serialize=" + serialize);
    }

    private static class Codec {
        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            if (root == null) {
                return null;
            }
            StringBuilder ans = new StringBuilder();
            Deque<TreeNode> deque = new LinkedList<>();
            deque.offer(root);
            while (!deque.isEmpty()) {
                TreeNode node = deque.poll();
                if (node == null) {
                    ans.append("null").append(" ");
                    continue;
                } else {
                    ans.append(node.val).append(" ");
                }
                deque.offer(node.left);
                deque.offer(node.right);
            }
            return ans.toString().trim();
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if (data == null) {
                return null;
            }
            String[] split = data.split("\\s+");
            if ("null".equals(split[0])) {
                return null;
            }
            TreeNode ans = new TreeNode(Integer.parseInt(split[0]));
            Deque<TreeNode> deque = new LinkedList<>();
            int state = 0; // 0 左子节点；1 右子节点；2 下一个节点
            TreeNode curr = ans;
            for (int i = 1; i < split.length; i++) {
                String temp = split[i];
                if (state == 2) {
                    curr = deque.poll();
                    state = 0;
                }
                if ("null".equals(temp)) {
                    state++;
                    continue;
                }
                TreeNode node = new TreeNode(Integer.parseInt(temp));
                if (state == 0) {
                    curr.left = node;
                }
                if (state == 1) {
                    curr.right = node;
                }
                state++;
                deque.offer(node);
            }
            return ans;
        }
    }

    private static class Codec2 {
        public String serialize(TreeNode root) {
            if (root == null) {
                return "[]";
            }
            StringBuilder res = new StringBuilder();
            Queue<TreeNode> queue = new LinkedList<>();
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                if (node != null) {
                    res.append(node.val + ",");
                    queue.add(node.left);
                    queue.add(node.right);
                } else {
                    res.append("null,");
                }
            }
            res.deleteCharAt(res.length() - 1);
            res.append("]");
            return res.toString();
        }

        public TreeNode deserialize(String data) {
            if (data.equals("[]")) {
                return null;
            }
            String[] vals = data.substring(1, data.length() - 1).split(",");
            TreeNode root = new TreeNode(Integer.parseInt(vals[0]));
            Queue<TreeNode> queue = new LinkedList<TreeNode>() {{
                offer(root);
            }};
            int i = 1;
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                if (!vals[i].equals("null")) {
                    node.left = new TreeNode(Integer.parseInt(vals[i]));
                    queue.offer(node.left);
                }
                i++;
                if (!vals[i].equals("null")) {
                    node.right = new TreeNode(Integer.parseInt(vals[i]));
                    queue.offer(node.right);
                }
                i++;
            }
            return root;
        }
    }
}
