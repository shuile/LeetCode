package cn.shui.offer;

import cn.shui.offer.domain.ListNode;

import java.util.Stack;

public class Offer_06 {
    public static void main(String[] args) {

    }

    private static int[] reversePrint(ListNode head) {
        if (head == null) {
            return new int[]{};
        }
        Stack<ListNode> stack = new Stack<>();
        ListNode p = head;
        while (p != null) {
            stack.push(p);
            p = p.next;
        }
        int count = stack.size();
        int[] ans = new int[count];
        while (!stack.isEmpty()) {
            ans[count - stack.size()] = stack.pop().val;
        }
        return ans;
    }
}
