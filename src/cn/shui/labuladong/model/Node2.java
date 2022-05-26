package cn.shui.labuladong.model;

/**
 * Created by chenyiting on 2022/5/26
 */
public class Node2 {
    public int val;
    public Node2 left;
    public Node2 right;
    public Node2 next;

    public Node2() {
    }

    public Node2(int val) {
        this.val = val;
    }

    public Node2(int val, Node2 left, Node2 right, Node2 next) {
        this.val = val;
        this.left = left;
        this.right = right;
        this.next = next;
    }
}
