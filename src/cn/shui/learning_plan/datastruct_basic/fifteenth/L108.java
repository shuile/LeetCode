package cn.shui.learning_plan.datastruct_basic.fifteenth;

import java.util.Random;

/**
 * @author shui.
 * @date 2021/9/15.
 * @time 17:50.
 * 将有序数组转换为二叉树
 */
public class L108 {

    // 中序遍历，总是选择中间位置左边的数组作为根节点
    public TreeNode sortedArrayToBST1(int[] nums) {
        if (nums == null || nums.length < 1) {
            return null;
        }
        return toBST(nums, 0, nums.length - 1);
    }

    private TreeNode toBST(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        if (left == right) {
            return new TreeNode(nums[left]);
        }
        int mid = left + (right - left) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = toBST(nums, left, mid - 1);
        root.right = toBST(nums, mid + 1, right);
        return root;
    }

    Random rand = new Random();

    // 中序遍历，选择任意一个中间位置数字作为根节点
    public TreeNode sortedArrayToBST2(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }

    private TreeNode helper(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        // 选择任意一个中间位置数字作为根节点
        int mid = (left + right + rand.nextInt(2)) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(nums, left, mid - 1);
        root.right = helper(nums, mid + 1, right);
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
