package cn.shui.order;

import cn.shui.order.base.Node;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author shui.
 * @date 2021/11/3.
 * @time 13:33.
 * 填充每个节点的下一个右侧节点
 */
public class L117 {
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
//            Node curr = queue.poll();
//            if (size > 1) {
//                Node next;
//                for (int i = 1; i < size; i++) {
//                    next = queue.poll();
//                    if (curr.left != null) {
//                        queue.offer(curr.left);
//                    }
//                    if (curr.right != null) {
//                        queue.offer(curr.right);
//                    }
//                    curr.next = next;
//                    curr = next;
//                }
//            }
//            if (curr.left != null) {
//                queue.offer(curr.left);
//            }
//            if (curr.right != null) {
//                queue.offer(curr.right);
//            }
            Node pre = null;
            for (int i = 0; i < size; i++) {
                Node curr = queue.poll();
                if (curr.left != null) {
                    queue.offer(curr.left);
                }
                if (curr.right != null) {
                    queue.offer(curr.right);
                }
                if (i != 0) {
                    pre.next = curr;
                }
                pre = curr;
            }
        }
        return root;
    }

    // 使用已建立的next指针
    private Node last = null, nextStart = null;

    public Node connect2(Node root) {
        if (root == null) {
            return null;
        }
        Node start = root;
        while (start != null) {
            last = null;
            nextStart = null;
            for (Node p = start; p != null; p = p.next) {
                if (p.left != null) {
                    handle(p.left);
                }
                if (p.right != null) {
                    handle(p.right);
                }
            }
            start = nextStart;
        }
        return root;
    }

    private void handle(Node p) {
        if (last != null) {
            last.next = p;
        }
        if (nextStart == null) {
            nextStart = p;
        }
        last = p;
    }
}
