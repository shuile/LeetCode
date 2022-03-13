package cn.shui.codetop.client;

import cn.shui.codetop.client.model.ListNode;

/**
 * 反转链表
 */
public class L206 {
    public ListNode reverseList(ListNode head) {
        ListNode newHead = new ListNode(0);
        while (head != null) {
            ListNode node = head;
            head = head.next;
            node.next = newHead.next;
            newHead.next = node;
        }
        return newHead.next;
    }

    public ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseList2(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}
