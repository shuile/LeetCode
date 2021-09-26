package cn.shui.learning_plan.offer.second;

import cn.shui.learning_plan.offer.model.ListNode;

/**
 * @author shui.
 * @date 2021/9/26.
 * @time 09:27.
 * 反转链表
 */
public class Offer24 {
    public ListNode reverseList(ListNode head) {
        ListNode ans = new ListNode(0);
        while (head != null) {
            ListNode temp = head.next;
            head.next = ans.next;
            ans.next = head;
            head = temp;
        }
        return ans.next;
    }

    // 递归
    public ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseList2(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}
