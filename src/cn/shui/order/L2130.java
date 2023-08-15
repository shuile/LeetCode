package cn.shui.order;

import cn.shui.order.base.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenyiting on 2023/8/16
 * 链表最大孪生和
 */
public class L2130 {
    public int pairSum(ListNode head) {
        if (head == null || head.next == null) {
            return -1;
        }
        List<ListNode> list = new ArrayList<>();
        ListNode p = head;
        while (p != null) {
            list.add(p);
            p = p.next;
        }
        int ans = Integer.MIN_VALUE;
        int size = list.size();
        int half = size / 2 - 1;
        for (int i = 0; i <= half; i++) {
            ans = Math.max(ans, list.get(i).val + list.get(size - 1 - i).val);
        }
        return ans;
    }

    /**
     * 快慢指针 + 反转链表
     */
    public int pairSum2(ListNode head) {
        if (head == null || head.next == null) {
            return - 1;
        }
        ListNode slow = head, fast = head.next;
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // 反装链表
        ListNode last = slow.next;
        while (last.next != null) {
            ListNode cur = last.next;
            last.next = cur.next;
            cur.next = slow.next;
            slow.next = cur;
        }
        int ans = 0;
        ListNode p = head, q = slow.next;
        while (q != null) {
            ans = Math.max(ans, p.val + q.val);
            p = p.next;
            q = q.next;
        }
        return ans;
    }
}
