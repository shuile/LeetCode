package merge_k_sorted_lists;

public class Solution {
    public static void main(String[] args) {
        ListNode[] lists = new ListNode[3];
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(5);
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);
        ListNode l3 = new ListNode(2);
        l3.next = new ListNode(6);
        lists[0] = l1;
        lists[1] = l2;
        lists[2] = l3;
        ListNode ansList = mergeKLists(lists);
        while (ansList != null) {
            System.out.print(ansList.val + " ");
            ansList = ansList.next;
        }
        System.out.println();
    }

    private static ListNode mergeKLists(ListNode[] lists) {
        ListNode ansList = new ListNode(0);
        if (lists == null || lists.length < 1) {
            return null;
        }
        if (lists.length == 1) {
            return lists[0];
        }
        int count = 0;
        for (ListNode p : lists) {
            while (p != null) {
                count++;
                p = p.next;
            }
        }
        ListNode q = ansList;
        int whichList = -1;
        for (int i = 0; i < count; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < lists.length; j++) {
                if (lists[j] == null) {
                    continue;
                }
                if (lists[j].val < min) {
                    min = lists[j].val;
                    q.next = lists[j];
                    whichList = j;
                }
            }
            q = q.next;
            lists[whichList] = lists[whichList].next;
        }
        return ansList.next;
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
