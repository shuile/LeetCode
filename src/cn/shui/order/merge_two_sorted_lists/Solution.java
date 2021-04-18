package cn.shui.order.merge_two_sorted_lists;

public class Solution {
    public static void main (String[] args) {
        ListNode q;

        ListNode l1 = new ListNode( 1 );
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);
        l1.next.next.next = null;

        q = l1;
        System.out.println("l1:");
        while (q != null) {
            System.out.print(q.val + "->");
            q = q.next;
        }
        System.out.println();

        ListNode l2 = new ListNode( 1 );
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);
        l2.next.next.next = null;

        q = l2;
        System.out.println("l2:");
        while (q != null) {
            System.out.print(q.val + "->");
            q = q.next;
        }
        System.out.println();

        ListNode l3 = mergeTwoLists( l1, l2 );

        q = l3;

        while (q != null) {
            System.out.print(q.val + "->");
            q = q.next;
        }
    }

    public static ListNode mergeTwoLists ( ListNode l1, ListNode l2 ) {
        ListNode l3;
        ListNode p = l1;
        ListNode q = l2;
        ListNode r;

        if (p.val > q.val) {
            l3 = q;
            q = q.next;
        } else {
            l3 = p;
            p = p.next;
        }

        r = l3;

        while (q != null && p != null) {
            if (q.val > p.val) {
                r.next = p;
                p = p.next;
            } else {
                r.next = q;
                q = q.next;
            }
            r = r.next;
        }

        while (p != null) {
            r.next = p;
            break;
        }

        while (q != null) {
            r.next = q;
            break;
        }

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