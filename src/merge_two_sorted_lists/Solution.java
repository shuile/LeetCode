package merge_two_sorted_lists;

public class Solution {
    public static void main (String[] args) {
        ListNode l1 = new ListNode( 1 );
        l1.next.val = 2;
        l1.next.next.val = 4;
        l1.next.next.next = null;

        ListNode l2 = new ListNode( 1 );
        l2.next.val = 3;
        l2.next.next.val = 4;
        l2.next.next.next = null;

        ListNode l3 = mergeTwoLists( l1, l2 );
    }

    public static ListNode mergeTwoLists ( ListNode l1, ListNode l2 ) {
        ListNode l3;
        ListNode p = l1;
        ListNode q = l2;

        if ( l1 == null ) {
            return l2;
        } else if ( l2 == null ) {
            return l1;
        }

        if ( l1.val > l2.val ) {
            l3 = l2;
            q = q.next;
        } else {
            l3 = l1;
            p = p.next;
        }

        ListNode r = l3;

        while ( p.next != null && q.next != null ) {
            if ( p.val > q.val ) {
                r.next = q;
                q = q.next;
            } else {
                r.next = p;
                p = p.next;
            }
            r = r.next;
        }

        r.next = p?p:q;

        return l3;
    }
}

class ListNode {
    int val;
    ListNode next;

    public ListNode ( int x ) {
        val = x;
    }
}