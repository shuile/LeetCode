package cn.shui.learning_plan.offer.eleventh;

import cn.shui.learning_plan.offer.model.ListNode;

/**
 * @author shui.
 * @date 2021/10/13.
 * @time 13:15.
 */
public class Offer18 {
    public ListNode deleteNode(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        if (head.val == val) {
            return head.next;
        }
        ListNode pre = head, cur = head.next;
        while (cur != null) {
            if (cur.val == val) {
                cur = cur.next;
                pre.next.next = null;
                pre.next = cur;
                break;
            }
            cur = cur.next;
            pre = pre.next;
        }
        return head;
    }

    // 优化
    public ListNode deleteNode2(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        if (head.val == val) {
            return head.next;
        }
        ListNode pre = head, cur = head.next;
        while (cur != null && cur.val != val) {
            cur = cur.next;
            pre = pre.next;
        }
        if (cur != null) {
            pre.next = cur.next;
        }
        return head;
    }
}
