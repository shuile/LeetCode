package cn.shui.learning_plan.offerII;

import cn.shui.learning_plan.offerII.model.Node1;

/**
 * @author shui.
 * @date 2021/12/13.
 * @time 14:36.
 */
public class Offer029 {
    public Node1 insert(Node1 head, int insertVal) {
        if (head == null) {
            head = new Node1(insertVal);
            head.next = head;
            return head;
        }
        Node1 curr = head;
        while (curr.next != head) {
            if (curr.next.val < curr.val) {
                if (curr.next.val >= insertVal) {
                    break;
                }
                if (curr.val <= insertVal) {
                    break;
                }
            }
            if (curr.val <= insertVal && curr.next.val >= insertVal) {
                break;
            }
            curr = curr.next;
        }
        curr.next = new Node1(insertVal, curr.next);
        return head;
    }
}
