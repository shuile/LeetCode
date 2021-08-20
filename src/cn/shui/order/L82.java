package cn.shui.order;

/**
 * @author shui.
 * @date 2021/8/20.
 * @time 13:54.
 * 删除排序链表中的重复元素II
 */
public class L82 {
    public ListNode deleteDuplicates1(ListNode head) {
        ListNode ans = new ListNode();
        ListNode p = head, q = ans;
        ListNode pre = p;
        while (p != null) {
            if (p.next != null && p.val == p.next.val) {
                p = p.next;
                continue;
            }
            if (pre == p) {
                q.next = new ListNode(p.val);
                q = q.next;
            }
            p = p.next;
            pre = p;
        }
        return ans.next;
    }

    // 一次遍历
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
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
        ListNode() {}
        ListNode(int val) {
            this.val = val;
        }
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
