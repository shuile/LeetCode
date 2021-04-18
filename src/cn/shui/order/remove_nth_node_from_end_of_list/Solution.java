package cn.shui.order.remove_nth_node_from_end_of_list;

public class Solution {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
//        head.next.next = new ListNode(3);
//        head.next.next.next = new ListNode(4);
//        head.next.next.next.next = new ListNode(5);
        int n = 2;
        ListNode res = removeNthFromEnd(head, n);
        while (res != null) {
            System.out.print(res.val + " ");
            res = res.next;
        }
        System.out.println();
    }

    private static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return head;
        }
        ListNode p = head;
        int len = 0;
        while (p != null) {
            len++;
            p = p.next;
        }
        if (len == n) {
            head = head.next;
            return head;
        }
        int count = len - n - 1;
        p = head;
        while (count > 0) {
            count--;
            p = p.next;
        }
        p.next = p.next.next;
        return head;
    }

    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }
}
