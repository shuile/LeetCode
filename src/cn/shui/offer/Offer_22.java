package cn.shui.offer;

import cn.shui.offer.domain.ListNode;

public class Offer_22 {
    public static void main(String[] args) {

    }

    private ListNode getKthFromEnd(ListNode head, int k) {
        ListNode p = head;
        ListNode q = head;
        while (p != null && k != 0) {
            p = p.next;
            k--;
        }
        if (k > 0) {
            return null;
        }
        while (p != null) {
            p = p.next;
            q = q.next;
        }
        return q;
    }
}
