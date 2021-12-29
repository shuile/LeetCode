package cn.shui.learning_plan.offerII;

import cn.shui.learning_plan.offerII.model.ListNode;

/**
 * @author shui.
 * @date 2021/12/29.
 * @time 11:42.
 * 合并排序链表
 */
public class Offer078 {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length < 1) {
            return null;
        }
        return mergeList(lists, 0, lists.length - 1);
    }

    private ListNode mergeList(ListNode[] lists, int start, int end) {
        if (start == end) {
            return lists[start];
        }
        ListNode head1, head2;
        if (end - start > 1) {
            int mid = start + (end - start) / 2;
            head1 = mergeList(lists, start, mid);
            head2 = mergeList(lists, mid + 1, end);
        } else {
            head1 = lists[start];
            head2 = lists[end];
        }
        return merge(head1, head2);
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
