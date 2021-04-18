package cn.shui.offer;

import cn.shui.offer.domain.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Offer_07 {
    public static void main(String[] args) {

    }

    private final Map<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0 || inorder == null || inorder.length == 0) {
            return null;
        }
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return recursion(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    private TreeNode recursion(int[] preorder, int[] inorder, int preLeft, int preRight, int inLeft, int inRight) {
        if (preLeft > preRight || inLeft > inRight) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preLeft]);
        int rootIndex = map.get(root.val);
        int leftSize = rootIndex - inLeft;
        root.left = recursion(preorder, inorder, preLeft + 1, preLeft + leftSize - 1, inLeft, rootIndex - 1);
        root.right = recursion(preorder, inorder, preLeft + leftSize + 1, preRight, rootIndex + 1, inRight);
        return root;
    }
}
