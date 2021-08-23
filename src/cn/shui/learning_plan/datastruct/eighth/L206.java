package cn.shui.learning_plan.datastruct.eighth;

/**
 * @author shui.
 * @date 2021/8/23.
 * @time 10:43.
 * 反转链表
 */
public class L206 {
    public ListNode reverseList1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode next = reverseList1(head.next);
        head.next.next = head;
        head.next = null;
        return next;
    }

    // 迭代
    public ListNode reverseList2(ListNode head) {
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

    private static class ListNode {
        int val;
        ListNode next;

        ListNode() {

        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
