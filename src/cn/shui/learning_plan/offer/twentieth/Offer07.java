package cn.shui.learning_plan.offer.twentieth;

import cn.shui.learning_plan.offer.model.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author shui.
 * @date 2021/10/19.
 * @time 14:18.
 */
public class Offer07 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length < 1) {
            return null;
        }
        if (preorder.length == 1) {
            return new TreeNode(preorder[0]);
        }
        return build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode build(int[] preorder, int preL, int preR, int[] inorder, int inL, int inR) {
        if (preL > preR || inL > inR) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preL]);
        int inRootIndex = findIndexOfRange(inorder, inL, inR, preorder[0]);
        root.left = build(preorder, preL + 1, preL + inRootIndex - inL, inorder, inL, inRootIndex - 1);
        root.right = build(preorder, preL + inRootIndex - inL + 1, preR, inorder, inRootIndex + 1, inR);
        return root;
    }

    private int findIndexOfRange(int[] arr, int l, int r, int target) {
        for (int i = l; i <= r; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }

    // 递归
    private Map<Integer, Integer> indexMap;

    public TreeNode buildTree2(int[] preorder, int[] inorder) {
        int n = preorder.length;
        // 构造哈希映射，帮助我们快速定位根节点
        indexMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            indexMap.put(inorder[i], i);
        }
        return myBuildTree(preorder, inorder, 0, n - 1, 0, n - 1);
    }

    public TreeNode myBuildTree(int[] preorder, int[] inorder, int preorder_left, int preorder_right, int inorder_left, int inorder_right) {
        if (preorder_left > preorder_right) {
            return null;
        }
        // 前序遍历中的第一个节点就是根节点
        int preorder_root = preorder_left;
        // 在中序遍历中定位根节点
        int inorder_root = indexMap.get(preorder[preorder_root]);
        // 先把根节点建立出来
        TreeNode root = new TreeNode(preorder[preorder_root]);
        // 得到左子树中的节点数目
        int size_left_subtree = inorder_root - inorder_left;
        // 递归构造左子树，并连接根节点
        // 先序遍历中【从左边界+1开始的size_left_subtree】个元素就对应了中序遍历中【从左边界开始到根节点定位-1】的元素
        root.left = myBuildTree(preorder, inorder, preorder_left + 1, preorder_left + size_left_subtree, inorder_left, inorder_root - 1);
        // 递归构造右子树，并连接根节点
        // 先序遍历中【从左边界+1+左子树节点数目开始到右边界】的元素就对应了中序遍历中【从根节点定位+1到右边界】的元素
        root.right = myBuildTree(preorder, inorder, preorder_left + size_left_subtree + 1, preorder_right, inorder_root + 1, inorder_right);
        return root;
    }
}
