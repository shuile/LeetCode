package cn.shui.learning_plan.datastruct.seventh;

/**
 * @author shui.
 * @date 2021/8/22.
 * @time 15:37.
 * 环形链表
 */
public class L141 {
    public boolean hasCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
