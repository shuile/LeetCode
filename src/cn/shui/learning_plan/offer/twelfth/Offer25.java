package cn.shui.learning_plan.offer.twelfth;

import cn.shui.learning_plan.offer.model.ListNode;

/**
 * @author shui.
 * @date 2021/10/14.
 * @time 10:44.
 */
public class Offer25 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode ans = new ListNode(0);
        ListNode p = l1, q = l2, r = ans;
        while (p != null && q != null) {
            if (p.val <= q.val) {
                r.next = p;
                p = p.next;
            } else {
                r.next = q;
                q = q.next;
            }
            r = r.next;
        }
//        if (p != null) {
//            r.next = p;
//        }
//        if (q != null) {
//            r.next = q;
//        }
        r.next = p == null ? q : p;
        return ans.next;
    }
}
