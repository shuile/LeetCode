package cn.shui.codetop.client;

import cn.shui.codetop.client.model.ListNode;

/**
 * Created by chenyiting on 2022/4/1
 * 删除排序链表中的重复元素
 */
public class L83 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode p = head, next;
        while (p != null && p.next != null) {
            if (p.val == p.next.val) {
                next = p.next;
                p.next = next.next;
                next = null;
            } else {
                p = p.next;
            }
        }
        return head;
    }
}
