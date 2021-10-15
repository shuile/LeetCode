package cn.shui.learning_plan.offer.fifteenth;

import cn.shui.learning_plan.offer.model.Node2;

/**
 * @author shui.
 * @date 2021/10/15.
 * @time 15:31.
 */
public class Offer36 {

    private Node2 pre, head;

    public Node2 treeToDoublyList(Node2 root) {
        if (root == null) {
            return null;
        }
        dfs(root);
        head.left = pre;
        pre.right = head;
        return head;
    }

    private void dfs(Node2 cur) {
        if (cur == null) {
            return;
        }
        dfs(cur.left);
        if (pre != null) {
            pre.right = cur;
        } else {
            head = cur;
        }
        cur.left = pre;
        pre = cur;
        dfs(cur.right);
    }
}
