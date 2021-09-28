package cn.shui.order;

import cn.shui.offer.domain.ListNode;

/**
 * @author shui.
 * @date 2021/9/28.
 * @time 11:29.
 * 反转链表II
 */
public class L92 {

    public static void main(String[] args) {
        ListNode head = new ListNode(3, new ListNode(5));
        L92 test = new L92();
        test.reverseBetween(head, 1, 2);
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || head.next == null || left == right) {
            return head;
        }
        ListNode ans = new ListNode(0);
        ListNode pre = ans, p = head, q= ans;
        int count = 0;
        while (p != null) {
            count++;
            if (count <= left) {
                pre = q;
                ListNode temp = p.next;
                p.next = q.next;
                q.next = p;
                q = q.next;
                p = temp;
            } else if (count <= right) {
                ListNode temp = p.next;
                p.next = pre.next;
                pre.next = p;
                p = temp;
            } else {
                q.next = p;
                break;
            }
        }
        return ans.next;
    }

    // 穿针引线
    public ListNode reverseBetween2(ListNode head, int left, int right) {
        // 因为头结点有可能发生变化，使用虚拟头结点可以避免复杂的分类讨论
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;

        ListNode pre = dummyNode;
        // 第一步：从虚拟节点走left - 1步，来到left节点的前一个节点
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }

        // 第2步：从pre再走right - left + 1步，来到right节点
        ListNode rightNode = pre;
        for (int i = 0; i < right - left + 1; i++) {
            rightNode = rightNode.next;
        }

        // 第3步：切断出一个子链表（截取链表）
        ListNode leftNode = pre.next;
        ListNode curr = rightNode.next;

        // 注意：切断链接
        pre.next = null;
        rightNode.next = null;

        // 第4步：反转链表的子区间
        reverseLinkedList(leftNode);

        // 第5步：接回到原来的链表中
        pre.next = rightNode;
        leftNode.next = curr;
        return dummyNode.next;
    }

    private void reverseLinkedList(ListNode head) {
        // 也可以使用递归反转一个链表
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
    }

    // 一次遍历「穿针引线」反转链表（头插法）
    public ListNode reverseBetween3(ListNode head, int left, int right) {
        // 设置dummyNode是这一类问题的一般做法
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode pre = dummyNode;
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }
        ListNode cur = pre.next;
        ListNode next;
        for (int i = 0; i < right - left; i++) {
            next = cur.next;
            cur.next = next.next;
            next.next = pre.next;
            pre.next = next;
        }
        return dummyNode.next;
    }
}
