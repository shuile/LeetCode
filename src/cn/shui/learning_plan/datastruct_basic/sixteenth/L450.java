package cn.shui.learning_plan.datastruct_basic.sixteenth;

/**
 * @author shui.
 * @date 2021/9/17.
 * @time 10:19.
 * 删除二叉搜索树种的节点
 */
public class L450 {

    public TreeNode deleteNode(TreeNode root, int key) {
        return null;
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
