package cn.shui.codetop.client;

import cn.shui.codetop.client.model.ListNode;

/**
 * Created by chenyiting on 2022/3/23
 */
public class L2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode newHead = new ListNode(0);
        ListNode p = newHead;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int a = l1 == null ? 0 : l1.val;
            int b = l2 == null ? 0 : l2.val;
            int sum = a + b + carry;
            carry = sum / 10;
            p.next = new ListNode(sum % 10);
            p = p.next;
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }
        if (carry == 1) {
            p.next = new ListNode(carry);
        }
        return newHead.next;
    }
}
