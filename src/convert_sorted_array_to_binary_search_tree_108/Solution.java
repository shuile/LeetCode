package convert_sorted_array_to_binary_search_tree_108;

public class Solution {

    public static void main(String[] args) {
        int[] nums = {-10, -3, 0, 5, 9};
        TreeNode node = sortedArrayToBST(nums);
        System.out.println(node.toString());
    }

    private static TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length < 1) {
            return null;
        }
        return fun(nums, 0, nums.length - 1);
    }

    private static TreeNode fun(int[] n, int min, int max) {
        if (min > max) {
            return null;
        }
        int mid = (min + max) / 2;
        TreeNode node = new TreeNode(n[mid]);
        node.left = fun(n, min, mid  - 1);
        node.right = fun(n, mid + 1, max);
        return node;
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }
}
