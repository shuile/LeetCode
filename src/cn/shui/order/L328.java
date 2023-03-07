package cn.shui.order;

import cn.shui.order.base.ListNode;

/**
 * Created by chenyiting on 2023/3/7
 * 奇偶链表
 */
public class L328 {
    public ListNode oddEvenList(ListNode head) {
        ListNode first = new ListNode();
        ListNode second = new ListNode();
        ListNode h = head, p = first, q = second;
        while (h != null) {
            p.next = h;
            h = h.next;
            p = p.next;
            p.next = null;
            if (h != null) {
                q.next = h;
                h = h.next;
                q = q.next;
                q.next = null;
            }
        }
        p.next = second.next;
        return first.next;
    }

    /**
     * 不带表头的链表
     */
    public ListNode oddEvenList2(ListNode head) {
        ListNode evenHead = head.next;
        ListNode odd = head, even = evenHead;
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }
}
