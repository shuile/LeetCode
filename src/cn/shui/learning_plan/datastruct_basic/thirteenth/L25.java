package cn.shui.learning_plan.datastruct_basic.thirteenth;

/**
 * @author shui.
 * @date 2021/9/14.
 * @time 13:39.
 * K个一组翻转链表
 */
public class L25 {

    public ListNode reverseKGroup1(ListNode head, int k) {
        ListNode ans = new ListNode(0, head);
        ListNode preStart = ans, end = ans;
        while (preStart.next != null) {
            for (int i = 0; i < k && end != null; i++) {
                end = end.next;
            }
            if (end == null) {
                break;
            }
            ListNode temp = preStart.next;
            ListNode p = preStart.next;
            while (p != end) {
                ListNode node = p.next;
                p.next = end.next;
                end.next = p;
                p = node;
            }
            preStart.next = end;
            preStart = temp;
            end = preStart;
        }
        return ans.next;
    }

    // 模拟
    public ListNode reverseKGroup2(ListNode head, int k) {
        ListNode hair = new ListNode(0, head);
        ListNode pre = hair;
        while (head != null) {
            ListNode tail = pre;
            // 查看剩余部分长度是否大于等于k
            for (int i = 0; i < k; i++) {
                tail = tail.next;
                if (tail == null) {
                    return hair.next;
                }
            }
            ListNode nex = tail.next;
            ListNode[] reverse = myReverse(head, tail);
            head = reverse[0];
            tail = reverse[1];
            // 把子链表重新接回原链表
            pre.next = head;
            tail.next = nex;
            pre = tail;
            head = tail.next;
        }
        return hair.next;
    }

    private ListNode[] myReverse(ListNode head, ListNode tail) {
        ListNode prev = tail.next;
        ListNode p = head;
        while (prev != tail) {
            ListNode nex = p.next;
            p.next = prev;
            prev = p;
            p = nex;
        }
        return new ListNode[]{tail, head};
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
