package cn.shui.learning_plan.offerII;

import cn.shui.learning_plan.offerII.model.ListNode;

import java.util.Stack;

/**
 * @author shui.
 * @date 2021/12/10.
 * @time 17:51.
 * 链表中的两数相加
 */
public class Offer025 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<ListNode> s1 = new Stack<>();
        Stack<ListNode> s2 = new Stack<>();
        ListNode p1 = l1, p2 = l2;
        while (p1 != null) {
            s1.push(p1);
            p1 = p1.next;
        }
        while (p2 != null) {
            s2.push(p2);
            p2 = p2.next;
        }
        ListNode ans = new ListNode(0);
        int carry = 0;
        while (!s1.isEmpty() || !s2.isEmpty()) {
            int a = s1.isEmpty() ? 0 : s1.pop().val;
            int b = s2.isEmpty() ? 0 : s2.pop().val;
            int sum = a + b + carry;
            carry = sum / 10;
            ListNode node = new ListNode(sum % 10);
            node.next = ans.next;
            ans.next = node;
        }
        if (carry == 1) {
            ListNode node = new ListNode(1);
            node.next = ans.next;
            ans.next = node;
        }
        return ans.next;
    }
}
