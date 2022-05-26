package cn.shui.codetop.client;

import cn.shui.codetop.client.model.ListNode;

import java.util.*;

/**
 * Created by chenyiting on 2022/3/17
 * K个一组翻转链表
 */
public class L25 {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode p = head;
        for (int i = 2; i <= 5; i++) {
            p.next = new ListNode(i);
            p = p.next;
        }
        L25 test = new L25();
        test.reverseKGroup(head, 3);
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        List<ListNode> ans = new ArrayList<>();
        List<ListNode> temp = new ArrayList<>();
        ListNode p = head;
        while (p != null) {
            for (int i = 0; i < k && p != null; i++) {
                temp.add(p);
                p = p.next;
            }
            if (temp.size() == k) {
                Collections.reverse(temp);
            }
            ans.addAll(temp);
            temp.clear();
        }
        ListNode newHead = new ListNode(0);
        p = newHead;
        for (ListNode node : ans) {
            p.next = node;
            p = p.next;
        }
        return newHead.next;
    }

    private ListNode reverseKGroup2(ListNode head, int k) {
        ListNode newHead = new ListNode();
        ListNode start = head, end = head, prev = newHead;
        while (end != null) {
            int i = 0;
            for (; i < k && end != null; i++) {
                end = end.next;
            }
            prev.next = i < k ? start : reverse(start, end);
            prev = start;
            start = end;
        }
        return newHead.next;
    }

    private ListNode reverse(ListNode start, ListNode end) {
        ListNode newHead = new ListNode();
        while (start != end) {
            ListNode temp = start.next;
            start.next = newHead.next;
            newHead.next = start;
            start = temp;
        }
        return newHead.next;
    }

    private ListNode reverseGroup3(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        ListNode p = head, q = head;
        for (int i = 0; i < k; i++) {
            if (q == null) {
                return head;
            }
            q = q.next;
        }
        ListNode newHead = reverse2(p, q);
        p.next = reverseGroup3(q, k);
        return newHead;
    }

    private ListNode reverse2(ListNode p, ListNode q) {
        ListNode pre = null, curr = p, next = p;
        while (curr != q) {
            next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }
}
