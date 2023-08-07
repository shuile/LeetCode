package cn.shui.order;

import cn.shui.order.base.ListNode;

import java.util.Random;

/**
 * Created by chenyiting on 2023/8/7
 * 链表随机节点
 */
public class L382 {

    private static class Solution {

        private int mLen = 0;
        private ListNode mHead = null;

        public Solution(ListNode head) {
            if (head == null) {
                return;
            }
            mHead = head;
            mLen = 0;
            ListNode p = head;
            while (p != null) {
                mLen++;
                p = p.next;
            }
        }

        public int getRandom() {
            if (mLen == 0) {
                return -1;
            }
            int index = new Random().nextInt(mLen);
            ListNode p = mHead;
            while (index > 0) {
                index--;
                p = p.next;
            }
            return p.val;
        }
    }

    /**
     * 官方题解：水塘抽样
     */
    private static class Solution2 {

        private ListNode mHead;
        private Random mRandom;

        public Solution2(ListNode head) {
            mHead = head;
            mRandom = new Random();
        }

        public int getRandom() {
            int i = 1, ans = 0;
            ListNode p = mHead;
            while (p != null) {
                if (mRandom.nextInt(i) == 0) {
                    ans = p.val;
                }
                i++;
                p = p.next;
            }
            return ans;
        }
    }
}
