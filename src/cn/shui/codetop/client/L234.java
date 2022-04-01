package cn.shui.codetop.client;

import cn.shui.codetop.client.model.ListNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by chenyiting on 2022/4/1
 * 回文链表
 */
public class L234 {
    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }
        Deque<ListNode> deque = new LinkedList<>();
        while (head != null) {
            deque.offer(head);
            head = head.next;
        }
        ListNode p, q;
        while (deque.size() > 1) {
            p = deque.pollFirst();
            q = deque.pollLast();
            if (p.val != q.val) {
                return false;
            }
        }
        return true;
    }

    // 快慢指针
    public boolean isPalindrome2(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode halfList = slow.next;
        slow.next = null;
        halfList = reverseList(halfList);
        ListNode p = head, q = halfList;
        boolean result = true;
        while (p != null && q != null) {
            if (p.val != q.val) {
                result = false;
                break;
            }
            p = p.next;
            q = q.next;
        }
        slow.next = reverseList(halfList);
        return result;
    }

    private ListNode reverseList(ListNode head) {
        ListNode newHead = new ListNode(0);
        ListNode next;
        while (head != null) {
            next = head.next;
            head.next = newHead.next;
            newHead.next = head;
            head = next;
        }
        return newHead.next;
    }
}
