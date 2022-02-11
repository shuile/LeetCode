package cn.shui.learning_plan.beike.model;

/**
 * @author shui.
 * @date 2022/2/11.
 * @time 09:35.
 */
public class TreeNode {

    public int val;
    public TreeNode left;
    public TreeNode right;

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
