package cn.shui.codetop.client;

import cn.shui.codetop.client.model.ListNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by chenyiting on 2022/3/22
 * 删除链表的倒数第N个节点
 */
public class L19 {

    //  计算链表长度
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || n == 0) {
            return head;
        }
        int len = 0;
        ListNode p = head;
        while (p != null) {
            len++;
            p = p.next;
        }
        if (len < n) {
            return head;
        }
        ListNode newHead = new ListNode(0, head);
        p = newHead;
        for (int i = 0; i < len - n; i++) {
            p = p.next;
        }
        ListNode next = p.next;
        p.next = next.next;
        next = null;
        return newHead.next;
    }

    // 栈
    public ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode newHead = new ListNode(0, head);
        Deque<ListNode> deque = new LinkedList<>();
        ListNode p = newHead;
        while (p != null) {
            deque.push(p);
            p = p.next;
        }
        for (int i = 0; i < n; i++) {
            deque.pop();
        }
        ListNode pre = deque.peek();
        if (pre != null) {
            pre.next = pre.next.next;
        }
        return newHead.next;
    }

    // 双指针
    public ListNode removeNthFromEnd3(ListNode head, int n) {
        ListNode newHead = new ListNode(0, head);
        ListNode first = head;
        ListNode second = newHead;
        for (int i = 0; i < n; i++) {
            first = first.next;
        }
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return newHead.next;
    }
}
