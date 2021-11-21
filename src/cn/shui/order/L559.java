package cn.shui.order;

import cn.shui.order.base.Node2;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author shui.
 * @date 2021/11/21.
 * @time 20:44.
 * N叉树的最大深度
 */
public class L559 {
    public int maxDepth(Node2 root) {
        if (root == null) {
            return 0;
        }
        int depth = 0;
        for (Node2 child : root.children) {
            depth = Math.max(depth, maxDepth(child));
        }
        return 1 + depth;
    }

    public int maxDepth2(Node2 root) {
        if (root == null) {
            return 0;
        }
        int depth = 0;
        Queue<Node2> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            depth++;
            for (int i = 0; i < size; i++) {
                Node2 node = queue.poll();
                for (Node2 child : node.children) {
                    queue.offer(child);
                }
            }
        }
        return depth;
    }
}
