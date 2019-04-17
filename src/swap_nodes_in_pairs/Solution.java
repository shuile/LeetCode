package swap_nodes_in_pairs;

public class Solution {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        ListNode ansList = swapPairs(head);
        while (ansList != null) {
            System.out.print(ansList.val + " ");
            ansList = ansList.next;
        }
        System.out.println();
    }

    private static ListNode swapPairs(ListNode head) {
        ListNode p = head;
        while (p != null && p.next != null) {
            int a = p.val;
            p.val = p.next.val;
            p.next.val = a;
            p = p.next.next;
        }
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
