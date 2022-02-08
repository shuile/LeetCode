package cn.shui.learning_plan.beike.day_1;

import cn.shui.learning_plan.beike.model.ListNode;

/**
 * @author shui.
 * @date 2022/2/8.
 * @time 09:57.
 * 两数相加
 */
public class Beike_2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode newHead = new ListNode();
        ListNode p = l1, q = l2, r = newHead;
        int carry = 0;
        while (p != null && q != null) {
            int sum = p.val + q.val + carry;
            r.next = new ListNode(sum % 10);
            carry = sum / 10;
            r = r.next;
            q = q.next;
            p = p.next;
        }
        while (p != null) {
            int sum = p.val + carry;
            r.next = new ListNode(sum % 10);
            carry = sum / 10;
            r = r.next;
            p = p.next;
        }
        while (q != null) {
            int sum = q.val + carry;
            r.next = new ListNode(sum % 10);
            carry = sum / 10;
            r = r.next;
            q = q.next;
        }
        if (carry == 1) {
            r.next = new ListNode(1);
        }
        return newHead.next;
    }
}
