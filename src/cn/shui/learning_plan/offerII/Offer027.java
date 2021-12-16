package cn.shui.learning_plan.offerII;

import cn.shui.learning_plan.offerII.model.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shui.
 * @date 2021/12/10.
 * @time 23:22.
 * 回文链表
 */
public class Offer027 {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        StringBuilder sb = new StringBuilder();
        ListNode p = head;
        while (p != null) {
            sb.append(p.val);
            p = p.next;
        }
        int l = 0, r = sb.length() - 1;
        while (l < r) {
            if (sb.charAt(l) != sb.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

    // 将值赋值到数组中后用双指针法
    public boolean isPalindrome2(ListNode head) {
        List<Integer> list = new ArrayList<>();
        ListNode p = head;
        while (p != null) {
            list.add(p.val);
            p = p.next;
        }
        int l = 0, h = list.size() - 1;
        while (l < h) {
            if (list.get(l) != list.get(h)) {
                return false;
            }
            l++;
            h--;
        }
        return true;
    }

    // 递归
    private ListNode frontPointer;

    public boolean isPalindrome3(ListNode head) {
        frontPointer = head;
        return recursiveCheck(head);
    }

    private boolean recursiveCheck(ListNode currentNode) {
        if (currentNode != null) {
            if (!recursiveCheck(currentNode.next)) {
                return false;
            }
            if (currentNode.val != frontPointer.val) {
                return false;
            }
        }
        return true;
    }

    // 快慢指针
    public boolean isPalindrome4(ListNode head) {
        if (head == null) {
            return true;
        }

        // 找到前半部分链表的尾结点并反转后半部分链表
        ListNode firstHalfEnd = endOfFirstHalf(head);
        ListNode secondHalfStart = reverseList(firstHalfEnd.next);

        // 判断是否回文
        ListNode p1 = head;
        ListNode p2 = secondHalfStart;
        boolean result = true;
        while (result && p2 != null) {
            if (p1.val != p2.val) {
                result = false;
            }
            p1 = p1.next;
            p2 = p2.next;
        }

        // 还原链表并返回结果
        firstHalfEnd.next = reverseList(secondHalfStart);
        return result;
    }

    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }

    private ListNode endOfFirstHalf(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
