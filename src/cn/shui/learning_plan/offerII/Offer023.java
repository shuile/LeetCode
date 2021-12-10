package cn.shui.learning_plan.offerII;

import cn.shui.learning_plan.offerII.model.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author shui.
 * @date 2021/12/10.
 * @time 17:27.
 * 两个链表的第一个重合节点
 */
public class Offer023 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = 0, lenB = 0;
        ListNode pA = headA, pB = headB;
        while (pA != null) {
            pA = pA.next;
            lenA++;
        }
        while (pB != null) {
            pB = pB.next;
            lenB++;
        }
        pA = headA;
        pB = headB;
        if (lenA > lenB) {
            for (int i = 0; i < lenA - lenB; i++) {
                pA = pA.next;
            }
        } else if (lenA < lenB) {
            for (int i = 0; i < lenB - lenA; i++) {
                pB = pB.next;
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

    //双指针变体
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
