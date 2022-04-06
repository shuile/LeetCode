package cn.shui.codetop.client;

import cn.shui.codetop.client.model.ListNode;

/**
 * Created by chenyiting on 2022/4/7
 * 两两交换链表中的节点
 */
public class L24 {
    public ListNode swapPairs(ListNode head) {
        ListNode newHead = new ListNode(0, head);
        ListNode pre = newHead, cur, next;
        while (pre.next != null && pre.next.next != null) {
            cur = pre.next;
            next = pre.next.next;
            cur.next = next.next;
            next.next = cur;
            pre.next = next;
            pre = cur;
        }
        return newHead.next;
    }

    // 递归
    public ListNode swapPairs2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = head.next;
        head.next = swapPairs(newHead.next);
        newHead.next = head;
        return newHead;
    }
}
