package cn.shui.codetop.client;

import cn.shui.codetop.client.model.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by chenyiting on 2022/4/8
 * 两个链表的第一个公共节点
 */
public class Offer52 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode pA = headA, pB = headB;
        int lenA = 0, lenB = 0;
        while (pA != null) {
            lenA++;
            pA = pA.next;
        }
        while (pB != null) {
            lenB++;
            pB = pB.next;
        }
        pA = headA;
        pB = headB;
        int diff = lenA - lenB;
        if (diff > 0) {
            while (diff > 0) {
                pA = pA.next;
                diff--;
            }
        } else if (diff < 0) {
            while (diff < 0) {
                pB = pB.next;
                diff++;
            }
        }
        while (pA != null && pB != null) {
            if (pA == pB) {
                return pA;
            }
            pA = pA.next;
            pB = pB.next;
        }
        return null;
    }

    // 哈希集合
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        Set<ListNode> set = new HashSet<>();
        while (headA != null) {
            set.add(headA);
            headA = headA.next;
        }
        while (headB != null) {
            if (set.contains(headB)) {
                return headB;
            }
            headB = headB.next;
        }
        return null;
    }

    public ListNode getIntersectionNode3(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode p = headA, q = headB;
        while (p != q) {
            p = p == null ? headA : p.next;
            q = q == null ? headB : q.next;
        }
        return p;
    }
}
