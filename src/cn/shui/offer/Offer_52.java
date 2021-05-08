package cn.shui.offer;

import cn.shui.offer.domain.ListNode;

public class Offer_52 {
    public static void main(String[] args) {

    }

    private ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        int lenA = 0, lenB = 0;
        ListNode p = headA, q = headB;
        while (p != null) {
            lenA++;
            p = p.next;
        }
        while (q != null) {
            lenB++;
            q = q.next;
        }
        int len = Math.min(lenA, lenB);
        p = headA;
        q = headB;
        if (lenA > lenB) {
            int diff = lenA  - lenB;
            while (diff > 0) {
                diff--;
                p = p.next;
            }
        }
        if (lenA < lenB) {
            int diff = lenB - lenA;
            while (diff > 0) {
                diff--;
                q = q.next;
            }
        }
        while (len > 0) {
            if (p == q) {
                return p;
            }
            p = p.next;
            q = q.next;
            len--;
        }
        return null;
    }

    private ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        ListNode A = headA, B = headB;
        while (A != B) {
            A = A != null ? A.next : headB;
            B = B != null ? B.next : headA;
        }
        return A;
    }
}
