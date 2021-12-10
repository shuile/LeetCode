package cn.shui.learning_plan.offerII;

import cn.shui.learning_plan.offerII.model.ListNode;

/**
 * @author shui.
 * @date 2021/12/10.
 * @time 16:47.
 * 删除链表的倒数第n个结点
 */
public class Offer021 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        ListNode newHead = new ListNode(0, head);
        ListNode slow = newHead, fast = newHead;
        for (int i = 0; i < n && fast != null; i++) {
            fast = fast.next;
        }
        if (fast == null) {
            return head;
        }
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return newHead.next;
    }
}
