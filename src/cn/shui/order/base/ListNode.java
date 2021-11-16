package cn.shui.order.base;

/**
 * @author shui.
 * @date 2021/11/16.
 * @time 14:26.
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
