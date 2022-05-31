package cn.shui.labuladong;

import cn.shui.labuladong.model.ListNode;
import cn.shui.labuladong.model.TreeNode;

/**
 * Created by chenyiting on 2022/5/31
 */
public class L1367 {

    private ListNode newHead;

    public boolean isSubPath(ListNode head, TreeNode root) {
        if (head == null || root == null) {
            return false;
        }
        newHead = head;
        return travsers(root);
    }

    private boolean travsers(TreeNode root) {
        if (root == null) {
            return false;
        }
        if (root.val == newHead.val) {
            if (compare(root, newHead)) {
                return true;
            }
        }
        return travsers(root.left) || travsers(root.right);
    }

    private boolean compare(TreeNode root, ListNode node) {
        if (node == null) {
            return true;
        }
        if (root == null || root.val != node.val) {
            return false;
        }
        return compare(root.left, node.next) || compare(root.right, node.next);
    }
}
