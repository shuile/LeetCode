package cn.shui.learning_plan.offer.twentieth;

import java.util.Stack;

/**
 * @author shui.
 * @date 2021/10/19.
 * @time 15:43.
 */
public class Offer33 {
    public boolean verifyPostorder(int[] postorder) {
        if (postorder == null || postorder.length < 2) {
            return true;
        }
        return help(postorder, 0, postorder.length - 1);
    }

    private boolean help(int[] postorder, int l, int r) {
        if (l > r) {
            return true;
        }
        int firstLargeIndex = findFirstLargerNumberIndexOfRange(postorder, l, r, postorder[r]);
        if (firstLargeIndex == r) {
            return help(postorder, l, r - 1);
        }
        for (int i = firstLargeIndex; i < r; i++) {
            if (postorder[i] < postorder[r]) {
                return false;
            }
        }
        return help(postorder, l, firstLargeIndex - 1) && help(postorder, firstLargeIndex, r - 1);
    }

    private int findFirstLargerNumberIndexOfRange(int[] arr, int l, int r, int target) {
        while (l <= r) {
            if (arr[l] < target) {
                l++;
            } else {
                break;
            }
        }
        return l;
    }

    // 递归分治
    public boolean verifyPostorder2(int[] postorder) {
        return recur(postorder, 0, postorder.length - 1);
    }

    private boolean recur(int[] postorder, int i, int j) {
        if (i >= j) {
            return true;
        }
        int p = i;
        while (postorder[p] < postorder[j]) {
            p++;
        }
        int m = p;
        while (postorder[p] > postorder[j]) {
            p++;
        }
        return p == j && recur(postorder, i, m - 1) && recur(postorder, m, j - 1);
    }

    // 辅助单调栈
    public boolean verifyPostorder3(int[] postorder) {
        Stack<Integer> stack = new Stack<>();
        int root = Integer.MAX_VALUE;
        for (int i = postorder.length - 1; i >= 0; i--) {
            if (postorder[i] > root) {
                return false;
            }
            while (!stack.isEmpty() && stack.peek() > postorder[i]) {
                root = stack.pop();
            }
            stack.add(postorder[i]);
        }
        return true;
    }
}
