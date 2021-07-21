package cn.shui.learning_plan.algorithms.eighth_day;

/**
 * @author shui.
 * @date 2021/7/21.
 * @time 23:59.
 */
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

    public Node(int val) {
        this.val = val;
    }

    public Node(int val, Node left, Node right, Node next) {
        this.val = val;
        this.left = left;
        this.right = right;
        this.next = next;
    }
}
