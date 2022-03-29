package cn.shui.codetop.client;

import cn.shui.codetop.client.model.ListNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by chenyiting on 2022/3/28
 * 重排链表
 */
public class L143 {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode p = head;
        for (int i = 2; i <= 5; i++) {
            p.next = new ListNode(i);
            p = p.next;
        }
        L143 test = new L143();
        test.reorderList2(head);
    }

    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        int len = 0;
        ListNode p = head;
        while (p != null) {
            p = p.next;
            len++;
        }
        int preLen = len % 2 == 0 ? len / 2 : len / 2 + 1;
        p = head;
        for (int i = 0; i < preLen - 1; i++) {
            p = p.next;
        }
        ListNode next = p.next;
        p.next = null;
        Deque<ListNode> deque = new LinkedList<>();
        while (next != null) {
            deque.push(next);
            next = next.next;
        }
        p = head;
        while (!deque.isEmpty()) {
            next = deque.pop();
            next.next = p.next;
            p.next = next;
            p = next.next;
        }
    }

    private void reorderList2(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        ListNode mid = middleList(head);
        ListNode halfList = mid.next;
        mid.next = null;
        halfList = reverseList(halfList);
        mergeList(head, halfList);
    }

    private ListNode middleList(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private ListNode reverseList(ListNode head) {
        ListNode newHead = new ListNode(0);
        ListNode curr = head;
        ListNode next;
        while (curr != null) {
            next = curr.next;
            curr.next = newHead.next;
            newHead.next = curr;
            curr = next;
        }
        return newHead.next;
    }

    private void mergeList(ListNode l1, ListNode l2) {
        ListNode next1, next2;
        while (l1 != null && l2 != null) {
            next1 = l1.next;
            l1.next = l2;
            next2 = l2.next;
            l2.next = next1;
            l1 = next1;
            l2 = next2;
        }
    }
}
