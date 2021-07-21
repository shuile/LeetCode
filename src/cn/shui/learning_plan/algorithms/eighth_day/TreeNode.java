package cn.shui.learning_plan.algorithms.eighth_day;

/**
 * @author shui.
 * @date 2021/7/21.
 * @time 19:41.
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
