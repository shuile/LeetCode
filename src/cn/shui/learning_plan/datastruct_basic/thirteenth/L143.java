package cn.shui.learning_plan.datastruct_basic.thirteenth;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shui.
 * @date 2021/9/14.
 * @time 16:06.
 * 重排链表
 */
public class L143 {

    public void reorderList1(ListNode head) {
        int len = 0;
        ListNode p = head;
        while (p != null) {
            p = p.next;
            len++;
        }
        ListNode node1 = new ListNode(0, head);
        ListNode node2 = new ListNode(0);
        ListNode n1 = node1, n2 = node2;
        p = head;
        int half = (len + 1) / 2;
        int index = 0;
        for (; index < half; index++) {
            p = p.next;
            n1 = n1.next;
        }
        n1.next = null;
        for (; index < len; index++) {
            ListNode temp = p;
            p = p.next;
            temp.next = n2.next;
            n2.next = temp;
        }
        ListNode ans = new ListNode(0);
        p = ans;
        n1 = node1;
        int count = 0;
        while (n1 != null && n2 != null) {
            if (count % 2 == 0) {
                p.next = n1;
                n1 = n1.next;
            } else {
                p.next = n2;
                n2 = n2.next;
            }
            count++;
            p = p.next;
        }
        if (n1 != null) {
            p.next = n1;
        }
        if (n2 != null) {
            p.next = n2;
        }
        head = ans.next;
    }

    // 线性表
    public void reorderList2(ListNode head) {
        if (head == null) {
            return;
        }
        List<ListNode> list = new ArrayList<>();
        ListNode node = head;
        while (node != null) {
            list.add(node);
            node = node.next;
        }
        int i = 0, j = list.size() - 1;
        while (i < j) {
            list.get(i).next = list.get(j);
            i++;
            if (i == j) {
                break;
            }
            list.get(j).next = list.get(i);
            j--;
        }
        list.get(i).next = null;
    }

    // 寻找链表中点+链表逆序+合并链表
    public void reorderList3(ListNode head) {
        if (head == null) {
            return;
        }
        ListNode mid = middleNode(head);
        ListNode l1 = head, l2 = mid.next;
        mid.next = null;
        l2 = reverseList(l2);
        mergeList(l1, l2);
    }

    private ListNode middleNode(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

    private void mergeList(ListNode l1, ListNode l2) {
        ListNode l1_tmp, l2_tmp;
        while (l1 != null && l2 != null) {
            l1_tmp = l1.next;
            l2_tmp = l2.next;
            l1.next = l2;
            l1 = l1_tmp;
            l2.next = l1;
            l2 = l2_tmp;
        }
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
