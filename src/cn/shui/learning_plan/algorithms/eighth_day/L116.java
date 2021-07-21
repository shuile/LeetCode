package cn.shui.learning_plan.algorithms.eighth_day;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author shui.
 * @date 2021/7/21.
 * @time 23:59.
 * 填充每个节点的下一个右侧节点指针
 */
public class L116 {
    public Node connect1(Node root) {
        if (root == null) {
            return null;
        }
        if (root.left == null || root.right == null) {
            return root;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        Node prev = new Node(), curr;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                curr = queue.poll();
                if (curr.left != null) {
                    queue.offer(curr.left);
                }
                if (curr.right != null) {
                    queue.offer(curr.right);
                }
                if (i == 0) {
                    prev = curr;
                    continue;
                }
                prev.next = curr;
                prev = curr;
            }
        }
        return root;
    }

    // 层次遍历
    public Node connect2(Node root) {
        if (root == null) {
            return null;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                if (i < size - 1) {
                    node.next = queue.peek();
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        return root;
    }

    // 使用已建立的next指针
    public Node connect3(Node root) {
        if (root == null) {
            return null;
        }
        Node leftmost = root;
        while (leftmost.left != null) {
            Node head = leftmost;
            while (head != null) {
                head.left.next = head.right;
                if (head.next != null) {
                    head.right.next = head.next.left;
                }
                head = head.next;
            }
            leftmost = leftmost.left;
        }
        return root;
    }
}
