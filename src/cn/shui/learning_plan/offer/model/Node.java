package cn.shui.learning_plan.offer.model;

/**
 * @author shui.
 * @date 2021/9/26.
 * @time 09:35.
 */
public class Node {
    public int val;
    public Node next;
    public Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
