package cn.shui.offer;

import cn.shui.offer.domain.ListNode;

import java.util.Deque;
import java.util.LinkedList;

public class Offer_24 {
    public static void main(String[] args) {

    }

    private ListNode reverseLise(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        Deque<ListNode> queue = new LinkedList<>();
        ListNode p = head;
        while (p != null) {
            queue.push(p);
            p = p.next;
        }
        ListNode q = queue.pop();
        ListNode r = q;
        while (!queue.isEmpty()) {
            ListNode node = queue.pop();
            node.next = r.next;
            r.next = node;
            r = r.next;
        }
        return q;
    }

    private ListNode reverseList2(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
