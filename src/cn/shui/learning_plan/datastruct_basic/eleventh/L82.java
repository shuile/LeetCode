package cn.shui.learning_plan.datastruct_basic.eleventh;

/**
 * @author shui.
 * @date 2021/9/13.
 * @time 19:39.
 * 删除排序链表中的重复元素II
 */
public class L82 {

    public ListNode deleteDuplicates1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode ans = new ListNode(0, head);
        ListNode start = ans.next, end = ans.next, pre = ans;
        while (end != null) {
            if (end.val != start.val) {
                if (start.next == end) {
                    pre.next = start;
                    pre = pre.next;
                }
                start = end;
            }
            end = end.next;
        }
        pre.next = (start != null ? start.next : null) == null ? start : null;
        return ans.next;
    }

    // 一次遍历
    public ListNode deleteDuplicates2(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode dummy = new ListNode(0, head);
        ListNode cur = dummy;
        while (cur.next != null && cur.next.next != null) {
            if (cur.next.val == cur.next.next.val) {
                int x = cur.next.val;
                while (cur.next != null && cur.next.val == x) {
                    cur.next = cur.next.next;
                }
            } else {
                cur = cur.next;
            }
        }
        return dummy.next;
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
