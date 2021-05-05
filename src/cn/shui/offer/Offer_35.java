package cn.shui.offer;

import cn.shui.offer.domain.Node;

import java.util.HashMap;
import java.util.Map;

public class Offer_35 {
    public static void main(String[] args) {

    }

    private Node copyRandomList(Node head) {
        Node ans = new Node(0);
        Node p = ans;
        Node q = head;
        while (q != null) {
            p.next = new Node(q.val);
            q = q.next;
            p = p.next;
        }
        p = ans.next;
        q = head;
        Node r = p;
        Node s = q;
        while (p != null) {
            Node ran = q.random;
            if (ran != null) {
                while (ran != s) {
                    s = s.next;
                    r = r.next;
                }
                p.random = r;
            } else {
                p.random = null;
            }
            p = p.next;
            q = q.next;
            r = ans.next;
            s = head;
        }
        return ans.next;
    }

    private Node copyRandomList2(Node head) {
        if (head == null) {
            return null;
        }
        Node cur = head;
        Map<Node, Node> map = new HashMap<>();
        while (cur != null) {
            map.put(cur, new Node(cur.val));
            cur = cur.next;
        }
        cur = head;
        while (cur != null) {
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        return map.get(head);
    }

    private Node copyRandomList3(Node head) {
        if (head == null) {
            return null;
        }
        Node cur = head;
        while (cur != null) {
            Node tmp = new Node(cur.val);
            tmp.next = cur.next;
            cur.next = tmp;
            cur = tmp.next;
        }
        cur = head;
        while (cur != null) {
            if (cur.random != null) {
                cur.next.random = cur.random.next;
            }
            cur = cur.next.next;
        }
        cur = head.next;
        Node pre = head, ans = head.next;
        while (cur.next != null) {
            pre.next = pre.next.next;
            cur.next = cur.next.next;
            pre = pre.next;
            cur = cur.next;
        }
        pre .next = null;
        return ans;
    }
}
