package cn.shui.codetop.client;

import cn.shui.codetop.client.model.ListNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by chenyiting on 2022/3/31
 * 合并K个升序链表
 */
public class L23 {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        Queue<ListNode> queue = new LinkedList<>();
        for (ListNode list : lists) {
            queue.offer(list);
        }
        ListNode l1, l2;
        while (queue.size() > 1) {
            l1 = queue.poll();
            l2 = queue.poll();
            if (l1 == null && l2 == null) {
                continue;
            }
            if (l1 == null) {
                queue.offer(l2);
                continue;
            }
            if (l2 == null) {
                queue.offer(l1);
                continue;
            }
            queue.offer(merge(l1, l2));
        }
        return queue.poll();
    }

    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode newHead = new ListNode(0);
        ListNode pre = newHead;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                pre.next = l1;
                l1 = l1.next;
            } else {
                pre.next = l2;
                l2 = l2.next;
            }
            pre = pre.next;
        }
        pre.next = l1 == null ? l2 : l1;
        return newHead.next;
    }
}
