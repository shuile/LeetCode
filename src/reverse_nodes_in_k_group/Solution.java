package reverse_nodes_in_k_group;

public class Solution {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        int k = 2;
        ListNode ansList = reverseKGroup(head, k);
        while (ansList != null) {
            System.out.print(ansList.val);
            ansList = ansList.next;
        }
        System.out.println();
    }

    private static ListNode reverseKGroup(ListNode head, int k) {
        ListNode p = head;
        int count = 0;
        while (p != null) {
            count++;
            p = p.next;
        }
        if (count / k == 0) {
            return head;
        }
        p = head;
        ListNode q = head;
        int[] temp = new int[k];
        for (int i = 0; i < (count / k); i++) {
            for (int j = 0; j < k; j++) {
                temp[j] = p.val;
                p = p.next;
            }
            for (int j = k - 1; j >= 0; j--) {
                q.val = temp[j];
                q = q.next;
            }
        }
        return head;
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode (int x) {
            val = x;
        }
    }
}
