package cn.shui.learning_plan.beike.day_3;

import cn.shui.learning_plan.beike.model.ListNode;

/**
 * @author shui.
 * @date 2022/2/10.
 * @time 09:38.
 * 删除排序链表中的重复元素
 */
public class Beike_82 {
    public ListNode deleteDuplicate(ListNode head) {
        ListNode ans = new ListNode(0, head);
        ListNode p = ans;
        while (p != null) {
            ListNode q = p.next;
            if (q != null && q.next != null && q.val == q.next.val) {
                while (q.next != null && q.next.val == q.val) {
                    q.next = q.next.next;
                }
                p.next = q.next;
            } else {
                p = q;
            }
        }
        return ans.next;
    }

    // 一次遍历
    public ListNode deleteDuplicate2(ListNode head) {
        if (head == null) {
            return null;
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
}
