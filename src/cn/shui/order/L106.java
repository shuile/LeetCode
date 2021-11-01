package cn.shui.order;

import cn.shui.order.base.TreeNode;

/**
 * @author shui.
 * @date 2021/11/1.
 * @time 09:22.
 * 从中序与后续遍历序列构造二叉树
 */
public class L106 {

    public static void main(String[] args) {
        int[] inorder = {9, 3, 15, 20, 7};
        int[] postorder = {9, 15, 7, 20, 3};
        L106 test = new L106();
        test.buildTree(inorder, postorder);
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || inorder.length < 1 || inorder.length != postorder.length) {
            return null;
        }
        return build(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    private TreeNode build(int[] inorder, int inLeft, int inRight, int[] postorder, int postLeft, int postRight) {
        if (inLeft > inRight || inLeft < 0 || inRight >= inorder.length) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[postRight]);
        int rootInIndex = findIndexFromRange(inorder, inLeft, inRight, postorder[postRight]);
        int leftSize = rootInIndex - inLeft;
        root.left = build(inorder, inLeft, rootInIndex - 1, postorder, postLeft, postLeft + leftSize - 1);
        root.right = build(inorder, rootInIndex + 1, inRight, postorder, postLeft + leftSize, postRight - 1);
        return root;
    }

    private int findIndexFromRange(int[] nums, int l, int r, int target) {
        while (l <= r) {
            if (nums[l] == target) {
                return l;
            }
            l++;
        }
        return -1;
    }
}
