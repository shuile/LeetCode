package cn.shui.learning_plan.algorithms.tenth_day;

/**
 * @author shui.
 * @date 2021/7/23.
 * @time 09:57.
 * 反转链表
 */
public class L206 {
    // 迭代
    public ListNode reverseList1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode root = new ListNode();
        while (head != null) {
            ListNode temp = head.next;
            head.next = root.next;
            root.next = head;
            head = temp;
        }
        return root.next;
    }

    // 递归
    public ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode sub = head.next;
        head.next = null;
        ListNode ans = reverseList2(sub);
        sub.next = head;
        return ans;
    }

    // 迭代优化
    public ListNode reverseList3(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    // 递归优化
    public ListNode reverseList4(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseList4(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}
