package cn.shui.labuladong;

import cn.shui.labuladong.model.Node2;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by chenyiting on 2022/5/26
 * 填充每个节点的下一个右侧节点指针II
 */
public class L117 {
    public Node2 connect(Node2 root) {
        if (root == null) {
            return null;
        }
        Deque<Node2> deque = new LinkedList<>();
        deque.offer(root);
        Node2 node;
        while (!deque.isEmpty()) {
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                node = deque.poll();
                if (i != size - 1) {
                    node.next = deque.peek();
                }
                if (node.left != null) {
                    deque.offer(node.left);
                }
                if (node.right != null) {
                    deque.offer(node.right);
                }
            }
        }
        return root;
    }

    private Node2 last = null, nextStart = null;

    // 利用一创建的next指针
    public Node2 connect2(Node2 root) {
        Node2 start = root;
        while (start != null) {
            last = null;
            nextStart = null;
            for (Node2 p = start; p != null; p = p.next) {
                handle(p.left);
                handle(p.right);
            }
            start = nextStart;
        }
        return root;
    }

    private void handle(Node2 node) {
        if (node == null) {
            return;
        }
        if (last != null) {
            last.next = node;
        }
        if (nextStart == null) {
            nextStart = node;
        }
        last = node;
    }
}
