package cn.shui.learning_plan.offerII;

import cn.shui.learning_plan.offerII.model.ListNode;

/**
 * @author shui.
 * @date 2021/12/29.
 * @time 11:12.
 * 链表排序
 */
public class Offer077 {
    // 超时
    public ListNode sortList(ListNode head) {
        ListNode ans = new ListNode(0);
        ListNode p = head, q;
        while (p != null) {
            ListNode node = new ListNode(p.val);
            q = ans;
            while (q.next != null) {
                if (q.next.val >= p.val) {
                    break;
                }
                q = q.next;
            }
            node.next = q.next;
            q.next = node;
            p = p.next;
        }
        return ans.next;
    }

    // 归并排序
    public ListNode sortList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode head1 = head;
        ListNode head2 = split(head);

        head1 = sortList2(head1);
        head2 = sortList2(head2);
        return merge(head1, head2);
    }

    private ListNode split(ListNode head) {
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode second = slow.next;
        slow.next = null;
        return second;
    }

    private ListNode merge(ListNode head1, ListNode head2) {
        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        while (head1 != null && head2 != null) {
            if (head1.val < head2.val) {
                cur.next = head1;
                head1 = head1.next;
            } else {
                cur.next = head2;
                head2 = head2.next;
            }
            cur = cur.next;
        }
        cur.next = head1 == null ? head2 : head1;
        return dummy.next;
    }
}
