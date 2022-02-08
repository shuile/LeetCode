package cn.shui.learning_plan.beike.model;

/**
 * @author shui.
 * @date 2022/2/8.
 * @time 09:57.
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
