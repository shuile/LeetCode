package remove_duplicates_from_sorted_list;

public class Solution {

    class ListNode {
        int val;
        ListNode next;
        public ListNode( int x) {
            val = x;
        }
    }

    public static void main(String[] args) {

    }

    //
    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode list = head;
        ListNode p = list;
        ListNode q = head.next;
        while(q != null) {
            if (p.val != q.val) {
                p.next = q;
                p = p.next;
            }
            q = q.next;
        }
        return list;
    }
}
