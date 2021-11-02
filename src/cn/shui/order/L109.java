package cn.shui.order;

import cn.shui.offer.domain.ListNode;
import cn.shui.order.base.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shui.
 * @date 2021/11/2.
 * @time 09:20.
 * 有序链表转换二叉搜索树
 */
public class L109 {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        List<Integer> list = new ArrayList<>();
        ListNode p = head;
        while (p != null) {
            list.add(p.val);
            p = p.next;
        }
        return build(list, 0, list.size());
    }

    private TreeNode build(List<Integer> list, int start, int end) {
        if (start > end) {
            return null;
        }
        int rootIndex = start + (end - start) / 2;
        TreeNode root = new TreeNode(list.get(rootIndex));
        root.left = build(list, start, rootIndex - 1);
        root.right = build(list, rootIndex + 1, end);
        return root;
    }

    // 分治 + 中序遍历优化
    private ListNode globalHead;
    public TreeNode sortedListToBST2(ListNode head) {
        globalHead = head;
        int length = getLength(head);
        return buildTree(0, length - 1);
    }

    private int getLength(ListNode head) {
        int ret = 0;
        while (head != null) {
            ret++;
            head = head.next;
        }
        return ret;
    }

    private TreeNode buildTree(int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = (left + right + 1) / 2;
        TreeNode root = new TreeNode();
        root.left = buildTree(left, mid - 1);
        root.val = globalHead.val;
        globalHead = globalHead.next;
        root.right = buildTree(mid + 1, right);
        return root;
    }
}
