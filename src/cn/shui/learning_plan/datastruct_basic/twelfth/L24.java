package cn.shui.learning_plan.datastruct_basic.twelfth;

/**
 * @author shui.
 * @date 2021/9/13.
 * @time 22:00.
 */
public class L24 {

    public ListNode swapPairs1(ListNode head) {
        ListNode ans = new ListNode(0, head);
        ListNode p = ans;
        while (p.next != null && p.next.next != null) {
            ListNode temp1 = p.next;
            ListNode temp2 = p.next.next;
            ListNode temp3 = p.next.next.next;
            temp1.next = temp3;
            temp2.next = temp1;
            p.next = temp2;
            p = temp1;
        }
        return ans.next;
    }

    // 递归
    public ListNode swapPairs2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = head.next;
        head.next = swapPairs2(newHead.next);
        newHead.next = head;
        return newHead;
    }

    // 迭代
    public ListNode swapPairs3(ListNode head) {
        ListNode dummyHead = new ListNode(0, head);
        ListNode temp = dummyHead;
        while (temp.next != null && temp.next.next != null) {
            ListNode node1 = temp.next;
            ListNode node2 = temp.next.next;
            temp.next = node2;
            node1.next = node2.next;
            node2.next = node1;
            temp = node1;
        }
        return dummyHead.next;
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
