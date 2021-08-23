package cn.shui.learning_plan.datastruct.eighth;

/**
 * @author shui.
 * @date 2021/8/23.
 * @time 11:21.
 * 删除排序链表中的重复元素
 */
public class L83 {
    public ListNode deleteDuplicates1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode first = head, second = head.next;
        while (second != null) {
            if (first.val == second.val) {
                first.next = second.next;
            } else {
                first = second;
            }
            second = second.next;
        }
        return head;
    }

    // 一次遍历
    public ListNode deleteDuplicates2(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode cur = head;
        while (cur.next != null) {
            if (cur.val == cur.next.val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return head;
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
