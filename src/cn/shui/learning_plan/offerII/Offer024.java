package cn.shui.learning_plan.offerII;

import cn.shui.learning_plan.offerII.model.ListNode;

/**
 * @author shui.
 * @date 2021/12/10.
 * @time 17:44.
 * 反转链表
 */
public class Offer024 {
    public ListNode reverseList(ListNode head) {
        ListNode newHead = new ListNode(0);
        ListNode p = head;
        while (p != null) {
            ListNode temp = p.next;
            p.next = newHead.next;
            newHead.next = p;
            p = temp;
        }
        return newHead.next;
    }

    // 递归
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
