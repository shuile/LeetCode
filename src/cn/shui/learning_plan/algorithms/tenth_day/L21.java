package cn.shui.learning_plan.algorithms.tenth_day;

/**
 * @author shui.
 * @date 2021/7/23.
 * @time 09:40.
 * 合并两个有序链表
 */
public class L21 {
    // 递归
    public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val <= l2.val) {
            l1.next = mergeTwoLists1(l1.next, l2);
        } else {
            ListNode temp = l1;
            l1 = l2;
            l1.next = mergeTwoLists1(temp, l2.next);
        }
        return l1;
    }

    // 递归编写优化
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val <= l2.val) {
            l1.next = mergeTwoLists2(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists2(l1, l2.next);
            return l2;
        }
    }

    // 迭代
    public ListNode mergeTwoLists3(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode root = new ListNode();
        ListNode p = root;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                p.next = new ListNode(l1.val);
                l1 = l1.next;
            } else {
                p.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            p = p.next;
        }
//        if (l1 != null) {
//            p.next = l1;
//        }
//        if (l2 != null) {
//            p.next = l2;
//        }
        root.next = l1 == null ? l2 : l1;
        return root.next;
    }


}
