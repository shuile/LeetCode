package cn.shui.order;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shui.
 * @date 2021/8/23.
 * @time 11:39.
 * 分隔链表
 */
public class L86 {

    public static void main(String[] args) {
        L86 test = new L86();
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(4);
        list.add(3);
        list.add(2);
        list.add(5);
        list.add(2);
        ListNode newHead = createListNode(list);
        printListNode(newHead);
        ListNode head = new ListNode(1);
        head.next = new ListNode(4);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(2);
        printListNode(head);
        printListNode(test.partition1(head, 3));
    }

    public ListNode partition1(ListNode head, int x) {
        ListNode newHead = new ListNode(0, head);
        ListNode preList = new ListNode();
        ListNode pre = null, p = newHead, q = preList;
        while (p.next != null) {
            if (p.next.val < x) {
                if (pre != null) {
                    q.next = new ListNode(p.next.val);
                    p.next = p.next.next;
                    q = q.next;
                    continue;
                }
            } else {
                if (pre == null) {
                    pre = p;
                }
            }
            p = p.next;
        }
        if (pre != null && preList.next != null) {
            q.next = pre.next;
            pre.next = preList.next;
        }
        return newHead.next;
    }

    public ListNode partition2(ListNode head, int x) {
        ListNode small = new ListNode(0);
        ListNode smallHead = small;
        ListNode large = new ListNode(0);
        ListNode largeHead = large;
        while (head != null) {
            if (head.val < x) {
                small.next = head;
                small = smallHead.next;
            } else {
                large.next = head;
                large = largeHead.next;
            }
            head = head.next;
        }
        large.next = null;
        small.next = largeHead.next;
        return smallHead.next;
    }

    private static ListNode createListNode(List<Integer> list) {
        if (list == null || list.size() < 1) {
            return null;
        }
        ListNode head = new ListNode(0);
        ListNode p = head;
        for (int i : list) {
            p.next = new ListNode(i);
            p = p.next;
        }
        return head.next;
    }

    private static void printListNode(ListNode head) {
        if (head == null) {
            System.out.println("head is null");
        }
        ListNode p = head;
        System.out.print("ListNode=[");
        while (p.next != null) {
            System.out.print(p.val + ", ");
            p = p.next;
        }
        System.out.println(p.val + "]");
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
