package cn.shui.learning_plan.datastruct.seventh;

/**
 * @author shui.
 * @date 2021/8/22.
 * @time 19:28.
 * 移除链表元素
 */
public class L203 {
    public ListNode removeElements1(ListNode head, int val) {
        ListNode ans = new ListNode (0);
        ListNode p = ans;
        while (head != null) {
            if (head.val == val) {
                head = head.next;
                continue;
            }
            p.next = head;
            head = head.next;
            p = p.next;
        }
        p.next = null;
        return ans.next;
    }

    // 递归
    public ListNode removeElements2(ListNode head, int val) {
        if (head == null) {
            return head;
        }
        head.next = removeElements2(head.next, val);
        return head.val == val ? head.next : head;
    }

    // 迭代
    public ListNode removeElements3(ListNode head, int val) {
        ListNode dummyHead = new ListNode(0, head);
        ListNode temp = dummyHead;
        while (temp.next != null) {
            if (temp.next.val == val) {
                temp.next = temp.next.next;
            } else {
                temp = temp.next;
            }
        }
        return dummyHead.next;
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
