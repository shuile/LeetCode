package cn.shui.order;

import cn.shui.order.base.Node1;

/**
 * @author shui.
 * @date 2021/11/13.
 * @time 15:21.
 * 复制带随机指针的链表
 */
public class L138 {

    public static void main(String[] args) {
        Node1 node1 = new Node1(7);
        Node1 node2 = new Node1(13);
        Node1 node3 = new Node1(11);
        Node1 node4 = new Node1(10);
        Node1 node5 = new Node1(1);
        node1.next = node2;
        node2.next = node3;
        node2.random = node1;
        node3.next = node4;
        node3.random = node5;
        node4.next = node5;
        node4.random = node3;
        node5.random = node1;
        Node1 head = node1;
        L138 test = new L138();
        test.copyRandomList(head);
    }

    public Node1 copyRandomList(Node1 head) {
        if (head == null) {
            return null;
        }
        Node1 p = head;
        while (p != null) {
            Node1 Node1 = new Node1(p.val);
            Node1 temp = p.next;
            p.next = Node1;
            Node1.next = temp;
            p = temp;
        }
        Node1 q = head.next;
        p = head;
        while (p != null) {
            if (p.random != null) {
                q.random = p.random.next;
            }
            p = p.next.next;
            if (q.next != null) {
                q = q.next.next;
            }
        }
        Node1 newHead = head.next;
        p = head;
        q = newHead;
        while (p != null) {
            p.next = p.next.next;
            p = p.next;
            if (q.next != null) {
                q.next = q.next.next;
                q = q.next;
            }
        }
        return newHead;
    }
}
