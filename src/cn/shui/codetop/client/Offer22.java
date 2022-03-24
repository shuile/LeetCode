package cn.shui.codetop.client;

import cn.shui.codetop.client.model.ListNode;

/**
 * Created by chenyiting on 2022/3/24
 */
public class Offer22 {
    public ListNode getKthFromEnd(ListNode head, int k) {
        if (head == null || k == 0) {
            return null;
        }
        int len = 0;
        ListNode p = head;
        while (p != null) {
            p = p.next;
            len++;
        }
        if (len <= k) {
            return head;
        }
        p = head;
        for (int i = 0; i < len - k; i++) {
            p = p.next;
        }
        return p;
    }

    public ListNode getKthFromEnd2(ListNode head, int k) {
        if (head == null || k == 0) {
            return null;
        }
        ListNode slow = head, fast = head;
        for (int i = 0; i < k && fast != null; i++) {
            fast = fast.next;
        }
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
