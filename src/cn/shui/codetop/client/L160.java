package cn.shui.codetop.client;

import cn.shui.codetop.client.model.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by chenyiting on 2022/3/16
 */
public class L160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null) {
            return headB;
        }
        if (headB == null) {
            return headA;
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
        p = headA;
        q = headB;
        int diff = Math.abs(lenA - lenB);
        while (diff > 0) {
            if (lenA > lenB) {
                p = p.next;
            } else {
                q = q.next;
            }
            diff--;
        }
        while (p != null && q != null) {
            if (p == q) {
                return p;
            }
            p = p.next;
            q = q.next;
        }
        return null;
    }

    // 哈希集合
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        Set<ListNode> visited = new HashSet<>();
        ListNode temp = headA;
        while (temp != null) {
            visited.add(temp);
            temp = temp.next;
        }
        temp = headB;
        while (temp != null) {
            if (visited.contains(temp)) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    // 双指针
    public ListNode getIntersectionNode3(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode pA = headA, pB = headB;
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }
}
