package cn.shui.learning_plan.offer.second;

import cn.shui.learning_plan.offer.model.Node;

import java.util.HashMap;
import java.util.Map;

/**
 * @author shui.
 * @date 2021/9/26.
 * @time 09:35.
 * 复杂链表的复制
 */
public class Offer35 {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Map<Node, Node> map = new HashMap<>();
        Node ans = new Node(0);
        Node p = head, q = ans;
        while (p != null) {
            Node node = new Node(p.val);
            map.put(p, node);
            q.next = node;
            q = q.next;
            p = p.next;
        }
        p = head;
        q = ans.next;
        while (p != null) {
            q.random = map.get(p.random);
            p = p.next;
            q = q.next;
        }
        return ans.next;
    }

    // 回溯+哈希表
    Map<Node, Node> cachedNode = new HashMap<>();
    public Node copyRandomList2(Node head) {
        if (head == null) {
            return null;
        }
        if (!cachedNode.containsKey(head)) {
            Node headNew = new Node(head.val);
            cachedNode.put(head, headNew);
            headNew.next = copyRandomList2(head.next);
            headNew.random = copyRandomList(head.random);
        }
        return cachedNode.get(head);
    }

    // 迭代+节点拆分
    public Node copyRandomList3(Node head) {
        if (head == null) {
            return null;
        }
        Node node = head;
        while (node != null) {
            Node nodeNew = new Node(node.val);
            nodeNew.next = node.next;
            node.next = nodeNew;
            node = node.next.next;
        }
        node = head;
        while (node != null) {
            node.next.random = (node.random != null) ? node.random.next : null;
            node = node.next.next;
        }
        Node headNew = head.next;
        node = head;
        while (node != null) {
            Node nodeNew = node.next;
            node.next = node.next.next;
            nodeNew.next = (nodeNew.next != null) ? nodeNew.next.next : null;
            node = node.next;
        }
        return headNew;
    }
}
