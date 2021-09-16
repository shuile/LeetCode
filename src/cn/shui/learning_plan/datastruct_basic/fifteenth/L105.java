package cn.shui.learning_plan.datastruct_basic.fifteenth;

import java.util.*;

/**
 * @author shui.
 * @date 2021/9/16.
 * @time 09:49.
 * 从前序与中序遍历序列构造二叉树
 */
public class L105 {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] ints = Arrays.copyOfRange(nums, 1, nums.length);
        System.out.println(Arrays.toString(nums));
        System.out.println(Arrays.toString(ints));

        L105 test = new L105();
        test.buildTree1(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});
    }

    public TreeNode buildTree1(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length < 1 || inorder == null || inorder.length < 1) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        int rootIndex = findTarget(inorder, preorder[0]);
        if (rootIndex == -1) {
            return root;
        }
        root.left = buildTree1(Arrays.copyOfRange(preorder, 1, rootIndex + 1), Arrays.copyOfRange(inorder, 0, rootIndex));
        root.right = buildTree1(Arrays.copyOfRange(preorder, 1 + rootIndex, preorder.length), Arrays.copyOfRange(inorder, rootIndex + 1, inorder.length));
        return root;
    }

    private int findTarget(int[] inorder, int target) {
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == target) {
                return i;
            }
        }
        return -1;
    }

    private Map<Integer, Integer> indexMap;

    // 递归
    public TreeNode buildTree2(int[] preorder, int[] inorder) {
        int n = preorder.length;
        // 构造哈希映射表，帮助我们快速定位根节点
        indexMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            indexMap.put(inorder[i], i);
        }
        return myBuildTree(preorder, inorder, 0, n - 1, 0, n - 1);
    }

    private TreeNode myBuildTree(int[] preorder, int[] inorder, int preorder_left, int preorder_right,
                                 int inorder_left, int inorder_right) {
        if (preorder_left > preorder_right) {
            return null;
        }
        // 前序遍历中的第一个节点就是根节点
        int preorder_root = preorder_left;
        // 中序遍历中定位根节点
        int inorder_root = indexMap.get(preorder[preorder_root]);
        // 先把根节点建立出来
        TreeNode root = new TreeNode(preorder[preorder_root]);
        // 得到左子树中的节点数目
        int size_left_subtree = inorder_root - inorder_left;
        // 递归地构造左子树，并连接到根节点
        // 先序遍历中[从 左边界+1 开始的size_left_subtree]个元素就对应了中序遍历中[从 左边界 开始到 根节点定位-1]的元素
        root.left = myBuildTree(preorder, inorder, preorder_left + 1,
                preorder_left + size_left_subtree, inorder_left, inorder_root - 1);
        // 递归地构造右子树，并连接到根节点
        // 先序遍历中[从 左边界+1+左子树节点数目 开始到有边界]的元素就对应了中序遍历中[从 根节点定位+1 到 右边界]的元素
        root.right = myBuildTree(preorder, inorder, preorder_left + 1 + size_left_subtree, preorder_right,
                inorder_root + 1, inorder_right);
        return root;
    }

    // 迭代
    public TreeNode buildTree3(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length < 1) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        int inorderIndex = 0;
        for (int i = 0; i < preorder.length; i++) {
            int preorderVal = preorder[i];
            TreeNode node = stack.peek();
            if (node.val != inorder[inorderIndex]) {
                node.left = new TreeNode(preorderVal);
                stack.push(node.left);
            } else {
                while (!stack.isEmpty() && stack.peek().val == inorder[inorderIndex]) {
                    node = stack.pop();
                    inorderIndex++;
                }
                node.right = new TreeNode(preorderVal);
                stack.push(node.right);
            }
        }
        return root;
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
