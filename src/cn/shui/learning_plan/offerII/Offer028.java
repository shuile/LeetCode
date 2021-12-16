package cn.shui.learning_plan.offerII;

import cn.shui.learning_plan.offerII.model.Node;

import java.util.Stack;

/**
 * @author shui.
 * @date 2021/12/10.
 * @time 23:44.
 * 展开多级双向链表
 */
public class Offer028 {

    public Node flatten(Node head) {
        if (head == null) {
            return null;
        }
        Stack<Node> stack = new Stack<>();
        Node curr = head;
        while (curr != null) {
            if (curr.child != null) {
                if (curr.next != null) {
                    stack.push(curr.next);
                }
                curr.next = curr.child;
                curr.next.prev = curr;
                curr.child = null;
            } else if (curr.next == null && !stack.isEmpty()) {
                curr.next = stack.pop();
                curr.next.prev = curr;
            }
            curr = curr.next;
        }
        return head;
    }

    // 深度优先搜索
    public Node flatten2(Node head) {
        dfs(head);
        return head;
    }

    private Node dfs(Node node) {
        Node cur = node;
        // 记录链表的最后一个节点
        Node last = null;
        while (cur != null) {
            Node next = cur.next;
            // 如果有子节点，那么首先处理子节点
            if (cur.child != null) {
                Node childLast = dfs(cur.child);
                next = cur.next;
                // 将node与child相连
                cur.next = cur.child;
                cur.child.prev = cur;
                //如果next不为空，就将last与next相连
                if (next != null) {
                    childLast.next = next;
                    next.prev = childLast;
                }
                //将child置为空
                cur.child = null;
                last = childLast;
            } else {
                last = cur;
            }
            cur = next;
        }
        return last;
    }
}
