package cn.shui.order;

import cn.shui.offer.domain.ListNode;

/**
 * @author shui.
 * @date 2021/11/2.
 * @time 09:12.
 * 删除链表中的节点
 */
public class L237 {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
