package cn.shui.codetop.client;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by chenyiting on 2022/4/9
 * 搜索二叉树的后序遍历序列
 */
public class Offer33 {
    // 辅助栈
    public boolean verifyPostorder(int[] postorder) {
        Deque<Integer> deque = new LinkedList<>();
        int len = postorder.length, root = Integer.MAX_VALUE;
        for (int i = len - 1; i >= 0; i--) {
            if (postorder[i] > root) {
                return false;
            }
            while (!deque.isEmpty() && postorder[i] < deque.peek()) {
                root = deque.pop();
            }
            deque.push(postorder[i]);
        }
        return true;
    }

    // 递归分治
    public boolean verifyPostorder2(int[] postorder) {
        return recur(postorder, 0, postorder.length - 1);
    }

    private boolean recur(int[] postorder, int l, int r) {
        if (l >= r) {
            return true;
        }
        int p = l;
        while (postorder[p] < postorder[r]) {
            p++;
        }
        int m = p;
        while (postorder[p] > postorder[r]) {
            p++;
        }
        return p == r && recur(postorder, l, m - 1) && recur(postorder, m, r - 1);
    }


}
