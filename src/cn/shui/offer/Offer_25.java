package cn.shui.offer;

import cn.shui.offer.domain.ListNode;

public class Offer_25 {
    public static void main(String[] args) {

    }

    private ListNode mergeTwoList(ListNode l1, ListNode l2) {
        ListNode ans = new ListNode(0);
        ListNode p = l1, q = l2, r = ans;;
        while (p != null || q != null) {
            int val1 = p != null ? p.val : Integer.MAX_VALUE;
            int val2 = q != null ? q.val : Integer.MAX_VALUE;
            if (val1 > val2) {
                r.next = q;
                r = r.next;
                q = q.next;
            } else {
                r.next = p;
                r = r.next;
                p = p.next;
            }
        }
        return ans.next;
    }
}
