package cn.shui.learning_plan.offer.second;

import cn.shui.learning_plan.offer.model.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shui.
 * @date 2021/9/26.
 * @time 09:18.
 * 从头到尾打印链表
 */
public class Offer06 {
    public int[] reversePrint(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(0, head.val);
            head = head.next;
        }
        int[] ans = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }
}
