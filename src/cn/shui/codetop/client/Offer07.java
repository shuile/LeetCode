package cn.shui.codetop.client;

import cn.shui.codetop.client.model.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by chenyiting on 2022/4/8
 * 重建二叉树
 */
public class Offer07 {

    private final Map<Integer, Integer> indexMap = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            indexMap.put(inorder[i], i);
        }
        return build(preorder, 0, preorder.length, inorder, 0, inorder.length);
    }

    private TreeNode build(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        if (preStart > preEnd) {
            return null;
        }
        int rootVal = preorder[preStart];
        int rootIndex = indexMap.get(rootVal);
        int leftSize = rootIndex - inStart;
        TreeNode root = new TreeNode(rootVal);
        root.left = build(preorder, preStart + 1, preStart + leftSize, inorder, inStart, rootIndex - 1);
        root.right = build(preorder, preStart + leftSize + 1, preEnd, inorder, rootIndex + 1, inEnd);
        return root;
    }

    public static void main(String[] args) {
        Offer07 test = new Offer07();
        test.buildTree(new int[]{3,9,20,15,7}, new int[]{9,3,15,20,7});
    }
}
