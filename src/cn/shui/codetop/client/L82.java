package cn.shui.codetop.client;

import cn.shui.codetop.client.model.ListNode;

/**
 * Created by chenyiting on 2022/3/28
 * 删除排序链表中的重复元素II
 */
public class L82 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode newHead = new ListNode(0, head);
        ListNode pre = newHead;
        ListNode curr, next;
        while (pre != null && pre.next != null) {
            curr = pre.next;
            next = curr.next;
            if (next == null) {
                break;
            }
            if (curr.val == next.val) {
                int val = curr.val;
                while (curr != null && curr.val == val) {
                    next = curr.next;
                    curr.next = null;
                    pre.next = next;
                    curr = next;
                }
            } else {
                pre = pre.next;
            }
        }
        return newHead.next;
    }
}
