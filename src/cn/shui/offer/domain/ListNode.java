package cn.shui.offer.domain;

public class ListNode {
    public int val;
    public ListNode next;

    ListNode() {
    }

    public ListNode(int x) {
        val = x;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
