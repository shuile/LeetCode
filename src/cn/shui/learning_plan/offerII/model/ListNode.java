package cn.shui.learning_plan.offerII.model;

/**
 * @author shui.
 * @date 2021/12/10.
 * @time 16:48.
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
