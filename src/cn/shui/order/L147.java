package cn.shui.order;

import cn.shui.order.base.ListNode;

/**
 * @author shui.
 * @date 2021/11/16.
 * @time 14:25.
 * 对链表进行插入排序
 */
public class L147 {
    public ListNode insertSortList(ListNode head) {
        ListNode ans = new ListNode();
        ListNode p = head, q;
        while (p != null) {
            q = ans;
            while (q.next != null && q.next.val < p.val) {
                q = q.next;
            }
            ListNode temp = p.next;
            p.next = q.next;
            q.next = p;
            p = temp;
        }
        return ans.next;
    }

    // 从前往后找插入点
    public ListNode insertSortList2(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode lastSorted = head, curr = head.next;
        while (curr != null) {
            if (lastSorted.val <= curr.val) {
                lastSorted = lastSorted.next;
            } else {
                ListNode prev = dummyHead;
                while (prev.next.val <= curr.val) {
                    prev = prev.next;
                }
                lastSorted.next = curr.next;
                curr.next = prev.next;
                prev.next = curr;
            }
            curr = lastSorted.next;
        }
        return dummyHead.next;
    }
}
