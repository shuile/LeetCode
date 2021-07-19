package cn.shui.learning_plan.algorithms.fifth_day;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author shui.
 * @date 2021/7/18.
 * @time 22:56.
 * 删除链表的倒数第N个节点
 */
public class L19 {
    // 双指针
    public ListNode removeNthFromEnd1(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        ListNode ans = new ListNode(0, head);
        ListNode fast = ans;
        while (n > 0 && fast != null) {
            n--;
            fast = fast.next;
        }
        if (fast != null) {
            ListNode slow = ans;
            while (fast.next != null) {
                slow = slow.next;
                fast = fast.next;
            }
            slow.next = slow.next.next;
        }
        return ans.next;
    }

    public ListNode removeNthFromEnd2(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        ListNode ans = new ListNode(0, head);
        int length = getLength(head);
        ListNode p = ans;
        for (int i = 1; i < length - n + 1; i++) {
            p = p.next;
        }
        p.next = p.next.next;
        return ans.next;
    }

    private int getLength(ListNode head) {
        if (head == null) {
            return 0;
        }
        int len = 0;
        while (head != null) {
            len++;
            head = head.next;
        }
        return len;
    }

    private ListNode removeNthFromEnd3(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        ListNode ans = new ListNode(0, head);
        Deque<ListNode> stack = new LinkedList<>();
        ListNode p = ans;
        while (p != null) {
            stack.push(p);
            p = p.next;
        }
        for (int i = 0; i < n; i++) {
            stack.pop();
        }
        ListNode pre = stack.peek();
        pre.next = pre.next.next;
        return ans.next;
    }

    public ListNode removeNthFromEnd4(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        ListNode ans = new ListNode(0, head);
        ListNode fast = head;
        ListNode slow = ans;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return ans.next;
    }
}
