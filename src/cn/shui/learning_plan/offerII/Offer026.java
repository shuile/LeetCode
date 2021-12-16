package cn.shui.learning_plan.offerII;

import cn.shui.learning_plan.offerII.model.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shui.
 * @date 2021/12/10.
 * @time 22:58.
 * 重排链表
 */
public class Offer026 {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

        Offer026 test = new Offer026();
        test.reorderList(head);
        System.out.println(head);
    }

    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        int len = 0;
        ListNode p = head;
        while (p != null) {
            len++;
            p = p.next;
        }
        int half = len / 2;
        p = head;
        while (half > 0) {
            half--;
            p = p.next;
        }
        ListNode l1 = head, l2 = p.next;
        p.next = null;
        ListNode l2reverse = new ListNode(0);
        p = l2;
        while (p != null) {
            ListNode temp = p.next;
            p.next = l2reverse.next;
            l2reverse.next = p;
            p = temp;
        }
        ListNode ans = new ListNode(0);
        ListNode q = l2reverse.next, r = ans;
        p = l1;
        while (p != null && q != null) {
            ans.next = p;
            p = p.next;
            ans = ans.next;
            ans.next = q;
            q = q.next;
            ans = ans.next;
        }
        if (p != null) {
            ans.next = p;
        } else {
            ans.next = q;
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
}
