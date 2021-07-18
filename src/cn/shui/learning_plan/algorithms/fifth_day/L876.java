package cn.shui.learning_plan.algorithms.fifth_day;

/**
 * @author shui.
 * @date 2021/7/18.
 * @time 22:41.
 * 链表的中间节点
 */
public class L876 {
    public ListNode middleNode1(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode p = head, q = head;
        while (q != null && q.next != null) {
            p = p .next;
            q = q.next.next;
        }
        return p;
    }

    public ListNode middleNode2(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode[] nodes = new ListNode[101];
        int count = 0;
        while (head != null) {
            nodes[count++] = head;
            head = head.next;
        }
        return nodes[count / 2];
    }

    public ListNode middleMode3(ListNode head) {
        if (head == null) {
            return null;
        }
        int count = 0;
        ListNode p = head;
        while (p != null) {
            p = p.next;
            count++;
        }
        int middle = 0;
        p = head;
        while (middle < count / 2) {
            middle++;
            p = p.next;
        }
        return p;
    }
}
