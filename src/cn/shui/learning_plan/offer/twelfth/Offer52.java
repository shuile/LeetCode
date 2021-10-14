package cn.shui.learning_plan.offer.twelfth;

import cn.shui.learning_plan.offer.model.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author shui.
 * @date 2021/10/14.
 * @time 11:13.
 */
public class Offer52 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        int countA = 0, countB = 0;
        ListNode p = headA, q = headB;
        while (p != null) {
            countA++;
            p = p.next;
        }
        while (q != null) {
            countB++;
            q = q.next;
        }
        p = headA;
        q = headB;
        if (countA > countB) {
            for (int i = countA - countB; i > 0; i--) {
                p = p.next;
            }
        } else {
            for (int i = countB - countA; i > 0; i--) {
                q = q.next;
            }
        }
        while (p != null) {
            if (p == q) {
                break;
            }
            p = p.next;
            q = q.next;
        }
        return p;
    }

    // 哈希集合
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        Set<ListNode> visited = new HashSet<>();
        ListNode tmp = headA;
        while (tmp != null) {
            visited.add(tmp);
            tmp = tmp.next;
        }
        tmp = headB;
        while (tmp != null) {
            if (visited.contains(tmp)) {
                return tmp;
            }
            tmp = tmp.next;
        }
        return null;
    }

    // 双指针
    public ListNode getIntersectionNode3(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode p = headA, q = headB;
        while (p != q) {
            p = p == null ? headB : p.next;
            q = q == null ? headA : q.next;
        }
        return p;
    }
}
