package cn.shui.learning_plan.offer.model;

/**
 * @author shui.
 * @date 2021/10/15.
 * @time 15:31.
 */
public class Node2 {
    public int val;
    public Node2 left;
    public Node2 right;

    public Node2() {
    }

    public Node2(int val) {
        this.val = val;
    }

    public Node2(int val, Node2 left, Node2 right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
