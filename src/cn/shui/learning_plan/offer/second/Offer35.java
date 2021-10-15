package cn.shui.learning_plan.offer.second;

import cn.shui.learning_plan.offer.model.Node1;

import java.util.HashMap;
import java.util.Map;

/**
 * @author shui.
 * @date 2021/9/26.
 * @time 09:35.
 * 复杂链表的复制
 */
public class Offer35 {
    public Node1 copyRandomList(Node1 head) {
        if (head == null) {
            return null;
        }
        Map<Node1, Node1> map = new HashMap<>();
        Node1 ans = new Node1(0);
        Node1 p = head, q = ans;
        while (p != null) {
            Node1 node1 = new Node1(p.val);
            map.put(p, node1);
            q.next = node1;
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
    Map<Node1, Node1> cachedNode = new HashMap<>();
    public Node1 copyRandomList2(Node1 head) {
        if (head == null) {
            return null;
        }
        if (!cachedNode.containsKey(head)) {
            Node1 headNew = new Node1(head.val);
            cachedNode.put(head, headNew);
            headNew.next = copyRandomList2(head.next);
            headNew.random = copyRandomList(head.random);
        }
        return cachedNode.get(head);
    }

    // 迭代+节点拆分
    public Node1 copyRandomList3(Node1 head) {
        if (head == null) {
            return null;
        }
        Node1 node1 = head;
        while (node1 != null) {
            Node1 node1New = new Node1(node1.val);
            node1New.next = node1.next;
            node1.next = node1New;
            node1 = node1.next.next;
        }
        node1 = head;
        while (node1 != null) {
            node1.next.random = (node1.random != null) ? node1.random.next : null;
            node1 = node1.next.next;
        }
        Node1 headNew = head.next;
        node1 = head;
        while (node1 != null) {
            Node1 node1New = node1.next;
            node1.next = node1.next.next;
            node1New.next = (node1New.next != null) ? node1New.next.next : null;
            node1 = node1.next;
        }
        return headNew;
    }
}
