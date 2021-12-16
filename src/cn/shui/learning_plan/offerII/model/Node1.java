package cn.shui.learning_plan.offerII.model;

/**
 * @author shui.
 * @date 2021/12/13.
 * @time 14:36.
 */
public class Node1 {
    public int val;
    public Node1 next;

    public Node1() {
    }

    public Node1(int val) {
        this.val = val;
    }

    public Node1(int val, Node1 next) {
        this.val = val;
        this.next = next;
    }
}
