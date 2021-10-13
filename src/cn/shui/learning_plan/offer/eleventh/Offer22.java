package cn.shui.learning_plan.offer.eleventh;

import cn.shui.learning_plan.offer.model.ListNode;

/**
 * @author shui.
 * @date 2021/10/13.
 * @time 13:33.
 */
public class Offer22 {
    public ListNode getKthFromEnd(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        ListNode pre = head, end = head;
        while (k > 0 && end != null) {
            end = end.next;
            k--;
        }
        while (end != null) {
            end = end.next;
            pre = pre.next;
        }
        return pre;
    }
}
