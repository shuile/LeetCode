package cn.shui.codetop.client;

import cn.shui.codetop.client.model.ListNode;

/**
 * Created by chenyiting on 2022/3/26
 */
public class L92 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
            ListNode newHead = new ListNode(0, head);
            ListNode pre = newHead, end = head, start;
            int reverseLen = right - left + 1;
        for (int i = 0; i < reverseLen && end != null; i++) {
            end = end.next;
        }
        for (int i = 0; i < left - 1 && pre != null; i++) {
            pre = pre.next;
            end = end == null ? null : end.next;
        }
        start = pre == null ? null : pre.next;
        if (start == null) {
            return head;
        }
        pre.next = end;
        while (start != end) {
            ListNode next = start.next;
            start.next = pre.next;
            pre.next = start;
            start = next;
        }
        return newHead.next;
    }

    // 简化内部方法
    public ListNode reverseBetween2(ListNode head, int left, int right) {
        ListNode newHead = new ListNode(0, head);
        ListNode pre = newHead;
        for (int i = 0; i < left - 1 && pre != null; i++) {
            pre = pre.next;
        }
        if (pre == null) {
            return head;
        }
        ListNode cur = pre.next;
        ListNode next;
        for (int i = 0; i < right - left && cur != null; i++) {
            next = cur.next;
            cur.next = next.next;
            next.next = pre.next;
            pre.next = next;
        }
        return newHead.next;
    }
}
