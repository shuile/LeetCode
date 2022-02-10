package cn.shui.learning_plan.beike.day_3;

import cn.shui.learning_plan.beike.model.ListNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author shui.
 * @date 2022/2/10.
 * @time 09:23.
 * 删除链表的倒数第N个结点
 */
public class Beike_19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        ListNode p = head;
        while (n > 0 && p != null) {
            n--;
            p = p.next;
        }
        if (p == null) {
            return n == 0 ? head.next : head;
        }
        ListNode newHead = new ListNode(0, head);
        ListNode q = newHead;
        while (p != null) {
            p = p.next;
            q = q.next;
        }
        q.next = q.next.next;
        return newHead.next;
    }

    // 计算链表长度
    public ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        int length = getLength(head);
        ListNode cur = dummy;
        for (int i = 1; i < length - n + 1; i++) {
            cur = cur.next;
        }
        cur.next = cur.next.next;
        return dummy.next;
    }

    private int getLength(ListNode head) {
        int length = 0;
        while (head != null) {
            length++;
            head = head.next;
        }
        return length;
    }

    // 栈
    public ListNode removeNthFromEnd3(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        Deque<ListNode> stack = new LinkedList<>();
        ListNode cur = dummy;
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }
        for (int i = 0; i < n; i++) {
            stack.pop();
        }
        ListNode prev = stack.peek();
        prev.next = prev.next.next;
        return dummy.next;
    }

    // 双指针
    public ListNode removeNthFromEnd4(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode first = head;
        ListNode second = dummy;
        for (int i = 0; i < n; i++) {
            first = first.next;
        }
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummy.next;
    }
}
