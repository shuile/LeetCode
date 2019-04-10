package add_two_numbers;

public class Solution {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(5);
        ListNode l2 = new ListNode(5);
        ListNode result = addTwoNumbers(l1, l2);
        while (result != null) {
            System.out.print(result.val);
            result = result.next;
        }
        System.out.println();
    }

    public static ListNode addtwoNumders2(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode p = l1;
        ListNode q = l2;
        ListNode temp = head;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = x + y + carry;
            carry = sum / 10;
            temp.next = new ListNode(sum % 10);
            temp = temp.next;
            if (p != null) {
                p = p.next;
            }
            if (q != null) {
                q = q.next;
            }
        }
        if (carry > 0) {
            temp.next = new ListNode(carry);
        }
        return head.next;
    }

    /**
     * 方法1
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode temp = l1;
        int carry = 0;
        while (temp != null && l2 != null) {
            int t = temp.val + l2.val + carry;
            if (t >= 10) {
                carry = 1;
                t %= 10;
            }
            temp.val = t;
            temp = temp.next;
            l2 = l2.next;
        }
        while (temp != null) {
            int t = temp.val + carry;
            if (t >= 10) {
                carry = 1;
                t %= 10;
            }
            temp.val = t;
            temp = temp.next;
        }
        if (temp == null) {
            temp = l1;
            while (temp.next != null) {
                temp = temp.next;
            }
        }
        while (l2 != null) {
            int t = l2.val + carry;
            if (t >= 10) {
                carry = 1;
                t %= 10;
            }
            if (temp.next == null) {
                temp.next = l2;
            }
            temp = temp.next;
            temp.val = t;
            l2 = l2.next;
        }
        return l1;
    }

    public static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }
}
